package ch07;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerExam implements ServletContextListener, ServletContextAttributeListener,
    HttpSessionListener, HttpSessionAttributeListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().log("servlet context 가 시작됨 !!!!!!!!!!!!!!!!!!!!!!!!");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().log("servlet context 가 종료됨 !!!!!!!!!!!!!!!!!!!!!!!!");
  }

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    event.getServletContext().log("Servlet Context 속성 추가" + event.getValue());
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    ServletContextAttributeListener.super.attributeRemoved(event);
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    ServletContextAttributeListener.super.attributeReplaced(event);
  }

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    event.getSession().getServletContext().log("세션 의 속성이 추가됨 : " + event.getValue());
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    se.getSession().getServletContext().log("세션이 생성됨 : " + se.getSession().getId());
  }
}
