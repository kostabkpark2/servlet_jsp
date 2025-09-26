package ch07;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginProcess")
public class LoginController extends HttpServlet {
  UserDAO dao;

  @Override
  public void init() throws ServletException {
    dao = new UserDAO();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getMethod().equals("POST")) {
      UserDTO dto = new UserDTO();
      try {
        BeanUtils.populate(dto, req.getParameterMap());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      User u = dao.find(dto.getId());
      System.out.println(dto.getId() + ":" + dto.getPassword());
      System.out.println(u);
      if(u != null && u.getPassword().equals(dto.getPassword())){
        Cookie cookie = new Cookie("memberId", u.getId());
        // 10분(600초) 동안만 유지
        cookie.setMaxAge(60 * 10);
        // 사이트 전체에서 접근 가능하도록 경로 지정
        cookie.setPath("/");
        resp.addCookie(cookie);
        System.out.println("로그인 성공");
        resp.sendRedirect("/welcome");
      } else {
        System.out.println("로그인 실패");
        resp.sendRedirect("/ch07/loginForm.jsp");
      }
    }
  }
}
