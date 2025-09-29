<%--
  Created by IntelliJ IDEA.
  User: wd
  Date: 2025-09-29
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>뉴스목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>
    <h1>뉴스 목록</h1>
    <hr>
    <ul class="list-group">
        <c:forEach varStatus="status" var="news" items="${newsList}">
        <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
            <a href="/news?action=detail&aid=${news.aid}" class="text-decoration-none">
                [${status.count}] ${news.title},${news.date}
            </a>
            <a href="/news?action=delNews&aid=${news.aid}">
                <span class="badge bg-secondary">&#10006;</span>
            </a>
        </li>
        </c:forEach>
    </ul>
    <c:if test="${error != null}">
        <div class="alert alert-danger alert-dismissible fade show mt-3">
            에러 발생 : ${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <button class="btn btn-outline-info mb-3" type="button" data-bs-toggle="collapse"
            data-bs-target="#addForm" aria-expanded="false" aria-controls="addForm">
        뉴스 등록
    </button>
    <div class="collapse" id="addForm">
        <div class="card card-body">
            <form action="/news?action=addNews" method="post" >
<%--                enctype="multipart/form-data">--%>
                <label for="title" class="form-label">제목</label>
                <input type="text" name="title" id="title" class="form-control">
                <label for="file" class="form-label">이미지</label>
                <input type="text" name="img" id="file" class="form-control">
                <label for="content" class="form-label">기사내용</label>
                <input type="text" name="content" id="content" class="form-control">
                <button type="submit" class="btn btn-success mt-3">저장</button>
            </form>
        </div>
    </div>
</body>
</body>
</html>
