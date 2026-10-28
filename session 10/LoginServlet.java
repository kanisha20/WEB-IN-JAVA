
package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Demo credentials only.
        // Replace this condition with your database validation.
        if ("admin".equals(username)
                && "admin123".equals(password)) {

            response.sendRedirect("home.jsp");

        } else {
            request.setAttribute("loginError",
                                 "Invalid Credentials");

            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);
        }
    }
}
