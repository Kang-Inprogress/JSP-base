package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 * url: /second
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("SecondServlet init");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		// 전송된 아이디 값이 있는 경우, 로그인 상태임을 체크
		if(user_id != null && user_id.length() != 0) {
			out.print("<html><body>"
					+ "<h3>이미 로그인 되어 있음!</h3>"
					+ "넘겨 받은 ID: " + user_id + "<br>"
					+ "넘겨 받은 PW: " + user_pw + "<br>"
					+ "넘겨 받은 ADDRESS: " + user_address + "<br>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>"
					+ "<h3>로그인 하지 않음!</h3>"
					+ "<br><a href='/proj09/loginPage.html'>Login</a>");
			out.print("</body></html>");
		}
		
	}

}
