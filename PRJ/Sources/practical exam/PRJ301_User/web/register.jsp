<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Student</title>
</head>
<body>
<h2>Register Student</h2>
<form action="RegisterServlet" method="post">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName"><br><br>

    <label for="course">Course:</label>
    <select name="course" id="course">
        <c:forEach var="course" items="${courses}">
            <option value="${course.courseID}">${course.courseName}</option>
        </c:forEach>
    </select><br><br>

    <label>Gender:</label>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label><br><br>

    <label for="hobbies">Hobbies:</label><br>
    <c:forEach var="hobby" items="${hobbies}">
        <input type="checkbox" id="hobby${hobby.hobbyID}" name="hobbies" value="${hobby.hobbyID}">
        <label for="hobby${hobby.hobbyID}">${hobby.hobbyName}</label><br>
    </c:forEach>
    <br>
    <input type="submit" value="Register">
</form>
</body>
</html>
