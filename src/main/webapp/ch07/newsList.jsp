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
                ${news.aid},${news.title}, ${news.date}
        </li>
        </c:forEach>
    </ul>
</body>
</body>
</html>
