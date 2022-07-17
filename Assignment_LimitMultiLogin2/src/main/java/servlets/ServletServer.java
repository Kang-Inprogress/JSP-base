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
				if(userInfo.user_name.equals(id) && userInfo.current_login < 4) { // 매칭 되었고 리미트에 안걸림
					userInfo.current_login++;
					hsli.setCL(userInfo.current_login);
					user_list.add(hsli);
					session.setAttribute("user_list", user_list);
					name_list.set(i, userInfo);
					ctx.setAttribute("name_list", name_list);
					namelistIndex = i;
				} else if(userInfo.user_name.equals(id) && userInfo.current_login >= 4){
					out.print("<script>alert('최대 로그인 횟수에 도달했습니다');location.href='login.html';</script>");
					session.invalidate();
					break;
				}
			} // 컨텍스트에도 아무런 정보가 없는 경우
			LoginInformation userInfo = new LoginInformation(id, hsli.getCL());
			user_list.add(hsli);
			session.setAttribute("user_list", user_list);
			name_list.add(userInfo);
			ctx.setAttribute("name_list", name_list);
			namelistIndex = 0;
		} else {
			// 조회
			for(int i=0; i<user_list.size(); i++) {
				HttpSessionListenerImplement hsli_ = user_list.get(i);
				
				if(!(hsli_.getId().equals(id))) { // 현재 세션에 로그인 없는 경우
					for(int j=0; j<name_list.size(); j++) { // 컨텍스트에서 한번 더 찾는다
						LoginInformation userInfo = name_list.get(j);
						
						if(userInfo.user_name.equals(id)) { // 컨텍스트에서 발견 된 경우
							userInfo.current_login++;
							hsli.setCL(userInfo.current_login); // hsli에 컨텍스트에 저장된 기록을 받아 세션에 삽입한다
							user_list.set(i, hsli);
							session.setAttribute("user_list", user_list);
							name_list.set(j, userInfo);
							ctx.setAttribute("name_list", name_list);
						}
					}
				} // 현재 세션에 로그인 정보가 있으면 아무것도 하지않는
			}
		}
		
		out.print("<html><head><script type='text/javascript'>"
				+ "setTimeout(()=>location.reload(), 3000);"
				+ "</script></head><body>"
				+ "당신의 아이디: " + id + "<br>"
				+ "현재 접속자 수: " + hsli.user_count + "<br>"
				+ "당신의 아이디로 동시 접속한 사람의 수: " +  name_list.get(namelistIndex).current_login + "<br>");
		out.print("<a href='logout?id=" + id + "'>로그아웃</a>" + "<br>"
				+ "</body></html>");
	}
}
