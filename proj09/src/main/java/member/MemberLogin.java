package member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogin
 * url: /memberLogin
 */
public class MemberLogin extends HttpServlet {
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id); vo.setPwd(user_pwd);
		
		MemberDAO dao = new MemberDAO();
		
		// 로그인할 때 회원의 존재 여부를 판단하기 위한 메서드 호출
		boolean result = dao.isExist(vo);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("user_id", vo.getId());
			session.setAttribute("user_pwd", vo.getPwd());
			
			out.print("<html><body>Hello, " + vo.getId() + " :D<br>"
					+ "<a href='show'>Show My information</a><br>"
					+ "<a href='logout'>Log Out</a>"
					+ "</body></html>");
		} else {
			out.print("<html><body>Invalid ID or PASSWORD!<br>"
					+ "<a href='login2.html'>Login</a>"
					+ "</body></html>");
		}
	}
}
