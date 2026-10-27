
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeUserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init() method called");
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
                           throws ServletException, IOException {

        System.out.println("service() method called");
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        String appName = getServletConfig()
                             .getInitParameter("appName");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Welcome, User!</h1>");
        out.println("<p>Application Name: " + appName + "</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() method called");
    }
}
