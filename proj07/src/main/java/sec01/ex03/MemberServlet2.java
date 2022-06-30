package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MemberServlet2
 * webserlvet: /MS2
 */
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
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><head><title>DB result</title></head>"
				+ "<body>"
				+ "<table border='2'>"
				+ "<tr bgcolor='lightgreen'>"
				+ "<td>ID</td><td>PW</td><td>Name</td><td>EMAIL</td><td>JOIN DATE</td>"
				+ "</tr>");
		for(int i=0; i<list.size(); i++) {
			out.print("<tr>"
					+ "<td>" + list.get(i).getId() + "</td>"
					+ "<td>" + list.get(i).getPwd() + "</td>"
					+ "<td>" + list.get(i).getName() + "</td>"
					+ "<td>" + list.get(i).getEmail() + "</td>"
					+ "<td>" + list.get(i).getJoinDate() + "</td>"
					+ "</tr>");
		}
		out.print("</table>");
		out.print("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
