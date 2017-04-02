package com.sumeet.contactapp.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
  private static Connection getConnection() throws URISyntaxException, SQLException {
		 
	        String username = "CONTACT";
	        String password = "CONTACT";
	        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	       
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        return DriverManager.getConnection(dbUrl, username, password);
	    }
  public static Connection jdbcConnection() throws URISyntaxException, SQLException
  {
	  return getConnection();
  }
  

}
