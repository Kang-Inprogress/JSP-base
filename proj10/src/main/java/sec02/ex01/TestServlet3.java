package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TestServlet3
 * url: *.do (.do확장자는 모두 이곳으로 맵핑)
 * TestServlet2에서 /first 디렉터리 아래의 존재하지 않는 파일을 모두 GET 처리를 진행하므로 
 * /first가 아닌 디렉터리의 .do 확장자인 파일을 요청한다면 이 TestServlet3가 표시된다 
 */
@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
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
		
		out.print("<html><title>TestServlet3</title><body bgcolor='blue'>"
				+ "<h4>TestServlet3 - .do mapping</h4>"
				+ "<p><b>컨텍스트 이름: " + context + "</b></p>"
				+ "<p><b>URL: " + url + "</b></p>"
				+ "<p><b>URI: " + uri + "</b></p>"
				+ "<p><b>mapping: " + mapping + "</b></p>"
				+ "</body></html>");
	}

}
