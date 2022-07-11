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
 * Servlet implementation class SetAttribute
 * url : /set
 */
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 스코프(영역)별 속성값을 바인딩해서 값을 알아보기 위함
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ctxMsg = "Context message";
		String sesMsg = "Session message";
		String reqMsg = "Request message";
		
		ServletContext ctx = getServletContext();
		HttpSession ses = request.getSession();
		
		ctx.setAttribute("ctx", ctxMsg);
		ses.setAttribute("ses", sesMsg);
		request.setAttribute("req", reqMsg);
		
		out.print("<html><body>"
				+ "성공적으로 값이 바인딩 되었습니다. 3초 후 이동합니다."
				+ "</body></html>");
		response.setHeader("Refresh", "3; url=get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
