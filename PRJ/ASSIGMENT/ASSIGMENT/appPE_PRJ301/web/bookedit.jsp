<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>book Details</title>
    </head>
    <body>

        <jsp:include page="/menu.jsp" flush="true" /> 
        <h1>Coupons Edit </h1>

        <form action="MainController" method="POST">


            <table>
                <tr><td>Id: </td><td><input type="hidden" name="id" value="${requestScope.object.id}" ></td></tr>
                <tr><td>title: </td><td><input name="title" value="${requestScope.object.title}" required></td></tr>
                <tr><td>quantity: </td><td><input name="quantity" value="${requestScope.object.quantity}" required></td></tr>		 
                <tr>
                    <td>status: </td>
                    <td>
                        <select name="status" required>
                            <option value="Available" ${requestScope.object.status == 'Available' ? 'selected' : ''}>Available</option>
                            <option value="Borrowed" ${requestScope.object.status == 'Borrowed' ? 'selected' : ''}>Borrowed</option>
                        </select>
                    </td>
                </tr>

                <tr><td colspan="2">
                        <input name="action" value="${requestScope.nextaction}" type="hidden">
                        <input type=submit value=Save>
                    </td></tr>

            </table>

        </form>


    </body>
</html>
