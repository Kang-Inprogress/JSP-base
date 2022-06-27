package sec01.ex02;

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
 * Servlet implementation class calc
 */
@WebServlet("/calc1")
public class calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final float USD_RATE = 0.00077f;
	private static final float JPY_RATE = 0.1f;
	private static final float CNY_RATE = 0.0052f;
	private static final float GBP_RATE = 0.00063f;
	private static final float EUR_RATE = 0.00073f;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("calc - init()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("calc - destory()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); // 항상 지정
		PrintWriter pw = response.getWriter();
		String cmd = request.getParameter("command");
		String won = request.getParameter("won");
		String op = request.getParameter("operator");
		
		if(cmd != null && cmd.equals("calculate")) { // 제대로 된 값이 있을 경우 계산이 진행 됨
			String result = calculate(Float.parseFloat(won), op);
			String data = "<html><font size=10>변환 결과</font><br>"
					+ "<font size=10>" + result + "</font><br>"
					+ "<a href='/proj06/calc1'>환율 계산기</a></html>"; // 파라미터를 모두 날려버리고 초기상태의 'proj06/calc1'을 호출하는것
			pw.print(data);
			return;
		}
		pw.print("<html>");
		pw.print("<title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/proj06/calc1'>");
		pw.print("원화 : <input type='text' name='won'/>");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='pound'>파운드</option>"); 
		pw.print("<option value='wian'>위안</option>"); 
		pw.print("<option value='euro'>유로</option>"); 
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate' />"); // 숨겨져서 전달 받는 파라미터
		pw.print("<input type='submit' value='변환'/>");
		pw.print("</form>");
		pw.print("</html>");
	}
	
	private static String calculate(float won, String operator) {
		float result = 0f;
		
		if(operator.equals("dollar")) {
			result = won * USD_RATE;
		} else if(operator.equals("en")) {
			result = won * JPY_RATE;
		} else if(operator.equals("wian")) {
			result = won*CNY_RATE;
		} else if(operator.equals("pound")) {
			result = won*GBP_RATE;
		} else if(operator.equals("euro")) {
			result = won*EUR_RATE;
		}
		return String.format("%.4f", result);
	}

}
