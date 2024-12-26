package com.servlet;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class CustomTagServlet1 extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			JspWriter out=pageContext.getOut();
			out.print("<h1>Good Morning</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
