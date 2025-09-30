package ch08;

import ch07.News;
import ch07.NewsDAO;
import ch07.NewsDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/news")
public class NewsAPIApplication {
  private NewsDAO dao=null;

  public NewsAPIApplication() {
    dao = new NewsDAO();
  }

  // 뉴스 목록 가져오기
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<News> getAllNews() {
    try {
      List<News> all = dao.findAll();
      return all;
    } catch (Exception e) {
      return null;
    }
  }

  // aid 를 가지고 뉴스 상세 내역 가져오기
  @GET
  @Path("/{aid}")
  @Produces(MediaType.APPLICATION_JSON)
  public News getNewsByAid(@PathParam("aid") int aid) {
    try {
      News news = dao.find(aid);
      return news;
    } catch (Exception e) {
      return null;
    }
  }

  // news 를 등록
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public String addNews(NewsAPICreateDto newsDto) {
    NewsDTO news = new NewsDTO();
    news.setTitle(newsDto.getTitle());
    news.setImg(newsDto.getImg());
    news.setContent(newsDto.getContent());
    try {
      dao.addNews(news);
      return "정상적으로 등록되었습니다.";
    } catch (Exception e) {
      return "뉴스 등록 중 오류 발생";
    }
  }

//  aid 로 검색된 news 를 삭제
  @DELETE
  @Path("/{aid}")
  public String delNews(@PathParam("aid") int aid) {
    try {
      dao.delNews(aid);
      return "정상적으로 삭제되었습니다.";
    } catch (Exception e) {
      return "삭제 중 오류가 발생했습니다.";
    }
  }
}
