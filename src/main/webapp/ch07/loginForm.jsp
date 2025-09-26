<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
    <form action="/loginProcess" method="post">
        <input type="text" name="id">
        <input type="password" name="password">
        <input type="submit" value="로그인">
    </form>
</body>
</html>