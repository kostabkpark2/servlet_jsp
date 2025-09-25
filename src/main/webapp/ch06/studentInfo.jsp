<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생정보</title>
</head>
<body>
    <h1>학생 목록</h1>
    <hr>
    <table>
        <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>대학</th>
            <th>생일</th>
            <th>이메일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" varStatus="status" items="${students}" >
            <tr>
                <td>${status.count}</td>
                <td>${student.username}</td>
                <td>${student.univ}</td>
                <td>${student.birth}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>

    <form action="/students?action=insert" method="post">
        <label for="username">이름</label><input type="text" name="username" id="username"><br>
        <label for="univ">대학</label><input type="text" name="univ" id="univ"><br>
        <label for="birth">생일</label><input type="text" name="birth" id="birth"><br>
        <label for="email">이메일</label><input type="text" name="email" id="email"><br>
        <button type="submit">등록</button>
    </form>
</body>
</html>