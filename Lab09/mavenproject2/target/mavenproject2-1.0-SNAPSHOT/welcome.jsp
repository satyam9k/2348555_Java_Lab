<!-- welcome.jsp -->
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <%
        HttpSession session1 = request.getSession(false);

        // Check if the user is logged in
        if (session1 != null && session1.getAttribute("username") != null) {
            String username = (String) session1.getAttribute("username");
            Date loginTime = (Date) session1.getAttribute("loginTime");

            // Format the login time using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedLoginTime = sdf.format(loginTime);

            // Display user information
    %>
            <h2>Welcome, <%= username %></h2>
            <p>Login Time: <%= formattedLoginTime %></p>
            <!-- Display profile picture (replace 'placeholder.jpg' with the actual image URL) -->
            <img src="placeholder.jpg" alt="Profile Picture">
            <!-- Add your content for the welcome page here -->
            <a href="logout.jsp">Logout</a>
    <%
        } else {
            // Redirect to login page if the user is not logged in
            response.sendRedirect("index.html"); // Change to the appropriate page
        }
    %>
</body>
</html>
