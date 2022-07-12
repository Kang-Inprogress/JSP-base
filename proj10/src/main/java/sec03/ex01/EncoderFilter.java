package sec03.ex01;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncoderFilter
 * @WebFilter("/*") : 에너테이션을 이용해 모든 요청이 필터를 우선 거쳐서 요청 작업을 수행하도록 함
 * @WebFilter("/EncoderFilter")
 */
public class EncoderFilter implements Filter {
      ServletContext context;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncoderFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter()");
		// place your code here(요청 필터)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("인코딩 필터 요청 시작");
		long begin_time = System.currentTimeMillis(); // 요청 처리 전의 시간
	
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// place your code here(응답 필터)
		long end_time = System.currentTimeMillis(); // 요청 처리 후 시간
		System.out.println("작업 시간은 " + (end_time - begin_time) + "ms 입니다. ");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
		System.out.println("init : 인코딩 UTF-8");
	}

}
