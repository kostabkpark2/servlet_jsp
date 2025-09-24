<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>계산 결과</h1>
    <hr>
    <%= request.getAttribute("result") %>
</body>
</html>