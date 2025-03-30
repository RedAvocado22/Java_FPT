<%-- 
    Document   : MyExam
    Created on : Nov 3, 2024, 11:15:55 AM
    Author     : Minh Cuong
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
        <form method="get" action="execute">
            <table>
                <tr>
                    <td>Enter a string (str):</td>
                    <td><input type="text" name="str" value="${str}" required></td>
                </tr>
                <tr>
                    <td>Choose an option: </td>
                    <td>
                        <select name="option">
                            <option value="Vowel characters" <c:if test="${se == 1}">selected</c:if>>Vowel characters</option>
                            <option value="Length of string" <c:if test="${se == 2}">selected</c:if>>Length of string</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td>Result: </td>
                    <td><input type="text" name="result" value="${result}" readonly></td>
                </tr>
                <tr> 
                    <td>
                        <button type="submit">EXECUTE</button>
                    </td>
                    <td>
                        <h4 style="margin: 0">${error}</h4>
                    </td>
                </tr>
            </table>
        </form>
        <table border="1">
            <tr>
                <td>String str</td>
                <td>Option</td>
                <td>Result</td>
            </tr>
            <c:forEach var="s" items="${sessionScope.executions}">
                <tr>
                    <td>${s.str}</td>
                    <td>${s.option}</td>
                    <td>${s.result}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
