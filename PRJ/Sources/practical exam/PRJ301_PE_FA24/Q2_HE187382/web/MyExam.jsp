<%-- 
    Document   : MyExam
    Created on : Oct 24, 2024, 3:58:04 PM
    Author     : Minh Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sum" method="post">
            <table>
                <tr>
                    <td>Enter an integer n: </td>
                    <td><input type="text" name="num" value="${num}"></td>
                </tr>
                <tr>
                    <td>Result: </td>
                    <td><input type="text" name="num" value="${result}" readonly></td>
                </tr>
                <tr>
                    <td><button type="submit">SUM</button></td>
                    <td>${error}</td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
