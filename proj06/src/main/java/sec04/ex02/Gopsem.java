package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Gopsem
 * WebServlet: /99dan
 */

public class Gopsem extends HttpServlet {
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String dan = request.getParameter("dan");
		int idan = Integer.parseInt(dan);
		
		String data = "<html><head><title>구구단 요청 결과</title>"
				+ "<style>table {"
				+ "	background-color: #FAFAFA;"
				+ "}"
				+ "tr {height: 37.5;}"
				+ "td {background-color: #A9F5A9; width: 75;}"
				+ "th {"
				+ "	font-weight: bold;\n"
				+ "	font-size: 21pt;\n"
				+ "	color: blue;\n"
				+ "}</style>"
				+ "</head>"
				+ "<body><table border='5'>";
		for(int i=0; i<idan; i++) {
			if(i==0) {
				/*
				data += "<tr>";
				for(int j=1; j<10; j++) {
					data += "<td>" + j + " Column" + "</td>";
				}
				data += "</tr>";
				또는
				*/
				data += "<tr><th colspan='18'>자바 웹을 다루는 기술</th></tr>";
			} else {
				data += "<tr>";
				for(int j=0; j<10; j++) {
					if(j==0) {
						if(i%2==0) {
							data += "<td><input type='radio'/>" + i + "</td>";
						} else {
							data += "<td><input type='checkbox'/>" + i + "</td>";
						}
					} else {
						data += "<td align='center'>" + i + "X" + j + "=" + i*j +"</td>"
								+ "<td><button>버튼" + j +"</button></td>";
					}
				}
				data += "</tr>";
			}
			
		}
		data += "</table></body></html>";
		out.print(data);
	}

}
