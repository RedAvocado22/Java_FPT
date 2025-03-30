<%-- 
    Document   : show
    Created on : Oct 24, 2024, 4:16:45 PM
    Author     : Minh Cuong
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Supplier filter</h3>
            <form method="post" action="show">
                <table border="1">
                    <tr>
                        <td>Type name: </td>
                        <td><input type="text" name="name"></td>
                        <td><button type="submit">Fuck by name</button></td>
                    </tr>
                    <tr>
                        <td>Day of birth: </td>
                        <td><input type="text" name="day"></td>
                        <td><button type="submit">Fuck by day</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <div>
            <h3>List of Suppliers</h3>
            <table border="1">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Type Name</th>
                </tr>
                <c:forEach var="s" items="${suppliers}">
                    <tr>
                        <td>${s.code}</td>
                        <td>${s.name}</td>
                        <td>${s.dob}</td>
                        <td>${s.gender}</td>
                        <td>${s.typeName}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
