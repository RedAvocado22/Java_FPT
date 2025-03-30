<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <style>
        .pagination {
            list-style-type: none;
            padding: 0;
            overflow: hidden;
        }

        .pagination li {
            display: inline;
        }

        .pagination li a {
            display: inline-block;
            padding: 8px 16px;
            text-decoration: none;
            color: black;
        }

        .pagination li.active a {
            background-color: #4CAF50;
            color: white;
        }

        .pagination li a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h2>Danh sách sinh viên</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Full Name</th>
                <th>Gender</th>
                <th>Course ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.fullName}</td>
                    <td>${student.gender}</td>
                    <td>${student.courseID}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty students}">
        <ul class="pagination">
            <c:set var="totalStudents" value="${totalStudents}"/>
            <c:set var="totalPages" value="${(totalStudents / 3) + (totalStudents % 3 == 0 ? 0 : 1)}"/>
            <c:forEach begin="${1}" end="${totalPages}" step="${1}" var="i">
                <li class="<c:if test="${param.page==i}">active</c:if>">
                    <a href="StudentsPaginationServlet?page=${i}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
