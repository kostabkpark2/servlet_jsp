package ch06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/students")
public class StudentController extends HttpServlet {

  StudentDAO dao = null;
  @Override
  public void init() throws ServletException {
    dao = new StudentDAO();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String view = "";
    String path ="/ch06/";
    if(action == null) {
      action = "list";
    }
    switch (action) {
      case "list" : view = list(req, resp); break;
      case "insert" : view = insert(req, resp); break;
    }
    req.getRequestDispatcher(path+view).forward(req, resp);
  }

  private String insert(HttpServletRequest req, HttpServletResponse resp) {
    Student s = new Student();
    s.setId(7);
    s.setUsername("추신수");
    s.setUniv("Univ");
    s.setBirth(Date.valueOf("1990-01-01"));
    s.setEmail("choo@aa.com");
    dao.insert(s);
    return null;
  }

  private String list(HttpServletRequest req, HttpServletResponse resp) {
    //System.out.println(dao.findAll());
    req.setAttribute("students", dao.findAll());
    return "studentInfo.jsp";
  }
}
