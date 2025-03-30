<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả tìm kiếm sinh viên</title>
</head>
<body>
    <h2>Kết quả tìm kiếm sinh viên</h2>

    <form action="SearchStudentsServlet" method="get">
        <label for="searchName">Tên sinh viên:</label>
        <input type="text" id="searchName" name="searchName" placeholder="Nhập tên sinh viên">
        
        <label for="courseID">Khóa học:</label>
        <select id="courseID" name="courseID">
            <option value="">-- Chọn khóa học --</option>
            <c:forEach var="course" items="${courses}">
                <option value="${course.courseID}">${course.courseName}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Tìm kiếm</button>
    </form>

    <hr>

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
                <td>
                    <form action="DeleteStudentServlet" method="post">
                        <input type="hidden" name="studentID" value="${student.studentID}">
                        <button type="submit">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
