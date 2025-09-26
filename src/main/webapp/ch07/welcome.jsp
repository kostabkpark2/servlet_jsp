<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
    <form action="/logout">
        ${id}  <button type="submit">로그아웃</button>
    </form>
    <br>
    ${username} 님 반갑습니다.
</body>
</html>