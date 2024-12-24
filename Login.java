package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myemail = request.getParameter("email");
        String mypass = request.getParameter("pass1");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("sps@gmail.com".equals(myemail) && "sps@123".equals(mypass)) {
            HttpSession session = request.getSession();
            session.setAttribute("nameKey", "sps");

            RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);
        } else {
            out.print("<h3 style='color:red'>Email or password is incorrect. Please try again.</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        }
    }
}
