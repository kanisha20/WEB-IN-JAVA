
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order Summary</title>
</head>
<body>
    <h1>Order Summary</h1>

    <p>Item Name: ${requestScope.itemName}</p>
    <p>Quantity: ${requestScope.quantity}</p>
    <p>Price per Item: ₹${requestScope.price}</p>

    <h3>Total Cost: ₹${requestScope.quantity * requestScope.price}</h3>
</body>
</html>
