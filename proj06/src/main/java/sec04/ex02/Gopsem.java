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
		
		String data = "<html><head><title>구구단</title></head>"
				+ "<body><table>";
		for(int i=0; i<idan; i++) {
			if(i==0) {
				data += "<th>";
				for(int j=0; j<9; j++) {
					data += "<td>" + j + " Column" + "</td>";
				}
				data += "</th>";
			} else {
				data += "<tr>";
				for(int j=0; j<9; j++) {
					data += "<td>" + i + "X" + j + "=" + i*j +"</td>";
				}
				data += "</tr>";
			}
			
		}
		data += "</table></body></html>";
		out.print(data);
	}

}
