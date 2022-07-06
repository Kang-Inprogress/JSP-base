package member_access;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MemberServlet2
 * 
 */
@WebServlet("/member")
public class MemberServlet2 extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> membersList = dao.listMembers();
		
		// 회원 조회 결과를 request 객체에 memberList 이름으로 속성 값을 저장
		request.setAttribute("membersList", membersList);
		
		// 두번째 서블릿(viewMembers)으로 포워딩. viewMembers에서 '조회'에 해당하는 작업을 도맡아서 해줌
		RequestDispatcher dis = request.getRequestDispatcher("viewMembers");
		dis.forward(request, response);
	}
}
