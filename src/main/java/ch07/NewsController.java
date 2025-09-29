package ch07;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/news")
public class NewsController extends HttpServlet {
  private NewsDAO dao = null;
  private ServletContext ctx;
  @Override
  public void init() throws ServletException {
    dao=new NewsDAO();
    ctx = getServletContext();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    String action = req.getParameter("action");
    if(action == null) {
      action = "list";
    }
    String path = "/ch07";
    String view = "";

    switch (action) {
      case "addNews" -> view = addNews(req, resp);
      case "list" -> view = list(req,resp);
      case "detail" -> view = getNews(req, resp);
      case "delNews" -> view = delNews(req, resp);
    }
    ctx.getRequestDispatcher(path+view).forward(req,resp);
  }

  private String addNews(HttpServletRequest req, HttpServletResponse resp) {
    NewsDTO n = new NewsDTO();

    try {
      Map<String, String[]> parameterMap = req.getParameterMap();
      System.out.println(parameterMap.get("title") + ":" + parameterMap.get("img") + parameterMap.get("content") );
      BeanUtils.populate(n, parameterMap);
      dao.addNews(n);
    } catch (Exception e) {
      e.printStackTrace();
      ctx.log("뉴스 등록 과정에서 exception 발생함");
      req.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다.");
      return list(req, resp);
    }
    return "redirect:/news?action=list";
  }

  private String list(HttpServletRequest req, HttpServletResponse resp) {
    try {
      List<News> all = dao.findAll();
      req.setAttribute("newsList", all);
    } catch (Exception e) {
      e.printStackTrace();
      ctx.log("뉴스 목록 가져오기 exception 발생");
      req.setAttribute("error", "뉴스 목록 가져오기가 정상적으로 수행되지 않았습니다.");
    }
    return "/newsList.jsp";
  }

  private String getNews(HttpServletRequest req, HttpServletResponse resp) {
    int aid = Integer.parseInt(req.getParameter("aid"));
    try {
      News n = dao.find(aid);
      req.setAttribute("news", n);
    } catch (Exception e) {
      e.printStackTrace();
      ctx.log("뉴스 가져오기 실행 중 exception 발생");
      req.setAttribute("error", "뉴스 상세보기 처리가 정상적으로 수행되지 않았습니다.");
    }
    return "/newsView.jsp";
  }

  private String delNews(HttpServletRequest req, HttpServletResponse resp) {
    int aid = Integer.parseInt(req.getParameter("aid"));
    try {
      dao.delNews(aid);
    } catch (Exception e) {
      e.printStackTrace();
      ctx.log("뉴스 삭제 중 exception 발생");
      req.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다.");
      return list(req, resp);
    }
    return "redirect:/news?action=list";
  }



}
