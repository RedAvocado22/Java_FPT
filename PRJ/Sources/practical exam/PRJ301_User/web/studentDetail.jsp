<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết sinh viên</title>
</head>
<body>
    <h3>Thông tin sinh viên</h3>
    <p>Full Name: ${student.fullName}</p>
    <p>Gender: ${student.gender}</p>
    <p>Course: ${student.courseName}</p>

    <h3>Danh sách sở thích</h3>
    <ul>
        <c:forEach var="hobby" items="${hobbies}">
            <li>${hobby.hobbyName}</li>
        </c:forEach>
    </ul>
</body>
</html>
