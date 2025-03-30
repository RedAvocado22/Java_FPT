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
            <form method="post" action="search">
                <table>
                    <tr>
                        <td>Choose an option: </td>
                        <td>
                            <select name="option">
                                <option value="">All types</option>
                                <c:forEach var="ex" items="${types}">
                                    <option value="${ex}" <c:if test="${ex == option}">selected</c:if>>${ex}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><button type="submit">Filter</button></td>

                    </tr>
                    <tr>
                        <td>Enter a string (str):</td>
                        <td><input type="text" name="str" value="${str}"></td>
                        <td><button type="submit">Search</button></td>

                    </tr>
                </table>
            </form>
        </div>
        <div>
            <h3>Result of Filter/Search</h3>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>String str</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
                <c:forEach var="e" items="${executions}">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.str}</td>
                        <td>${e.typeName}</td>
                        <td>${e.result}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
