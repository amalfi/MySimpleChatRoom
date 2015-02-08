package com.mycommunicator.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mycommunicator.model.Message;

public class MessageService 
{
	public static SessionFactory factory;
	
	public Session openSessionFromFactory()
	{
		Session session = null;
		try
		{
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    
    		if(factory==null)
	    	{	
		    	factory = configuration.buildSessionFactory(builder.build());		    	
	    	}
	    	session = factory.openSession();
    	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	return session;
	}
	
	public void saveMessage(Session session, Message message)
	{ 
		try
		{

    	session.beginTransaction();
    	
    	session.save(message);
    	
    	session.getTransaction().commit();
    	
		}
		catch(HibernateException he)
		{
			
			if(session!=null)
			{
			session.close();
			}
			System.out.println(he.getCause());
		}
	}

	
	public List<Message> getAllMessages(Session session, String senderLogin, String receiverLogin)
	{
		List<Message> allMessagesForGivenSenderAndReceiver = new ArrayList<Message>();
		try
		{
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from Message where senderLogin = :senderLogin ");
		query.setParameter("senderLogin", senderLogin );
		
		List list = query.list();
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++)
			{
				Message currentMessage = (Message)list.get(i);
				allMessagesForGivenSenderAndReceiver.add(currentMessage);
			}
		
		}
		
    	session.getTransaction().commit();
    	
		}
		catch(HibernateException he)
		{
			System.out.println(he.getCause());
			he.printStackTrace();
		}
		return allMessagesForGivenSenderAndReceiver;
	}
	
}
