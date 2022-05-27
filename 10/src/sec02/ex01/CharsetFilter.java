package sec02.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CharsetFilter implements Filter{
	private String charset = "utf-8";
	private FilterConfig fc;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fc = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리
		System.out.println("전처리");
		request.setCharacterEncoding(charset);
		HttpServletRequest req = (HttpServletRequest) request;
		long start = System.currentTimeMillis();
		chain.doFilter(request, response); // 실제 서블릿이 수행할 일
		
		// 후처리
		System.out.println(req.getRequestURI() + "의 소요시간 : " + (System.currentTimeMillis() - start) + "ms");
		System.out.println("후처리");
		
	}

	@Override
	public void destroy() {
		
	}
}