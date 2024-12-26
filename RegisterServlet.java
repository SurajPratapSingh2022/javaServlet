package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/regForm")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		
		// Get Value from JSP
		String myname=request.getParameter("name1");
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		String mygender=request.getParameter("gender1");
		String mycity=request.getParameter("city1");
		
		try {
			//Database Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb","root","system");
			
			//Insert Query
			PreparedStatement ps=con.prepareStatement("insert into proj1 values(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mygender);
			ps.setString(5, mycity);
			
			int count=ps.executeUpdate();
			if(count>0) {
				response.setContentType("text/html");
				pw.print("<h3 style='color:green'>User registered Successfully</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/registerApp.jsp");
				rd.include(request, response);
				
			}
			else {
				response.setContentType("text/html");
				pw.print("<h3 style='color:red'>User not registered due to some error</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/registerApp.jsp");
				rd.include(request, response);
				
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			
			response.setContentType("text/html");
			pw.print("<h3 style='color:red'>Exception Occured: "+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/registerApp.jsp");
			rd.include(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
