package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

public class FlowFilterOne extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
    public FlowFilterOne() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		System.out.println("doFilter() 호출 전 one");
		chain.doFilter(request, response);
		System.out.println("doFilter() 호출 후... one");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init() 호출... one");
	}
	

}
