package ch06;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentController extends HttpServlet {

  StudentDAO dao = null;
  @Override
  public void init() throws ServletException {
    dao = new StudentDAO();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
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
    try {
      BeanUtils.populate(s, req.getParameterMap());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    dao.insert(s);
    return list(req,resp);
  }

  private String list(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("students", dao.findAll());
    return "studentInfo.jsp";
  }
}
