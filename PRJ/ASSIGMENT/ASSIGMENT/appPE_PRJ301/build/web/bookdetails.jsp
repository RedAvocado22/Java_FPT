
<%@page import="pe.rate.RateDTO"%>
<%@page import="java.util.List"%>
<%@page import="pe.rate.RateDAO"%>
<%@page import="pe.book.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Details</title>
    </head>
    <body>
        <jsp:include page="/menu.jsp" flush="true" />

        <h1>Book Details </h1>         

        <table>
            <tr><td>Id: </td><td>${requestScope.object.id}</td></tr>
            <tr><td>title: </td><td>${requestScope.object.title }</td></tr>
            <tr><td>quantity: </td><td>${requestScope.object.quantity}</td></tr>		 
            <tr><td>status: </td><td>${requestScope.object.status}</td></tr>
        </table>

           
         <form action="MainController" method="post">
             <input type=hidden name="id" value="${requestScope.object.id}">
             <input type=hidden name="action" value="edit">
             <input type=submit value="Edit">
         </form>

</body>
</html>
