package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServerLogout
 */
public class ServerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * url : /logout
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		ctx = getServletContext();
		HttpSession session = req.getSession();
		session.invalidate();
		
		List<String> name_list = (List<String>) ctx.getAttribute("name_list");
		name_list.remove(id);
		ctx.setAttribute("name_list", name_list);
		
		// 세션 소멸
//		for(int i=0; i<user_list.size(); i++) {
//			String loginedId = user_list.get(i).getId();
//			if(loginedId.equals(id)) {
//				user_list.remove(i);
//				session.invalidate();
//			} else { //error
//				out.print("<script>alert('alert');</script>");
//			}
//		}
		// 화면에 표시, 리다이렉트
		resp.addHeader("Refresh", "3; url=login.html");
	}

}
