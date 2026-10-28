
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        String productId = request.getParameter("productId");

        boolean valid = false;

        if (productId != null && !productId.trim().isEmpty()) {
            try {
                valid = Integer.parseInt(productId) > 0;
            } catch (NumberFormatException e) {
                valid = false;
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (!valid) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("<h2>Product not found</h2>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("<h2>Product details for "
                        + productId + "</h2>");
        }
    }
}
