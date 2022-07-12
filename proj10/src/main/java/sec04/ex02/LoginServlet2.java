package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet2
 * url: /login2
 */

public class LoginServlet2 extends HttpServlet {
	ServletContext context;
	List<String> userid_list = new ArrayList<String>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		context = getServletContext();
		HttpSession session = request.getSession();
		
		// event handler 객
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		
		// 최초 로그인 시 접속자 정보를 세션에 바인딩
		if(session.isNew()) {
			// 로그인한 유저를 세션에 바인딩 
			session.setAttribute("loginUser", loginUser); 
			// 접속자 리스트에 회원 추가
			userid_list.add(user_id);
			// 세션에 바인딩 한 로그인 유저 리스트를 컨텍스트로 바인딩
			context.setAttribute("userid_list", userid_list);
		}
		
		// 접속된 아이디 리스트
		List conn_list = (List) context.getAttribute("userid_list");
		
		out.print("<html><head><title>접속 회원 확인</title>"
				+ "<script type='text/javascript'>"
				+ "setTimeout('history.go(0);', 5000)"
				+ "</script></head>"
				+ "<body>"
				+ "접속자 아이디: " + loginUser.user_id + "<br>"
				+ "접속자 비밀번호: " + loginUser.user_pwd + "<br>"
				+ "접속자 인원 수: " + loginUser.total_user + "<br>"
				+ "[접속자 인원]<br>");
		for(int i=0; i<conn_list.size(); i++) {
			String item = (String) conn_list.get(i);
			out.println(item + "<br>");
		}
				
		out.print("<a href='logout?id=" + loginUser.user_id + "'>로그아웃</a>"
				+ "</body></html>");
	}

}
