package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
public static Connection getConnection(){
	Connection con = null;
	String url = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_8daee007ef5afd1?user=b3527457f86adc&password=78356fe2";
	String uname = "b3527457f86adc";
	String pass="78356fe2";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, uname, pass);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	
}
	
}
