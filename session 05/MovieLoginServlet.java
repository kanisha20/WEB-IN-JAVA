
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MovieLoginServlet")
public class MovieLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) &&
            "12345".equals(password)) {

            response.sendRedirect(
                request.getContextPath() + "/MovieDashboardServlet");

        } else {
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter out = response.getWriter();
            out.println("<h2>Invalid username or password!</h2>");
            out.println("<a href='movieLogin.html'>Try Again</a>");
        }
    }
}
