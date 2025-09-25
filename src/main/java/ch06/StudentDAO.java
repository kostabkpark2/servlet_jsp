package ch06;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object
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

  public void insert(Student s){
    open();
    String sql = "insert into student values(?,?,?,?,?)";
    // 데이터를 student table 에 추가
    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1,s.getId());
      pstmt.setString(2,s.getUsername());
      pstmt.setString(3,s.getUniv());
      pstmt.setDate(4,s.getBirth());
      pstmt.setString(5,s.getEmail());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

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
