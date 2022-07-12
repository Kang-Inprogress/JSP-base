package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 * url: /logout
 */
public class LogoutServlet extends HttpServlet {
	ServletContext context;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		context = getServletContext();
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("id");
		List conn_list = (List) context.getAttribute("userid_list");
		/*
		for(int i=0; i<conn_list.size(); i++) {
			String item = (String)conn_list.get(i);
			if(item.equals(user_id)) {
				conn_list.remove(i);
				conn_list.sort(null); // 오름차순: Comparator.naturalOrder(), 내림차순: Comparator.reverseOrder()
				break;
			}
		}
		*/
		// 기존 세션 소멸: request를 요청한 해당 브라우저에서 더 이상 session을 쓰지 않는 것 = 사용자 수 감소
		HttpSession session = req.getSession();
		session.invalidate();
		
		// 접속자 리스트에서도 제거
		conn_list.remove(user_id);
		context.setAttribute("userid_list", conn_list);
		
		out.print("<html><head><title>로그아웃</title>"
				+ "<script type='text/javascript'>"
				+ "window.onload = alert('로그아웃 되었습니다');"
				+ "</script></head><body>"
				+ "<h4>로그인 한 유저 목록</h4>");
		for(int i=0; i<conn_list.size(); i++) { // item = 로그인한 유저 목록에서 값을 받아 왔기 때문에 로그인 한 유저 아이디이다
			String item = (String) conn_list.get(i);
			out.println(item + "<br>");
		}
		out.print("</body></html>");
	}
}
