package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletServer
 */
public class ServletServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		ctx = getServletContext();
		HttpSession session = req.getSession();
		
		int namelistIndex = 0;
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		HttpSessionListenerImplement hsli = new HttpSessionListenerImplement(id, pwd);
		
		List<HttpSessionListenerImplement> user_list = (List<HttpSessionListenerImplement>) session.getAttribute("user_list");
		if(user_list == null || user_list.size() == 0) {
			user_list = new ArrayList<HttpSessionListenerImplement>();
		}
		List<LoginInformation> name_list = (List<LoginInformation>) ctx.getAttribute("name_list");
		if(name_list == null || name_list.size() == 0) {
			name_list = new ArrayList<LoginInformation>();
		}
		// 첫 연결 세션인 경우, 컨텍스트의 유저 이름을 조회해서 로그인 하려고하는 유저의 이름이 있는지 확인
		// 리스트에서 발견된 경우 Deny
		if(session.isNew()) {
			// 컨텍스트에서 조회
			for(int i=0; i<name_list.size(); i++) { // 컨텍스트도 새것이라면 지나침
				LoginInformation userInfo = name_list.get(i);
				if(userInfo.getId().equals(id) && !(userInfo.isLimit())) {
					userInfo.current_login++;
					name_list.set(i, userInfo);
					namelistIndex = i;
				} else {
					out.print("<script>alert('최대 로그인 횟수에 도달했습니다');location.href='login.html';</script>");
					session.invalidate();
					break;
				}
			}
			LoginInformation userInfo = new LoginInformation(hsli.getId());
			user_list.add(hsli);
			session.setAttribute("user_list", user_list);
			name_list.add(userInfo);
			ctx.setAttribute("name_list", name_list);
			namelistIndex = 0;
		} else {
			// 조회(세션에서)
			for(int i=0; i<name_list.size(); i++) {
				LoginInformation userInfo = name_list.get(i);
				if(userInfo.getId().equals(id) && !(userInfo.isLimit())) {
					// 세션이 연결되어 있고, 세션에서 접속한 기록이 있다면 컨텍스트에서 해당 이름의 유저를 찾아서 리미트 확인
					// 리미트 내라면 숫자를 추가, 아니라면 바로 종료
					userInfo.current_login++;
					name_list.set(i, userInfo);
					namelistIndex = i;
					break; 
				} else {
					// 세션이 연결된 적이 있지만 접속한 기록이 없다면 로그인 창으로
					out.print("<script>location.href='login.html';</script>");
				}
			}
		}
		
		out.print("<html><head><script type='text/javascript'>"
//				+ "setTimeout(()=>location.reload(), 3000);"
				+ "</script></head><body>"
				+ "당신의 아이디: " + id + "<br>"
				+ "현재 접속자 수: " + hsli.user_count + "<br>"
				+ "당신의 아이디로 동시 접속한 사람의 수:" +  name_list.get(namelistIndex).current_login);
		out.print("<a href='logout?id=" + id + "'>로그아웃</a>" + "<br>"
				+ "</body></html>");
	}
}
