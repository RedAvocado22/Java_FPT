<%-- 
    Document   : show
    Created on : Nov 2, 2024, 8:27:37 PM
    Author     : dkien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="sort">
            <table>
                <tr>
                    <td>Sort by Type Name:</td>
                    <td>
                        <input type="radio" name="type" value="ASC" ${typeOrder == "ASC" ? 'checked' : ''}>
                        <label for="asc">Ascending</label>
                        <input type="radio" name="type" value="DESC" ${typeOrder == "DESC" ? 'checked' : ''}>
                        <label for="desc">Descending</label>
                    </td>
                </tr>

                <tr>
                    <td>Then by index:</td>
                    <td>
                        <input type="radio" name="index" value="ASC" ${indexOrder == "ASC" ? 'checked' : ''}>
                        <label for="asc">Ascending</label>
                        <input type="radio" name="index" value="DESC" ${indexOrder == "DESC" ? 'checked' : ''}>
                        <label for="desc">Descending</label>
                    </td>
                </tr>
            </table>
            <button type="submit">SORT</button>
        </form>
        <p>List of Executions:</p>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>String</th>
                    <th>Index</th>
                    <th>Type</th>
                    <th>Result</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${list}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.inputString}</td>
                        <td>${e.subIndex}</td>
                        <td>${e.typeName}</td>
                        <td>${e.result}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
