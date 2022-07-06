package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 * <servlet>
    <description></description>
    <display-name>InitParamServlet</display-name>
    <servlet-name>InitParamServlet</servlet-name>
    <servlet-class>sec06.ex01.InitParamServlet</servlet-class>
    <init-param>
      <description></description>
      <param-name>email</param-name>
      <param-value>yamato55@test.com</param-value>
    </init-param>
    <init-param>
      <description></description>
      <param-name>tel</param-name>
      <param-value>010-6493-3039</param-value>
    </init-param>
    <init-param>
      <description></description>
      <param-name>address</param-name>
      <param-value>부산시 사상구 주례동 동서대학교</param-value>
    </init-param>
  </servlet>
  web.xml에 저장되어 있는 형태
  url: /sinit, /sinit2
 */
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		String address = getInitParameter("address");
		
		out.print("<html><body>");
		String data = "<table><tr><td>email</td><td>" + email + "</td></tr>"
				+ "<tr><td>tel</td><td>" + tel + "</td></tr>"
				+ "<tr><td>address</td><td>"+ address +"</td></tr></table>";
		
		out.print(data + "</body></html>");
	}

}
