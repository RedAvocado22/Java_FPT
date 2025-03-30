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
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Detail</td>
                    </tr>
                    <c:forEach var="doctor" items="${doctors}">
                        <tr>
                            <td>${doctor.id}</td>
                            <td><a href="${pageContext.request.contextPath}/show?id=${doctor.id}">More</a></td>
                        </tr>
                    </c:forEach>   
                </table>
                <div>
                    <c:if test="${doctor != null}">
                        <table border="1">
                            <tr>
                                <td>ID</td>
                                <td>${doctor.id}</td>
                            </tr>   
                            <tr>
                                <td>Full name</td>
                                <td>${doctor.fullName}</td>
                            </tr>
                            <tr>
                                <td>Specialty</td>
                                <td>${doctor.specialty}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
