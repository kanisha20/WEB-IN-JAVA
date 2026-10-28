
package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String priceValue = request.getParameter("price");
        String category = request.getParameter("category");

        try {
            if (name == null || name.trim().isEmpty()
                    || priceValue == null || category == null
                    || category.trim().isEmpty()) {

                request.setAttribute("error", "Please fill all fields.");
                request.getRequestDispatcher("index.jsp")
                       .forward(request, response);
                return;
            }

            double price = Double.parseDouble(priceValue);

            if (price < 0) {
                throw new NumberFormatException();
            }

            HttpSession session = request.getSession();

            @SuppressWarnings("unchecked")
            List<Product> products =
                (List<Product>) session.getAttribute("products");

            if (products == null) {
                products = new ArrayList<Product>();
            }

            int id = products.size() + 1;

            Product product = new Product(
                id,
                name.trim(),
                price,
                category.trim()
            );

            products.add(product);

            session.setAttribute("products", products);

            request.getRequestDispatcher("showProduct.jsp")
                   .forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error",
                                 "Please enter a valid product price.");
            request.getRequestDispatcher("index.jsp")
                   .forward(request, response);
        }
    }
}
