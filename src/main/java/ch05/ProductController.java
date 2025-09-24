package ch05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    List<Product> products = new ArrayList<>();
    Product product = null;
    String id = "";
    switch (action) {
      case "list" :
        products = service.findAll();
        System.out.println(products);
        break;
      case "info" :
        id = req.getParameter("id");
        product = service.find(id);
        System.out.println(product);
        break;
    }
  }
}
