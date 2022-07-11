package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAttribute
 * url : /get
 */
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 각 영역마다 값을 얻어와서 출력이 가능한지 확인 해보는 것
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession ses = request.getSession();
		
		String ctxMsg = (String) ctx.getAttribute("ctx");
		String sesMsg = (String) ses.getAttribute("ses");
		String reqMsg = (String) request.getAttribute("req");
		
		out.print("<html><body>"
				+ "<p>context message: " + ctxMsg + "<br></p>"
				+ "<p>session message: " + sesMsg + "<br></p>"
				+ "<p>request message: " + reqMsg + "<br></p>"
				+ "</body><html>");
	}

}
