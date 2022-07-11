package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServlet1
 * url: /first/test
 */
@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = -4708924508572872359L;

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
		
		out.print("<html><title>TestServlet1</title><body bgcolor='green'>"
				+ "<h4>TestServlet1</h4>"
				+ "<h4>TestServlet1</h4>"
				+ "<p><b>컨텍스트 이름: " + context + "</b></p>"
				+ "<p><b>URL: " + url + "</b></p>"
				+ "<p><b>URI: " + uri + "</b></p>"
				+ "<p><b>mapping: " + mapping + "</b></p>"
				+ "</body></html>");
	}

}
