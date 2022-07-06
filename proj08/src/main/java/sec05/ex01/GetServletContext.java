package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServletContext
 */
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		// Downcasting. Object -> List
		List member = (List) ctx.getAttribute("member"); 
		
		out.print("<html><body>");
		for(Object obj: member) {
			out.print(obj + "<br>");
		}
		/*
		for(int i=0; i<member.size(); i++) {
			out.print(member.get(i) + "<br>");
		}
		*/
		out.printf("</body></html>");
	}

}
