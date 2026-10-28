
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f5f9;
            padding: 30px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ddd;
        }

        h2 {
            text-align: center;
            color: #2874f0;
        }

        .search-box {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }

        input {
            flex: 1;
            min-width: 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button, .all-btn {
            padding: 10px 15px;
            background: #2874f0;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background: #2874f0;
            color: white;
        }

        .error {
            color: red;
            text-align: center;
            font-weight: bold;
        }

        .empty {
            text-align: center;
            padding: 20px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Product List</h2>

    <form class="search-box" action="ProductListServlet" method="get">
        <input type="text"
               name="name"
               placeholder="Search product by name..."
               value="<%= request.getAttribute("searchName") != null
                   ? request.getAttribute("searchName") : "" %>">

        <button type="submit">Search</button>

        <a class="all-btn" href="ProductListServlet">All</a>
    </form>

    <%
        String error = (String) request.getAttribute("error");
        List<Product> products =
            (List<Product>) request.getAttribute("products");
    %>

    <% if (error != null) { %>

        <p class="error"><%= error %></p>

    <% } else if (products == null || products.isEmpty()) { %>

        <p class="empty">No products found.</p>

    <% } else { %>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price (₹)</th>
            </tr>

            <% for (Product p : products) { %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= String.format("%.2f", p.getPrice()) %></td>
                </tr>
            <% } %>

        </table>

    <% } %>

</div>

</body>
</html>
