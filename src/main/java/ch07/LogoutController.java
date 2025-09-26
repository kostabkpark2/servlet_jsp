package ch07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    if(session != null) {
      Cookie cookie = new Cookie("sessionId", session.getAttribute("sessionId").toString());
      cookie.setMaxAge(0);
      resp.addCookie(cookie);
    }
  }
}
