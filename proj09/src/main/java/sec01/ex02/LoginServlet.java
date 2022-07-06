package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 * 
 */
@WebServlet("/login1")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet1 init");
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
				+ "<h3>!다갑반</h3>"
				+ "ID: " + user_id + "<br>"
				+ "PW: " + user_pw + "<br>"
				+ "E-mail: " + user_email + "<br>"
				+ "ADDRESS: " + user_address + "<br>"
				+ "HP: " + user_hp + "<br>" );
		out.print("</body></html>");
		
		user_address = URLEncoder.encode(user_address, "utf-8"); // 한글이 깨지지 않도록 사용
		String url_link = "<a href='/proj09/second?user_id=" + user_id 
				+ "&user_pw=" + user_pw + ""
				+ "&user_address=" + user_address + " '>두번째 서블릿으로 보내기</a>";
		out.print(url_link);
	}

}
