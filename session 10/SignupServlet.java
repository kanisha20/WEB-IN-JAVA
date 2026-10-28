
package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Preserve entered values if validation fails
        request.setAttribute("username", username);
        request.setAttribute("email", email);

        // Check empty fields
        if (username == null || username.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || password == null || password.isEmpty()) {

            request.setAttribute("error",
                                 "All fields are required.");

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);
            return;
        }

        // Check email format
        email = email.trim();

        if (!email.contains("@") || !email.endsWith(".com")) {

            request.setAttribute("emailError",
                "Please enter a valid email address.");

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);
            return;
        }

        // Check password length
        if (password.length() < 6) {

            request.setAttribute("error",
                "Password must be at least 6 characters.");

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);
            return;
        }

        // Successful validation
        request.setAttribute("success",
            "Signup successful!");

        request.getRequestDispatcher("signupSuccess.jsp")
               .forward(request, response);
    }
}
