package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 * url:/ second001
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String address = request.getParameter("addr");
		out.print("<html><body>"
				+ "<h3>RequestDispatcher를 이용한 포워딩 실습</h3>"
				+ "이름은 " + name + "입니다!<br>"
				+ "주소는 " + address + "입니다.<br>"
				+ "</body></html>");
	}

}
