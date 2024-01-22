package com.mycompany.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author SATYAM
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/login", "root", "");

            PreparedStatement pst = con.prepareStatement("SELECT * FROM log WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            

        if (rs.next()) {
            HttpSession existingSession = request.getSession(false);
            if (existingSession != null && existingSession.getAttribute("username") != null) {
        // User is already logged in
                String existingUsername = (String) existingSession.getAttribute("username");
                Date existingLoginTime = (Date) existingSession.getAttribute("loginTime");

        
                PrintWriter out = response.getWriter();
                out.println("You are already logged in as " + existingUsername + " since " + existingLoginTime);
            } else {
        // New login
                HttpSession newSession = request.getSession();
                newSession.setAttribute("username", username);
                newSession.setAttribute("loginTime", new Date());
                insertLoginRecord(con, username);
                response.sendRedirect("welcome.jsp");
            }
        } else {
    // Login failed
            PrintWriter out = response.getWriter();
            out.println("Invalid username or password");
        }



            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private void insertLoginRecord(Connection con, String username) throws Exception {
        String query = "INSERT INTO user_sessions (username, login_time) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
        }
    }
}






