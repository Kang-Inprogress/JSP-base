package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/login")
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
				
				// 사용자가 모든 쿠키 사용을 차단한 경우 URL에 jessessionid를 연결하여 전달하면서 재요청
				// 메서드에서 차단 여부 판단을 자동으로 진행하며, encodeURL시 jessessionid를 함께 인코딩하여 전달
				String url = response.encodeURL("login"); // 매개변수로 매핑한 이름을 전달하기 위함
				
				out.print("<a href='" + url + "'>로그인 상태 확인</a>");
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
