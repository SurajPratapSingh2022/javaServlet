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
public class UrlRewritingServlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("nm");
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.print("<h1>Name: "+name+"</h1>");
		out.print("<a href='servlet2?username="+name+"'>Servlet 2</a>");
		
	}

}
