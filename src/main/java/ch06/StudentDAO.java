package ch06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  Connection con = null;
  PreparedStatement pstmt = null;
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3800/example?serverTimezone=Asia/Seoul";
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

  public void insert(Student s){}

  public List<Student> findAll(){
    open();
    String sql = "select * from student";
    ResultSet rs = null;
    List<Student> students = new ArrayList<Student>();
    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      // 가져온 데이터를 List 에 담기
      while(rs.next()) {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setUsername(rs.getString("username"));
        s.setUniv(rs.getString("univ"));
        s.setBirth(rs.getDate("birth"));
        s.setEmail(rs.getString("email"));

        students.add(s);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return students;
  }
}
