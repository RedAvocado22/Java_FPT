<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order List</title>
</head>
<body>
    <div style="float:left; width:20%;">
        <h3>Order List</h3>
        <ul>
            <c:forEach var="order" items="${orders}">
                <li><a href="orderdetail?orderID=${order.id}">Order ID: ${order.id}</a></li>
            </c:forEach>
        </ul>
    </div>

    <div style="float:left; width:80%;">
        <h3>Order Details</h3>
        <table border="1">
            <tr>
                <th>Customer Name</th>
                <th>Product</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="detail" items="${orderDetails}">
                <tr>
                    <td>${customer.name}</td>
                    <td>${detail.product.name}</td>
                    <td>${detail.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
