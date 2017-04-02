package com.sumeet.contactapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.sumeet.contactapp.bean.Messages;
import com.sumeet.contactapp.resources.JDBCConnection;




public class MessageDAOImpl implements MessageDAO {
	
	
//Get messages from the database
	@Override
	public List<Messages> getAllMessages() throws Exception {
		// TODO Auto-generated method stub
		List<Messages> result=new ArrayList<Messages>();
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{			
			String sql="select c.contact_id,c.first_name,c.last_name, m.message_desc, m.sent from messages m inner join contacts c on m.contact_id= c.contact_id ORDER BY sent DESC";
	        PreparedStatement ps=connection.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next())
	        {	Messages msg=new Messages();
	        	Integer cId=rs.getInt("contact_id");
	        	String fName=rs.getString("first_name");
	        	String lName=rs.getString("last_name");
	        	String desc=rs.getString("message_desc");
	        	Calendar cal=Calendar.getInstance();   
	        	Date d=rs.getDate("sent"); 	
	        	String pattern = "yyyy-MM-dd hh:mm:ss a";
	        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        	String conDate=simpleDateFormat.format(d);	
	        	msg.setFirstName(fName);
	        	msg.setLastName(lName);
	        	msg.setContactId(cId);
	        	msg.setMessageDesc(desc);
	        	msg.setConvDate(conDate);
	           	result.add(msg);
	        }
	    }
		catch(Exception e)
 {			e.printStackTrace();
			throw new Exception("DATABASE_TECHINAL_ERROR");
		} finally {
			if (connection != null)
				connection.close();
			if (session != null)
				session.close();
		}
				
			return result;
	}
	
	
//add messages into the database
	@Override
	public String addMessages(Integer cId, Integer otp) throws Exception {
		// TODO Auto-generated method stub
		String success="";
		Integer mId=null;
		Integer noOfRows=null;
		String otp1=otp+"";
		Connection connection = JDBCConnection.jdbcConnection();
		Session session=null;
		try{
			String sql="select max(message_id) as maxid from messages";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 while(rs.next())
		        {
				 mId=rs.getInt("maxid");
		        }
			
			 //String sql1="insert into messages values (?,?,?,sysDate)";
			 String sql1="insert into messages (message_id,contact_id,message_desc,sent)  values (?,?,?,?)";
				PreparedStatement ps1=connection.prepareStatement(sql1);
			
				ps1.setInt(1, mId+1);
				ps1.setInt(2, cId );
				ps1.setString(3, otp1);
				Calendar cal=Calendar.getInstance();
				ps1.setDate(4, new java.sql.Date(cal.getTimeInMillis()));
								
				noOfRows=ps1.executeUpdate();
				if(noOfRows>0){
					success="OTP sent successfully";
				}
				else{
					success="Sent Failed !!! Please Try Again";
				}
		}
			catch(Exception e)
			
			{	e.printStackTrace();
				throw new Exception("DATABASE_TECHINAL_ERROR");
			} finally {
				if (connection != null)
					connection.close();
				if (session != null)
					session.close();
			}
					
				return success;
		}
		
	
	public static void main(String[] args) {
		MessageDAOImpl dao=new MessageDAOImpl();
		try {
			//System.out.println(dao.getAllMessages().get(0).getConvDate());
			System.out.println(dao.addMessages(3, 8893547));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}