
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThemeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

    
        String defaultTheme = getServletContext()
                                  .getInitParameter("appTheme");

        
        String theme = request.getParameter("theme");

        if (theme == null || theme.trim().isEmpty()) {
            theme = defaultTheme;
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Application Theme</h2>");
        out.println("<p>Current Theme: " + theme + "</p>");
        out.println("</body></html>");
    }
}
