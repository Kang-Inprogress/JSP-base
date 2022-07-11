package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServlet2
 * 디렉터리 명(/first)인데 존재하지 않는다면 이 서블릿에서 GET에 대해서 작업을 한다
 */
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();		// 컨텍스트 이
		String url = request.getRequestURL().toString();// 전체 url
		String uri = request.getRequestURI().toString();// uri
		String mapping = request.getServletPath();		// 서블릿 매핑명
		
		out.print("<html><title>TestServlet2</title><body bgcolor='yellow'>"
				+ "<h4>TestServlet2 - Except '/first/test'</h4>"
				+ "<p><b>컨텍스트 이름: " + context + "</b></p>"
				+ "<p><b>URL: " + url + "</b></p>"
				+ "<p><b>URI: " + uri + "</b></p>"
				+ "<p><b>mapping: " + mapping + "</b></p>"
				+ "</body></html>");
	}

}
