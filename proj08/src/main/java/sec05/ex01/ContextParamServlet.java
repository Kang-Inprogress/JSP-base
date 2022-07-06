package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 * ServletContext 사용
 */
@WebServlet("/ctxParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		String menu_member = ctx.getInitParameter("menu_member");
		String menu_order = ctx.getInitParameter("menu_order");
		String menu_goods = ctx.getInitParameter("menu_goods");
		
		out.print("<html><body>"
				+ "<table border='1' cellspacing='0' cellpadding='5'>"
				+ "<tr><td>메뉴 이름</td></tr>"
				+ "<tr><td>" + menu_member + "</td></tr>"
				+ "<tr><td>" + menu_order + "</td></tr>"
				+ "<tr><td>" + menu_goods + "</td></tr>");
		
		out.print("</table></body></html>");
	}

}
