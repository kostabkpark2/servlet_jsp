<%--
  Created by IntelliJ IDEA.
  User: wd
  Date: 2025-09-29
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>뉴스 관리 앱</title>
</head>
<body>
  <div class="container w-75 mt-5 mx-auto">
    <h2>${news.title}</h2>
    <hr>
    <div class="card w-75 mx-auto">

      <img class="card-img-top"
           src="${news.img}" alt="picture" />
      <div class="card-body">
        <h4 class="card-title">Date : ${news.date}</h4>
        <p class="card-text">Content : ${news.content}</p>
      </div>
    </div>
    <c:if test="${error != null}">
      <div class="alert alert-danger alert-dismissible fade show mt-3">
        에러 발생 : ${error}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
      </div>
    </c:if>
    <hr>
    <a href="/news" class="btn btn-primary">Back</a>
  </div>
</body>
</html>
