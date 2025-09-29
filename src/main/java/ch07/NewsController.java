package ch07;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/news")
@MultipartConfig(maxFileSize = 1024*1024*2, location="c:/Temp/img")
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
//    요청된 리소스 [/ch07redirect:/news]은(는) 가용하지 않습니다.
    // 반환값이 redirect 로 오는 경우
    if(view.startsWith("redirect:/")) {
      // "redirect:/news?action=list";
      view = view.substring("redirect:".length());
      resp.sendRedirect(view);
    } else {
      // 반환값이 redirect 가 아닌 경우
      ctx.getRequestDispatcher(path + view).forward(req, resp);
    }
  }

  private String addNews(HttpServletRequest req, HttpServletResponse resp) {
    NewsDTO n = new NewsDTO();

    try {
      // 이미지 파일 저장
      Part file = req.getPart("file");
      String fileName = file.getSubmittedFileName();
      System.out.println(fileName);
      if(fileName != null && !fileName.isEmpty()) {
        file.write(fileName);
      }

      BeanUtils.populate(n, req.getParameterMap());
      n.setImg(fileName);

      System.out.println(n);

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
