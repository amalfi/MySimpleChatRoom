package com.mycommunicator.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */

public class SendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public SendingServlet() 
    { 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String message=null;
		String currentLoggedPerson = "TEST : ";
		message = currentLoggedPerson +request.getParameter("message");
		if(request.getParameter("message").toString().equals(""))
		{
			message="Hello User";
		}
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(message); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

}
