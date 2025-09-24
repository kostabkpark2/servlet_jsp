package ch04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 요청을 처리해주는 dispatcher 를 찾아서 forward
    RequestDispatcher disp = req.getRequestDispatcher("/ch04/forward.jsp");
    req.setAttribute("sharedInfo", "hello");
    disp.forward(req, resp);
  }
}
