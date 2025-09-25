package ch05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class ProductController extends HttpServlet {
  ProductService service = null;
  @Override
  public void init() throws ServletException {
    service = new ProductService();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getMethod().equals("GET")) {
      doGet(req,resp);
    } else if (req.getMethod().equals("POST")) {
      doPost(req, resp);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Method : " + req.getMethod());
    System.out.println("Parameter : " + req.getParameter("action"));
    String action = req.getParameter("action");
    if(action == null) { action = "list"; }
    String path = "/ch05";
    String view ="";
    switch (action) {
      case "list" :
        view = list(req, resp);
        break;
      case "info" :
        view = info(req, resp);
        break;
    }
    req.getRequestDispatcher(path + view).forward(req, resp);
  }

  private String list(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("products", service.findAll());
    return "/product-list.jsp";
  }

  private String info(HttpServletRequest req, HttpServletResponse resp) {
    String id = req.getParameter("id");
    req.setAttribute("product", service.find(id));
    return "/product-info.jsp";
  }

}
