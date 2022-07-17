package servlets;

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
 * Servlet implementation class ServerLogout
 */
public class ServerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * url : /logout
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String id = req.getParameter("id");
		ctx = getServletContext();
		HttpSession session = req.getSession();
		
		
		// 해당 세션의 리스트 받아와서 로그아웃 하는 정보 체크, 컨텍스트도 조회
		List<LoginInformation> name_list = (List<LoginInformation>) ctx.getAttribute("name_list");
		
		
		// 세션이 있다는 것은 컨텍스트에 한 번이라도 정보가 업로드 된 것으로 볼 수 있으므로, 컨텍스트에 바로 조회를 진행
		for (int i = 0; i < name_list.size(); i++) { 
			LoginInformation userInfo = name_list.get(i);
			if(userInfo.user_name.equals(id)) {
				userInfo.current_login--;
				if(userInfo.current_login == 0) { // 접속자가 없는 아이디는 컨텍스트로부터 삭제
					name_list.remove(i);
					break;
				} else {
					name_list.set(i, userInfo);
					break;
				}
			}
		}
		session.invalidate();// 세션 소멸
		ctx.setAttribute("name_list", name_list);
		
		
		// 화면에 표시, 리다이렉트
		resp.addHeader("Refresh", "1; url=login.html");
	}

}
