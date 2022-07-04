package sec03.ex01;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * Dispatcher를 이용해서 서버내에서 이동을 하기 때문에 GET 방식이라도 파라미터 값을 노출시키지 않고 이동이 가능하다 
 */
@WebServlet("/first001")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		//dispatch 방법으로 second 서블릿으로 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("second001?name=강연우&addr=부산시 해운대구 해운대로 383번길 93"); // 'proj08/'이 루트 디렉터리인 기준으로 보내진다
		dispatch.forward(request, response);
		
//		(추가)한 줄로 포워딩하는 방법
//		request.getRequestDispatcher("second001").forward(request, response);
	}

}
