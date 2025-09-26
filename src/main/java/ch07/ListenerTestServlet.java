package ch07;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class ListenerTestServlet extends HttpServlet {
  ServletContext sc;

  @Override
  public void init() throws ServletException {
    sc=getServletContext();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    sc.setAttribute("name", "홍길동");
    req.getSession().setAttribute("name", "김사랑");
  }
}
