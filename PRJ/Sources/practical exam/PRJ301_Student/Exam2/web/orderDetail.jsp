<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
    <h2>Order Details for Order ID: ${orderDetails[0].orderId}</h2>

    <p><strong>Customer Name:</strong> ${customer.name}</p>

    <h3>Products in this order:</h3>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="detail" items="${orderDetails}">
            <tr>    
                <td>${detail.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
