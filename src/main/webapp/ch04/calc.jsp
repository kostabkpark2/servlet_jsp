<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 계산기</title>
</head>
<body>
    <h3>JSP 계산기</h3>
    <%-- 입력값 처리, 계산 --%>
    <%
        int n1 = Integer.parseInt(request.getParameter("n1"));
        int n2 = Integer.parseInt(request.getParameter("n2"));
        String op = request.getParameter("op");
        long result = 0L;
        switch (op) {
          case "+" : result = n1 + n2; break;
          case "-" : result = n1 - n2; break;
          case "*" : result = n1 * n2; break;
          case "/" : result = n1 / n2; break;
        }
    %>
    <%-- 화면처리 --%>
    <h3>계산결과</h3>
    <hr>
    결과 : <%= result %>
</body>
</html>