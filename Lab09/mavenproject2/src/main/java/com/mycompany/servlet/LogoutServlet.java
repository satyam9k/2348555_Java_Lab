package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            // Get user information from the session
            String username = (String) session.getAttribute("username");
            Date loginTime = (Date) session.getAttribute("loginTime");

            // Log the logout time to the database (modify as needed)
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/login", "root", "");
                insertLogoutRecord(con, username);
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
            } finally {
                try {
                    if (con != null) {
                        con.close(); // Close the connection in the finally block
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Handle the exception according to your application's needs
                }
            }

            // Invalidate the session
            session.invalidate();

            // Redirect to a logout success page or login page
            response.sendRedirect("logout.jsp");
        } else {
            // Not logged in, handle accordingly (redirect to login page or display a message)
            response.sendRedirect("index.html");
        }
    }

    private void insertLogoutRecord(Connection con, String username) throws Exception {
        String query = "INSERT INTO user_sessions (username, logout_time) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
        }
    }
}
