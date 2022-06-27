package sec03.ex02;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Servlet implementation class LoginServlet4
 */
public class LoginServlet4 extends HttpServlet {
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destory");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet init");
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost init");
		doHandle(request, response);
	}
	// 이 메서드는 Get, Post가 모두 핸들링되는 메소드로 직접 제작해주었
	// 이 클래스에서만 사용되어야 하기 때문에 private 접근제어자가 어울림
	// 예외는 ServletException, IOException으로 던져서 메인 클래스에서 처리가 이루어지도록 작성해줌
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("User id: " + id + "\nUser pw: " + pw);
	}
}
