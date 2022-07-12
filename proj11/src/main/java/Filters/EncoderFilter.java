package Filters;

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
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// place your code here(응답 필터)
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
		System.out.println("init : 인코딩 UTF-8");
	}

}
