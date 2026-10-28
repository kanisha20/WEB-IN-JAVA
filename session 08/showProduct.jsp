
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Updated Product Details</title>
</head>
<body>
    <h1>Product Details</h1>

    <jsp:useBean id="product" class="com.example.Product" scope="request" />

    <jsp:setProperty name="product" property="name" param="name" />
    <jsp:setProperty name="product" property="price" param="price" />

    <p>Product Name:
        <jsp:getProperty name="product" property="name" />
    </p>

    <p>Product Price: ₹
        <jsp:getProperty name="product" property="price" />
    </p>
</body>
</html>
