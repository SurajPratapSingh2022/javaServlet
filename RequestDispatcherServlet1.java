package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class RequestDispatcherServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String name1 = req.getParameter("name1");
        String pass1 = req.getParameter("pass1");
        
        RequestDispatcher rd;
        if ("sps@gmail.com".equals(name1) && "demo".equals(pass1)) {
            // Forward to the home page servlet
            rd = req.getRequestDispatcher("/RequestDispatcherServlet2");
            rd.forward(req, resp);
        } else {
            // Include error message and reload the login page
            out.print("<h4 style='color:red;'>Invalid email & password</h4>");
            rd = req.getRequestDispatcher("requestDispatcherIndex.jsp");
            rd.include(req, resp);
        }
    }
}

