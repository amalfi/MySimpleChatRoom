package com.mycommunicator.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mycommunicator.model.Message;

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
		
		String senderLogin = String.valueOf(request.getParameter("sender"));
		String receiverLogin = String.valueOf(request.getParameter("receiver"));
		String messageContent = String.valueOf(request.getParameter("message"));
		
		Message messageObject = new Message();
		messageObject.setMessageContent(messageContent);
		messageObject.setReceiverLogin(receiverLogin);
		messageObject.setSenderLogin(senderLogin);
		
		Session session=null;
		try
		{
			MessageService messageService = new MessageService();
			session = messageService.openSessionFromFactory();
			messageService.saveMessage(session, messageObject);		
		}
		catch(HibernateException e)
		{
			e.getCause();
			e.printStackTrace();
		}
		finally
		{
			session.close();	
		}
		
		message = senderLogin + ":" + messageContent;
		
		if(request.getParameter("message").toString().equals(""))
		{
			message="EMPTY MESSAGE";
		}
		
		//save message to db
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(message); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

}
