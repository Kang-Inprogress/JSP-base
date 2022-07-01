package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegister
 * webservlet: /memberRegister
 */
@WebServlet("/MR")
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("member register init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("member register destroy");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doHandle(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// GET과 POST를 모두 처리할 수 있도록 메소드를 하나 더 만들어주는 것. 딱히 doHandle 이라는 이름이 아니어도 되고 기능만 같으면 됨
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		MemberDAO dao = new MemberDAO();
		Exception ExceptionMSG = null;
		
		if(command != null && command.equals("addMember")) {
			MemberVO vo = new MemberVO();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			vo.setId(id); vo.setPwd(pwd); vo.setName(name); vo.setEmail(email);
			
			ExceptionMSG = dao.addMember(vo);
		} else if(command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			ExceptionMSG = dao.delMember(id);
		}
		
		// response
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>명령 수행</title></head>");
		if (ExceptionMSG != null) {
			out.print("<p>" + ExceptionMSG + "</p>");
		}
		out.print("<body><a href='/proj07/MS2'>조회로 이동</a></body>"
				+ "</html>");
	}

}
