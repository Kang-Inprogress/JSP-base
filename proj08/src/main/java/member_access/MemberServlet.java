package member_access;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class MemberServlet
 * url: /viewMembers
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("membersList");
		
		out.print("<html><head><title>DB result</title></head>"
				+ "<body>"
				+ "<table border='2'>"
				+ "<tr bgcolor='lightgreen'>"
				+ "<td>ID</td><td>PW</td><td>Name</td><td>EMAIL</td><td>JOIN DATE</td><td>비고</td>"
				+ "</tr>");
		for(int i=0; i<list.size(); i++) {
			out.print("<tr>"
					+ "<td>" + list.get(i).getId() + "</td>"
					+ "<td>" + list.get(i).getPwd() + "</td>"
					+ "<td>" + list.get(i).getName() + "</td>"
					+ "<td>" + list.get(i).getEmail() + "</td>"
					+ "<td>" + list.get(i).getJoinDate() + "</td>"
					+ "<td><a href='/proj08/MR?command=delMember&id=" + list.get(i).getId() + "'>삭제</a></td>"
					+ "</tr>");
		}
		out.print("</table>"
				+ "<a href='/proj08/memberForm.html'>새 회원 등록</a>");
		out.print("</body></html>");
	}

}
