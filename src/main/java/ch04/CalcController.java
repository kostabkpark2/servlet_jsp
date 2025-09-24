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
    //  int n1 = Integer.parseInt(req.getParameter("n1"));
//  int n2 = Integer.parseInt(req.getParameter("n2"));
//  String op = req.getParameter("op");
//  long result = 0L;
//    switch (op) {
//    case "+" : result = n1 + n2; break;
//    case "-" : result = n1 - n2; break;
//    case "*" : result = n1 * n2; break;
//    case "/" : result = n1 / n2; break;
//  }
//    resp.setContentType("text/html; charset=utf-8");
//  PrintWriter writer = resp.getWriter();
//    writer
//        .append("<html><head></head>")
//        .append("<body><h2>계산결과</h2><hr>")
//        .append(n1 + op + n2 + "=" + result +"입니다.")
//        .append("</body></html>");
  }


}
