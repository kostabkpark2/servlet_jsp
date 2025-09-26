package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
  Connection con = null;
  PreparedStatement pstmt = null;
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3306/example?serverTimezone=Asia/Seoul";
  // 메소드 구현
  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      con = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close(){
    try {
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public User find(String id) {
    open();
    String sql = "select * from user where id = ?";
    ResultSet rs = null;
    User u = null;
    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      // 가져온 데이터를 User 에 담기
      if(rs.next()) {
        u = new User();
        u.setId(rs.getString("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return u;
  }
}
