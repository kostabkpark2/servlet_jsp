package ch07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {

  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3306/example?serverTimezone=Asia/Seoul";
  // 메소드 구현
  public Connection open() {
    Connection con = null;
    try {
      Class.forName(JDBC_DRIVER);
      con = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

  // CRD (뉴스 등록, 뉴스목록 , 뉴스상세보기, 뉴스 삭제)
  public void addNews(NewsDTO n) throws Exception {
    Connection con = open();
    String sql = "insert into news (title, img, date, content) values (?,?,current_timestamp(),?);";
    PreparedStatement pstmt = con.prepareStatement(sql);
    try(con; pstmt) {
      pstmt.setString(1, n.getTitle());
      pstmt.setString(2, n.getImg());
      pstmt.setString(3, n.getContent());
      pstmt.executeUpdate();
    }
  }

  public List<News> findAll() throws Exception {
    Connection con = open();
    List<News> newsList = new ArrayList<>();
    String sql = "select aid, title, date_format(date, '%Y-%m-%d %h:%m:%s') as cdate from news ";
    PreparedStatement pstmt = con.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();

    try(con; pstmt; rs) {
      while(rs.next()) {
        News n = new News();
        n.setAid(rs.getInt(1));
        n.setTitle(rs.getString("title"));
        n.setDate(rs.getString("cdate"));

        newsList.add(n);
      }
    }
    return newsList;
  }

  public News find(int aid) throws Exception {
    Connection con = open();
    News n = new News();
    String sql = "select aid, title, img, date_format(date, '%Y-%m-%d %h:%m:%s') as cdate , content " +
        " from news where aid = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setInt(1, aid);
    ResultSet rs = pstmt.executeQuery();

    if(rs == null) {
      throw new SQLException("뉴스 가져오기 에러");
    }
    rs.next();

    try(con; pstmt; rs) {
      n.setAid(rs.getInt(1));
      n.setTitle(rs.getString(2));
      n.setImg(rs.getString(3));
      n.setDate(rs.getString(4));
      n.setContent(rs.getString(5));
    }
    return n;
  }

  public void delNews(int aid) throws Exception {
    Connection con = open();
    String sql = "delete from news where aid = ?";
    PreparedStatement pstmt = con.prepareStatement(sql);

    try(con; pstmt) {
      pstmt.setInt(1, aid);
      if(pstmt.executeUpdate() == 0) {
        throw new SQLException("뉴스 삭제 에러");
      };
    }
  }
}
