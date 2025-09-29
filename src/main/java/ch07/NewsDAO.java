package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

  public List<News> findAll() throws Exception {}

  public News find(int aid) throws Exception {}

  public void delNews(int aid) throws Exception {}
}
