package ch07;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/students")
public class EncodingFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req =  (HttpServletRequest) request;
    if(req.getMethod().equals("POST")) {
      req.setCharacterEncoding("utf-8");
    }
    chain.doFilter(request, response);
  }
}
