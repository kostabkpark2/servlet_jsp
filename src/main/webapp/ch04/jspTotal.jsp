<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 생성 예제</title>
</head>
<body>
    <h3>
    1. jsp 주석
    <%-- JSP 주석입니다. 화면과 소스 보기에서 모두 보이지 않습니다. --%>
    2. HTML 주석
    <!-- HTML 주석입니다. 화면에서는 안보이고, 소스 보기에서는 보입니다.-->
    </h3>
    <%!
        String[] members = {"홍길동", "김길동", "김연아"};
        int num1 = 10;

        int calc(int num2) {
            return num1 + num2;
        }
    %>

    <h3>3. calc(10) 메서드 실행 결과
        <%= calc(10) %>
    </h3>

    <h3>4. hello.jsp 가져오기</h3>
    <%@ include file="../hello.jsp" %>


    <h3>스크립트릿으로 반복문활용하여 배열의 데이터 출력하기</h3>
    <ul>
    <% for(String member : members) { %>
       <li><%= member %></li>
    <% } %>
    </ul>
</body>
</html>