<%-- 
    Document   : show
    Created on : Oct 24, 2024, 4:16:45 PM
    Author     : Minh Cuong
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="show">
            <select name="subjectID" onChange="this.form.submit()">
                <option value="all">All subject</option>
                <c:forEach var="subject" items="${subjects}">
                    <option value="${subject.id}" <c:if test="${subjectID == subject.id}">selected</c:if>>${subject.name}</option>
                </c:forEach>
            </select>
        </form>

        <h3>List of students</h3>
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Subject</th>
                <th>Select</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.birthDate}</td>
                    <td>${student.gender}</td>
                    <td>${student.subjectName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/show?id=${student.id}&subjectID=${subjectID}">
                            Select
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${student != null}">
            <h3>Detail information:</h3>
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="text" name="id" value="${student.id}"></td>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${student.name}"></td>
                </tr>   
                <tr>
                    <td>Date of birth:</td>
                    <td><input type="text" name="dob" value="${student.birthDate}"></td>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="Male"
                               <c:if test="${student.gender == 'Male'}">checked</c:if>> Male
                               <input type="radio" name="gender" value="Female"
                               <c:if test="${student.gender == 'Female'}">checked</c:if>> Female
                        </td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" name="subject" value="${student.subjectName}"></td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
