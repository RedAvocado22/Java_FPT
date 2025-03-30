<%-- 
    Document   : create
    Created on : Oct 21, 2024, 1:39:19 PM
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
        <div>
            <div style="display: flex; align-content: center; gap: 50px">
                <div>

                    <h3>Create doctor</h3>
                    <form action="${pageContext.request.contextPath}/create" method="post">
                        <table>
                            <tr>
                                <td>ID: </td>
                                <td><input type="text" value="${nextId}" readonly></td>
                            </tr>
                            <tr>
                                <td>Full name: </td>
                                <td><input type="text" name="fullName"></td>
                            </tr>
                            <tr>
                                <td>Specialty: </td>
                                <td><input type="text" name="specialty"></td>
                            </tr>
                            <tr>
                                <td>Department: </td>
                                <td>
                                    <select name="departmentID">
                                        <c:forEach var="department" items="${departments}">
                                            <option value="${department.id}">${department.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><button type="submit">Create</button></td>
                                <td>
                                    <span style="color: red">
                                        ${error} 
                                    </span>
                                    <span style="color: green">
                                        ${success}
                                    </span>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Full name</th>
                        <th>Specialty</th>
                        <th>Department ID</th>
                    </tr>
                    <c:forEach var="doctor" items="${doctors}">
                        <tr>
                            <td>${doctor.id}</td>
                            <td>${doctor.fullName}</td>
                            <td>${doctor.specialty}</td>
                            <td>${doctor.departmentId}</td>
                        </tr>
                    </c:forEach>    
                </table>
            </div>
        </div>
    </body>
</html>
