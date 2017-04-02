package com.sumeet.contactapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.sumeet.contactapp.bean.Contacts;
import com.sumeet.contactapp.resources.JDBCConnection;




public class ContactDAOImpl implements ContactDAO {
 
	@Override
	public List<Contacts> getAllContacts() throws Exception {
		// TODO Auto-generated method stub
		List<Contacts> result=new ArrayList<Contacts>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{			
			String sql="select * from contacts";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	Contacts contact=new Contacts();
	        	Integer cId=rs.getInt("contact_id");
	        	String first=rs.getString("first_name");
	        	String last=rs.getString("last_name");
	        	String location=rs.getString("location");
	        	String pNo=rs.getString("phonenumber");	 
	        	contact.setContactId(cId);
	        	contact.setFirstName(first);
	        	contact.setLastName(last);
	        	contact.setLocation(location);
	        	contact.setPhoneNo(pNo);
	        	
	        	result.add(contact);
	        }
	    }
		catch(Exception e)
 {
			e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR");
		} finally {
			if (connection != null)
				connection.close();
			if (session != null)
				session.close();
		}
				
			return result;
	}
	
	
	@Override
	public List<Contacts> getContactById(Integer contactId) throws Exception {
		// TODO Auto-generated method stub
		List<Contacts> result=new ArrayList<Contacts>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{			
			String sql="select * from contacts where contact_Id=?";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ps.setInt(1, contactId);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next())
	        {	Contacts contact=new Contacts();
	        	
	        	String first=rs.getString("first_name");
	        	String last=rs.getString("last_name");
	        	String location=rs.getString("location");
	        	String pNo=rs.getString("phonenumber");	 
	        	contact.setContactId(contactId);
	        	contact.setFirstName(first);
	        	contact.setLastName(last);
	        	contact.setLocation(location);
	        	contact.setPhoneNo(pNo);
        	
        	result.add(contact);
	        }
	        //System.out.println(result);
		}
		catch(Exception e)
		{e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR"); 
		}finally {
			if(connection!=null)
	        	 connection.close();
			if(session!=null)
				session.close();
		} 
				
			return result;
	}
	



	 public static void main(String[] args) {
		ContactDAOImpl dao=new ContactDAOImpl();
		try {
			//System.out.println(dao.getAllContacts().get(1).getFirstName());
			System.out.println(dao.getContactById(1).get(0).getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}