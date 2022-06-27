package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy()");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("id: " + user_id);
		System.out.println("pw: " + user_pw);
		
		if(user_id != null && user_id.length() != 0) {
			// 문자열 비교가 필요한 경우, '==' 사용시 무조건 불일치하므로 객체 비교 메소드 equals 사용!
			if(user_id.equals("admin")) {
				out.print("<html><head><title>로그인 결과 확인</title></head>"
						+ "<h3>관리자로 로그인 했습니다</h3>"
						+ "<br><input type='button' value='회원정보 수정하기' onClick=''/>"
						+ "<br><input type='button' value='회원정보 삭제하기' onClick=''/>"
						+ "<br><a href='http://localhost:8099/proj06/test01/login.html'>로그인 창으로 이동하기</a>"
						+ "<body></body></html>");
			} else {
				out.print("<html><head><title>로그인 결과 확인</title></head>"
						+ user_id + "님이 로그인 했습니다"
						+ "<br><a href='http://localhost:8099/proj06/test01/login.html'>로그인 창으로 이동하기</a>"
						+ "<body></body></html>");
			}
		} else {
			out.print("<html><head><title>로그인 결과 확인</title></head>"
					+ "아이디를 입력하십시오!"
					+ "<br><a href='http://localhost:8099/proj06/test01/login.html'>로그인 창으로 이동하기</a>"
					+ "<body></body></html>");
		}
	}

}
