package com.litmus7.training.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	private static String Db_url="jdbc:mysql://localhost:3306/library";
	private  static String user= "root";
	private static String password="";
	public ConnectionUtility() {}
    
	@SuppressWarnings("static-access")
	public  ConnectionUtility(String db_url, String user, String password) {
		super();
		Db_url = db_url;
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() {
		Connection con =null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		   con=DriverManager.getConnection(  
				Db_url,user,password);  
		  
		   
		
		}catch(Exception e)
		{ 
			System.out.println(e);
		}  
		
		
		return con;
	}

	public void conClose(Connection con) {

      try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
