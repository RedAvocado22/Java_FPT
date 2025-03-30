<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Place Order</title>
    </head>
    <body>
        <h2>Place Order</h2>
        <form action="order" method="post">
            <label for="orderID">Order ID:</label>
            <input type="text" id="orderID" name="orderID" value="${nextOrderId}" readonly><br><br>

            <label for="customer">Customer:</label>
            <select name="customer" id="customer" required>
                <option value="">Select a customer</option>
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </select><br><br>

            <label for="orderDate">Order Date:</label>
            <input type="date" id="orderDate" name="orderDate" required><br><br>

            <label for="products">Select Products and Enter Quantities:</label><br>
            <c:forEach var="product" items="${products}">
                <input type="checkbox" id="product${product.id}" name="products" value="${product.id}">
                <label for="product${product.id}">${product.name} - ${product.price}</label><br>
                <label for="quantity${product.id}">Quantity:</label>
                <input type="number" id="quantity${product.id}" name="quantity_${product.id}" min="1" value="1"><br><br>
            </c:forEach>
            <br>

            <input type="submit" value="Place Order">
        </form>
    </body>
</html>
