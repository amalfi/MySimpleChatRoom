package com.mycommunicator.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.mycommunicator.model.Message;

/**
 * Servlet implementation class ActionServlet
 */

public class ReceivingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ReceivingServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		String senderLogin = String.valueOf(request.getParameter("sender"));
		String receiverLogin = String.valueOf(request.getParameter("receiver"));
		MessageService messageService = new MessageService();
		Session session=null;
		List<Message> allMessagesForGivenSenderAndReceiver = new ArrayList<Message>();
		try
		{
		session = messageService.openSessionFromFactory();
		allMessagesForGivenSenderAndReceiver = messageService.getAllMessages(session,senderLogin, receiverLogin);
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
		String messagesJSON = returnMessagesAsJSON(allMessagesForGivenSenderAndReceiver);		
		
		response.setContentType("application/json");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(messagesJSON); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
	
	private static String returnMessagesAsJSON(List<Message> allMessagesForGivenSenderAndReceiver)
	{
		String messagesAsJSON ="";
		Gson gson = new Gson();
		try
		{
			messagesAsJSON=gson.toJson(allMessagesForGivenSenderAndReceiver);
		}
		catch(Exception e)
		{
			System.out.println(e.getCause());
		}
		return messagesAsJSON;
	}

}
