package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sec01.ex02.MemberDAO;
import sec01.ex02.MemberVO;

/**
 * Servlet implementation class MemberServlet
 * websevlet : /member
 */
public class MemberServlet extends HttpServlet {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> member_list = dao.listMembers();
		
		out.print("<html><body>"
				+ "<table border='2'>"
				+ "<tr bgcolor='lightgreen'>"
				+ "<td>ID</td><td>PW</td><td>Name</td><td>EMAIL</td><td>JOIN DATE</td>"
				+ "</tr>");
		// 조회된 데이터 출력
		for(int i=0; i<member_list.size(); i++) {
			out.print("<tr>"
					+ "<td>" + member_list.get(i).getId() + "</td>"
					+ "<td>" + member_list.get(i).getPwd() + "</td>"
					+ "<td>" + member_list.get(i).getName() + "</td>"
					+ "<td>" + member_list.get(i).getEmail() + "</td>"
					+ "<td>" + member_list.get(i).getJoinDate() + "</td>"
					+ "</tr>");
		}
		out.print("</table>");
		out.print("</html></body>");
	}

}
