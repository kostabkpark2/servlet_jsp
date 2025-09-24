<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 페이지</title>
</head>
<body>
    <h3>환영합니다.</h3>
    <hr>
    <%= session.getAttribute("id") %> 님 반갑습니다.
</body>
</html>