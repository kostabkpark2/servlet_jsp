package ch07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getMethod().equals("GET")) {
      Cookie[] cookies = req.getCookies();
      HttpSession session = req.getSession();
      for (Cookie cookie:cookies) {
        if(cookie.getName().equals("sessionId")) {
          System.out.println(cookie.getValue());
          System.out.println(session.getAttribute("sessionId").toString());
          if( session != null && session.getAttribute("sessionId").toString().equals(cookie.getValue())) {
            System.out.println("로그인한 사용자 인지");
            req.setAttribute("id", session.getAttribute("memberId").toString());  //cookie.getValue());
            req.setAttribute("username", session.getAttribute("username").toString());  //cookie.getValue());
            req.getRequestDispatcher("/ch07/welcome.jsp").forward(req,resp);
          }

        }
      }
      req.getRequestDispatcher("/ch07/loginForm.jsp").forward(req,resp);
    }
  }
}
