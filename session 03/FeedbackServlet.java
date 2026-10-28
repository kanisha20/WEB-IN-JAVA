
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String orderId = request.getParameter("orderId");
        String feedback = request.getParameter("feedback");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Food Delivery Feedback</h2>");

        
        if (username == null || username.trim().isEmpty()
                || orderId == null || orderId.trim().isEmpty()
                || feedback == null || feedback.trim().isEmpty()) {

            out.println("<h3>Please fill in all fields!</h3>");

        } else {
            out.println("<h3>Thank you for your feedback, "
                    + escapeHtml(username) + "!</h3>");

            out.println("<p>Order ID: "
                    + escapeHtml(orderId) + "</p>");

            out.println("<p>Your Feedback: "
                    + escapeHtml(feedback) + "</p>");
        }

        out.println("</body></html>");
    }

    
    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
