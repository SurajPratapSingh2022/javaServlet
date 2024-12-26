package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		// Get Data
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		
		try {
			//Database Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb","root","system");
			
			//Database Query
			PreparedStatement ps=con.prepareStatement("select * from proj1 where email1=? and pass1=?");
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("session_name",rs.getString("name1"));
				
				RequestDispatcher rd=request.getRequestDispatcher("/profileApp.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				pw.print("<h3 style='color:red'>Email id and password didn't matched</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/loginForm.jsp");
				rd.include(request, response);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			response.setContentType("text/html");
			pw.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/loginForm.jsp");
			rd.include(request, response);
			
		}
		
	}

}
