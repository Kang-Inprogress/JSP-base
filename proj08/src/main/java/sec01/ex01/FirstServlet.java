package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 * 
 * first 는 Redirect
 * first1은 Refresh(1 second)
 * first2는 javascript의 location.href
 * frist3는 파라미터와 함께 Redirect
 * 의 동작이 구현되어있음
 * 
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("second");
	}

}
