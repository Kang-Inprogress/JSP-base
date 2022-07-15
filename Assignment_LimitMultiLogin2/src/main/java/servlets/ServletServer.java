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
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		HttpSessionListenerImplement hsli = new HttpSessionListenerImplement(id, pwd);
		
		List<HttpSessionListenerImplement> user_list = (List<HttpSessionListenerImplement>) session.getAttribute("user_list");
		if(user_list == null || user_list.size() == 0) {
			user_list = new ArrayList<HttpSessionListenerImplement>();
		}
		
		List<String> name_list = (List<String>) ctx.getAttribute("name_list");
		if(name_list == null || name_list.size() == 0) {
			name_list = new ArrayList<String>();
		}
		// 첫 연결 세션인 경우, 컨텍스트의 유저 이름을 조회해서 로그인 하려고하는 유저의 이름이 있는지 확인
		// 리스트에서 발견된 경우 Deny
		if(session.isNew()) {
			// 조회
			for(int i=0; i<name_list.size(); i++) { 
				String name = name_list.get(i);
				if(name.equals(id)) { // 로그인이 매칭 되었으면
					if()
					out.print("<script>alert('이미 로그인 되어있음!'); location.href='login.html';</script>");
					session.invalidate();
					break;
				}
			}
			user_list.add(hsli);
			session.setAttribute("user_list", user_list);
			name_list.add(hsli.getId());
			ctx.setAttribute("name_list", name_list);
		} else {
			// 조회(세션에서)
			for(int i=0; i<user_list.size(); i++) {
				String name = user_list.get(i).getId();
				if(name.equals(id)) {
					// 세션이 연결되어 있고, 세션에서 접속한 기록이 있다면 반복문을 빠져나오고 아무작업 하지 않고 출력부로 이동
					break; 
				} else {
					// 세션이 연결된 적이 있지만 접속한 기록이 없다면 로그인 창으로
					out.print("<script>location.href='login.html';</script>");
				}
			}
		}
		
		out.print("<html><head><script type='text/javascript'>"
				+ "setTimeout(()=>location.reload(), 3000);"
				+ "</script></head><body>"
				+ "당신의 아이디: " + id + "<br>"
				+ "현재 접속자 수: " + hsli.user_count + "<br>");
		out.print("<a href='logout?id=" + id + "'>로그아웃</a>" + "<br>"
				+ "</body></html>");
	}

}
