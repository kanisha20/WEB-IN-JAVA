
package com.example;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

     
        if ("kanisha".equals(username) &&
            "12345".equals(password)) {

            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);

            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            String encodedUsername = URLEncoder.encode(
                username, StandardCharsets.UTF_8);

            response.sendRedirect(
                request.getContextPath()
                + "/dashboard.jsp?username=" + encodedUsername);

        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(
                "<h3>Invalid username or password!</h3>");
            response.getWriter().println(
                "<a href='login.html'>Try Again</a>");
        }
    }
}
