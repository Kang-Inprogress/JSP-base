package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 * url: /set
 */
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP Programming", "utf-8"));
		
		// Cookie는 파일로 저장, SessionCookie는 메모리에 저장한다
//		cookie.setMaxAge(24 * 60 * 30);
		cookie.setMaxAge(-1); // SessionCookie로 변환
		response.addCookie(cookie); // 생성&설정된 쿠키를 전송
		
		out.print("현재 시간" + date);
		out.print("문자열 cookie에 저장합니다");
	}

}
