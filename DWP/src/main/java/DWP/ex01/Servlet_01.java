package DWP.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class Servlet_01
 */
@WebServlet("/login")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void destroy() {
    	System.out.println("서블릿이 작동이 중지됩니다");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("서블릿이 시작되었습니다");
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()) {
			// 파라미터로 넘어오는 이름 출력
			String name = (String)e.nextElement();
			System.out.println("parameter name: " + name);
			// 파라미터로 넘어온 같은 이름의 다수의 값 출력
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name=" + name + ", value=" + value);
			}
		}
		System.out.println();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("id: " + id + "\tpw: " + pw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
