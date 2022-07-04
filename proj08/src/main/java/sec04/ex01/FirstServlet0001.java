package sec04.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet0001
 * 
 * 바인딩으로 파라미터를 넘기는 실습
 */
public class FirstServlet0001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		request.setAttribute("address", "서울시 성북구"); // address라는 변수를 '서울시 성북구' 라는 문자열로 바인딩 함
		// Redirect 방식으로는 Attribute값을 제대로 넘길 수 없다
//		response.sendRedirect("second0001"); 
		
		// Servlet내에서 데이터를 저장한 것을 유지하며 다른 페이지로 넘어갈 수 있는(웹 브라우저를 거치지 않고 즉시 서버로 전달) Dispatch 방식을 사용해야함
		request.getRequestDispatcher("second0001").forward(request, response);
		
	}

}
