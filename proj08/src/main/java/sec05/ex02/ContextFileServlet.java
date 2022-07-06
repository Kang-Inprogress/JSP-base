package sec05.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 * url: /ctxfileServlet
 */
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		
		// 파일을 읽어들이는 스트림 객체
		InputStream is = ctx.getResourceAsStream("/WEB-INF/bin/init.txt"); // Path 위치: Properties -> Path
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		// Tokenized
		while((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		out.print("<html><body>"
				+ "<table border='1' cellspacing='0' cellpadding='5'>"
				+ "<tr><td>메뉴 이름</td></tr>"
				+ "<tr><td>" + menu_member + "</td></tr>"
				+ "<tr><td>" + menu_order + "</td></tr>"
				+ "<tr><td>" + menu_goods + "</td></tr>");
		out.print("</table></body></html>");
	}

}
