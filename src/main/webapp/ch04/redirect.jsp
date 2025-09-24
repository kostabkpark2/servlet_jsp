<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
    <h3>redirect 방식으로 이동한 페이지</h3>
    공유받은 정보는
    <%= session.getAttribute("sharedInfo") %>
</body>
</html>