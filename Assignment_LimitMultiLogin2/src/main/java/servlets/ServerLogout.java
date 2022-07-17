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
		
		String id = req.getParameter("id");
		ctx = getServletContext();
		HttpSession session = req.getSession();
		session.invalidate();// 세션 소멸
		
		List<LoginInformation> name_list = (List<LoginInformation>) ctx.getAttribute("name_list");
		for(int i=0; i<name_list.size(); i++) {
			LoginInformation userInfo = name_list.get(i);
			if(userInfo.getId().equals(id)) {
				if(userInfo.current_login != 0) {
					userInfo.current_login--;
					name_list.set(i, userInfo);
				} else {
					name_list.remove(i);
				}
			}
		}
		ctx.setAttribute("name_list", name_list);
		
		
		// 화면에 표시, 리다이렉트
		resp.addHeader("Refresh", "1; url=login.html");
	}

}
