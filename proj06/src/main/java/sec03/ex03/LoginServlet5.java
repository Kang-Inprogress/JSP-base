package sec03.ex03;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet5
 */
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destory");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// call value from HTML form
		String id = request.getParameter("user_id"); 
		String pw = request.getParameter("user_pw");
		String addr = request.getParameter("user_address");
		
		// System.out.println("User id: " + id + "\nUser pw: " + pw);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<html>"
				+ "<head><title>SPEAR_R</title></head>"
				+ "<body>"
				+ "비밀번호: " + pw + "<br>"
				+ "아이디: " + id + "<br>"
				+ "주소: " + addr +"<br>"
				+ "!다겁즐 !아";
		data += "</body></html>";
		
		out.print(data);
	}

}
