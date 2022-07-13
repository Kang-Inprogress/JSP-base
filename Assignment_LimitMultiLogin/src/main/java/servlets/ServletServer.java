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
		
		List<HttpSessionListenerImplement> user_list = new ArrayList<HttpSessionListenerImplement>();
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
				if(name.equals(id)) { // 로그인 됨 처리
					out.print("<script>alert('이미 로그인 되어있음!'); location.href='login.html';</script>");
				}
			}
			user_list.add(hsli);
			session.setAttribute("user_list", user_list);
			name_list.add(hsli.getId());
			ctx.setAttribute("name_list", name_list);
		} else {
			// 조회
			for(int i=0; i<name_list.size(); i++) { 
				String name = name_list.get(i);
				if(name.equals(id)) { // 로그인 됨 처리
					out.print("<script>alert('이미 로그인 되어있음!'); location.href='login.html';</script>");
				}
			}
		}
		
		out.print("<html><head><script type='text/javascript'>"
//				+ "setTimeout(()=>location.reload(), 3000);"
				+ "</script></head><body>"
				+ "당신의 아이디: " + id + "<br>"
				+ "현재 접속자 수: " + hsli.user_count + "<br>");
		out.print("<a href='/logout?id=" + id + "'>로그아웃</a>" + "<br>"
				+ "</body></html>");
	}

}
