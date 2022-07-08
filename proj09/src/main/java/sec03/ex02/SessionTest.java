package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 * url: /login
 */
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// request객체에서 getSession해서 없으면 생성해서 True 반환, 있으면 True를 반환
		// session은 브라우저 당 한 개를 가진다
		HttpSession session = request.getSession(); 
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 로그인 최초 수행 시
		if(session.isNew()) {
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				
				out.print("<a href='login'>로그인 상태 확인</a>");
			} else {
				out.print("<a href='login.html'>다시 로그인 하세요</a>");
				session.invalidate(); // session 강제 삭제
			}
		// 로그인 최초 수행이 아닐 경우
		} else {
			user_id = (String)session.getAttribute("user_id");
			
			if(user_id != null && user_id.length() != 0) {
				out.print("Hello, " + user_id + " :D");
			} else { // 세션은 존재하지만 안의 데이터(user_id)가 없는 상태
				out.print("<a href='login.html'>다시 로그인 하세요</a>");
				session.invalidate(); // session 강제 삭제
			}
		}
		
	}

}
