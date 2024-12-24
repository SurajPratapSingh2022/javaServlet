package com.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/DefaultServlet")
public class DefaultServlet implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init default servlet");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy default servlet");
	}


	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		response.getWriter().print("Default Servlet");
		
	}

}
