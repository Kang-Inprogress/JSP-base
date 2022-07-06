package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 * url: /login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; chartset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String user_address = req.getParameter("user_address");
		String user_email = req.getParameter("user_email");
		String user_hp = req.getParameter("user_hp");
		
		out.print("<html><body>"
				+ "<h3>반갑다!</h3>"
				+ "ID: " + user_id + "<br>"
				+ "PW: " + user_pw + "<br>"
				+ "E-mail: " + user_email + "<br>"
				+ "ADDRESS: " + user_address + "<br>"
				+ "HP: " + user_hp + "<br>" );
		out.print("</body></html>");
	}

}
