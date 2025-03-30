<%-- 
    Document   : MyExecution
    Created on : Nov 2, 2024, 7:53:55 PM
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
        <form id="form" method="post" action="exe">
            <table>
                <tr>
                    <td>Enter a string (str):</td>
                    <td><input type="text" name="str" value="${str}"></td>
                </tr>
                <tr>
                    <td>Enter an integer:</td>
                    <td><input type="number" name="number" value="${number}"></td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td><input type="text" readonly="true" value="${result}"></td>
                </tr>

                <tr>
                    <td><button type="submit">SUB FIRST</button></td>
                    <td ><i style="font-weight: bold">${error}</i></td>
                </tr>
            </table>
            <p>List of execution:</p>
            <table border="1">
                <thead>
                    <tr>
                        <th>String str</th>
                        <th>Index n</th>
                        <th>Result</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var ="e">
                        <tr>
                            <td>${e.str}</td>
                            <td>${e.index}</td>
                            <td>${e.result}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </form>
    </body>
</html>
