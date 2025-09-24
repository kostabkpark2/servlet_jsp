<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
    <h3>forward 방식으로 이동한 페이지</h3>
    공유받은 정보는
    <%= request.getAttribute("sharedInfo") %>
</body>
</html>