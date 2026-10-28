
package com.example;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InstaRedirectServlet")
public class InstaRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        System.out.println(
            "Redirecting user to TrendingServlet...");

        response.setStatus(HttpServletResponse.SC_FOUND);

        response.sendRedirect(
            request.getContextPath() + "/TrendingServlet");
    }
}
