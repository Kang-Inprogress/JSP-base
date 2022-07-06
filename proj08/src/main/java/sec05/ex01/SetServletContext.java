package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetServletContext
 * url: /ctxset
 */
public class SetServletContext extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		// member 참조 변수에 ArrayList 객체 생성
		List member = new ArrayList(); // Upcasting. <E>는 여러가지 자료형이 들어갈 것이라서 명시하지 않음
		member.add("이순신");
		member.add(30);
		member.add("lee");
		member.add(3.14f);
		
		ctx.setAttribute("id", "lee");
		ctx.setAttribute("member", member); // "member": [value] 형태로 저장
		out.print("<html><body>"
				+ "<h3>ServletContext 객체 이순신과 30을 함께 member으로 바인딩</h3>"
				+ "</body></html>");
		response.addHeader("Refresh", "3; url=ctxget");
	}

}
