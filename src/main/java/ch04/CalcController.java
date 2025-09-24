package ch04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calControl")
public class CalcController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int n1 = Integer.parseInt(req.getParameter("n1"));
    int n2 = Integer.parseInt(req.getParameter("n2"));
    String op = req.getParameter("op");
    Calculator cal = new Calculator();
    cal.setN1(n1);
    cal.setN2(n2);
    cal.setOp(op);
    long result = cal.calc();
    req.setAttribute("result", result);
    req.getRequestDispatcher("/ch04/calcResult.jsp").forward(req, resp);
  }
}
