<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
    <div style="float:left; width:20%;">
        <h3>Danh mục khóa học</h3>
        <ul>
            <c:forEach var="course" items="${publishers}">
                <li><a href="StudentsServlet?courseID=${course.courseID}">${course.courseName}</a></li>
            </c:forEach>
        </ul>
    </div>

    <div style="float:left; width:80%;">
        <h3>Danh sách sinh viên</h3>
        <table border="1">
            <tr>
                <th>Full Name</th>
                <th>Gender</th>
                <th>Course</th>
                <th>Action</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.fullName}</td>
                    <td>${student.gender}</td>
                    <td>${student.courseName}</td>
                    <td><a href="StudentDetailServlet?studentID=${student.studentID}">Detail</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
