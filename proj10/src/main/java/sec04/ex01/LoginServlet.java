package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 * url: /loginSrv
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		HttpSession session = request.getSession();
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		
		if(session.isNew()) { // 새로운 세션이 만들어진 경우, 세션 영역에 새로운 접속자의 추가
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html><head><script type='text/javascript'>"
				// js에서 history.go(0)는 현재 페이지, history.go(-1) 이전 페이지, history.go(1)다음 페이지로 이동
				+ "setTimeout('history.go(0);', 5000)"
				+ "</script></head>"
				+ "<body>"
				+ "접속자 아이디:" + loginUser.user_id + "<br>"
				+ "접속자 비밀번호:" + loginUser.user_pwd + "<br>"
				+ "접속자 인원 수:" + loginUser.total_user + "<br>"
				+ "</body></html>");
	}

}
