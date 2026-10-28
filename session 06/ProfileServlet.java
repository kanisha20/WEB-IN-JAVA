
package com.example;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        String username = request.getParameter("username");

        response.setContentType("text/html;charset=UTF-8");

        if (username == null || username.trim().isEmpty()) {
            response.sendError(400, "Username is required");
            return;
        }

        String safeUsername = username
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;");

        response.getWriter().println(
            "<h2>My Profile</h2><p>Username: "
            + safeUsername + "</p>");
    }
}
