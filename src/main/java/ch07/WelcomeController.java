package ch07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getMethod().equals("GET")) {
      Cookie[] cookies = req.getCookies();
      for (Cookie cookie:cookies) {
        if(cookie.getName().equals("memberId")) {
          req.setAttribute("id", cookie.getValue());
          req.getRequestDispatcher("/ch07/welcome.jsp").forward(req,resp);
        }
      }
      req.getRequestDispatcher("/ch07/loginForm.jsp").forward(req,resp);
    }
  }
}
