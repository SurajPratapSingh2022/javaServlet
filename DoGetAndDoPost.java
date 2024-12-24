package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/myLogin")
public class DoGetAndDoPost extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String myemail=(String) request.getParameter("name1");
		String mypass=(String) request.getParameter("pass1");
		
		if(myemail.equals("sps@gmail.com") && mypass.equals("sps@123")) {
			System.out.println("success");
		}
		else {
			System.out.println("failed");
		}
	}
}
