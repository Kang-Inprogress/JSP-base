package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet0
 * url: /first0
 * 
 * addHeader와 javascript로 파라미터 값을 받아오는 동작을 구현해보았음
 */
public class FirstServlet0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		if(name != null) {
			out.print("<html><body>"
					+ "이름은 " + name + "입니다."
					+ "</body></html>");
		} else {
//			response.addHeader("Refresh", "1; url=/proj08/sp");
			out.print("<script type='text/javascript'>"
					+ "location.href='/proj08/sp2'"
					+ "</script>");
		}
	}
}
