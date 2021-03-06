package sec01.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//   
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy()호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		// 파라미터 받아서 콘솔에 출력. 홈페이지에는 [address]?user_id=[value]&user_pw=[value] 이렇게 표시됨
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("ID: " + user_id);
		System.out.println("PW: " + user_pw);
		
		// Print all parameter values by .getParameterNames
		Enumeration<String> e = request.getParameterNames();
		Iterator<String> I = e.asIterator();
		/* Enumeration을 사용할 경우
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name: " + name + "\t values: " + value);
			}
		}
		*/
		// Iterator을 사용
		while(I.hasNext()) {
			String name = I.next();
			String[] values = request.getParameterValues(name);
			for(String value: values) {
				System.out.println("name: " + name + "\t value: " + value);
			}
		}
		
		System.out.println("====Only Subject====");
		String[] sbj = request.getParameterValues("subject");
		for(String subject : sbj) {
			System.out.println("subject: " + subject);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
	}

}
