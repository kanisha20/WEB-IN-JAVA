
package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.model.Product;
import com.model.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ProductDAO dao = new ProductDAO();
            List<Product> products = dao.getAllProducts();

            request.setAttribute("products", products);

        } catch (SQLException e) {
            getServletContext().log("Product retrieval failed", e);

            request.setAttribute("error",
                "Unable to load products. Please try again later.");
        }

        request.getRequestDispatcher("/products.jsp")
               .forward(request, response);
    }
}
