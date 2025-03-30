<%-- 
    Document   : MyExam
    Created on : Nov 1, 2024, 10:59:16 PM
    Author     : Minh Cuong
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Code: </td>
                    <td><input type="text" name="code" value="${code}"></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="${name}"></td>
                </tr>
                <tr>
                    <td>Plane schedule: </td>
                    <td><input type="date" name="date" value="${date}"></td>
                </tr>
                <tr>
                    <td><button type="submit">ADD</button></td>
                    <td>${error}</td>
                </tr>
            </table>
        </form>
        <h3>List of Plane</h3>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Schedule</td>
            </tr>
            <c:forEach var="s" items="${sessionScope.schedules}">
                <tr>
                    <td>${s.code}</td>
                    <td>${s.name}</td>
                    <td><fmt:formatDate value="${s.date}" pattern="dd/MM/yyyy"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
