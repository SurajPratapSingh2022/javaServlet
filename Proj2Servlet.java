package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sps")
public class Proj2Servlet extends HttpServlet {

    // Database connection method
    private Connection getConn() {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/spsdb";
            String user = "root";
            String password = "system";

            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new RuntimeException("JDBC Driver not found.", e);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            throw new RuntimeException("Failed to connect to the database.", e);
        }
        return connection;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get a connection (if needed for database operations)
        Connection c = getConn();

        // Set response content type
        response.setContentType("text/html; charset=UTF-8");

        // Retrieve parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String pass = request.getParameter("pass");

        // PrintWriter for sending response
        try (PrintWriter printWriter = response.getWriter()) {
            // Basic validation
            if (name == null || email == null || mobile == null || pass == null) {
                printWriter.println("<h3>Error: Missing form data.</h3>");
            } else {
                // Output formatted HTML response
                printWriter.println("<h1>Form Data Received</h1>");
                printWriter.println("<p>Name: " + name + "</p>");
                printWriter.println("<p>Email: " + email + "</p>");
                printWriter.println("<p>Mobile: " + mobile + "</p>");
                printWriter.println("<p>Password: " + pass + "</p>");
            }
        } finally {
            try {
                if (c != null && !c.isClosed()) {
                    c.close(); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
