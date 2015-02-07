package com.mycommunicator.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageService 
{

	public void saveMessage(String query)
	{ 
		Statement st = null;
	    ResultSet rs = null;
	      
	    Connection con = getConnectionToDB();
		try
		{
			st = con.createStatement();
	        st.executeUpdate(query);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		   finally
	        {
	            try 
	            {
	                if (rs != null) 
	                {
	                    rs.close();
	                }
	                if (st != null) 
	                {
	                    st.close();
	                }
	                if (con != null) 
	                {
	                    con.close();
	                }
	            } 
	            catch (SQLException ex)
	            {
	              System.out.println(ex.getCause());
	            }
	        }
    }

	
	public List<Message> getAllMessages(String query)
	{
		List<Message> allMessages = new ArrayList<Message>();
		Statement st = null;
	    ResultSet rs = null;
	      
	    Connection con = getConnectionToDB();
		
	    try
		{
			st = con.createStatement();
			rs = st.executeQuery(query);
			  if (rs.next()) 
			  {
	                System.out.println(rs.getString(""));
	           }
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		   finally
	        {
	            try 
	            {
	                if (rs != null) 
	                {
	                    rs.close();
	                }
	                if (st != null) 
	                {
	                    st.close();
	                }
	                if (con != null) 
	                {
	                    con.close();
	                }
	            } 
	            catch (SQLException ex)
	            {
	              System.out.println(ex.getCause());
	            }
	        }
		
		return allMessages;
	}
	
	private Connection getConnectionToDB()
	{
		 	Connection con = null;
	    
	        String url = "jdbc:postgresql://localhost/testdb";
	        String user = "postgres";
	        String password = "postgres";
	        
	        try 
	        {
	            con = DriverManager.getConnection(url, user, password);
	        } 
	        catch (SQLException ex) 
	        {
	        	System.out.println(ex.getCause());
	        }
	        finally
	        {
	            try
	            {
	                if (con != null) 
	                {
	                    con.close();
	                }

	            } 
	            catch (SQLException ex)
	            {
	              System.out.println(ex.getCause());
	            }
	        }
	        
	        return con;
	}
}
