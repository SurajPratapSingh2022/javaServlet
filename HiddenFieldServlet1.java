package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/servlet1")
public class HiddenFieldServlet1 extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("nm");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<form action='servlet2'><input type='hidden' name='user' value='"+name+"'><br><button type='submit'>Servlet2</button>");
		
	}
}
