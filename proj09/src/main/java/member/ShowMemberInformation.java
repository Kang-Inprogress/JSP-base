package member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowMemberInformation
 * url: /show
 */
public class ShowMemberInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false); // false: 세션이 존재하면 세션을 반환하고 없으면 null을 반환(default: 없으면 생성함)
		if(session != null) {
			Boolean isLogOn = (Boolean) session.getAttribute("isLogOn");
			if(isLogOn) {
				String id = (String) session.getAttribute("user_id");
				String pwd = (String) session.getAttribute("user_pwd");
				out.print("<html><body>"
						+ "ID: " + id + "<br>"
						+ "PWD: " + pwd + "<br>"
						+ "<a href='logout'>Log Out</a>");
				out.print("</body></html>");
			} else { // 로그인 상태가 아님
				response.sendRedirect("login2.html");
			}
		} else { // 해당 접속에 대한 세션이 없음
			response.sendRedirect("login2.html");
		}
	}

}
