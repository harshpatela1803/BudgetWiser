package com.model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Client;
import com.dao.DBConnector;

public class ClientModel {

	private static final String LOGIN_TABLE = "login";
	private static final String LOGIN_COLUMN_USERNAME = "username";
	private static final String LOGIN_COLUMN_PASSWORD = "password";
//	private static final String LOGIN_COLUMN_LOGINID = "comments";
	private static final String LOGIN_COLUMN_FIRSTNAME = "firstname";
	private static final String LOGIN_COLUMN_LASTNAME = "lastname";
	
	
	public static Client checkLogin(Client client){
		
		Connection con = DBConnector.getConnection();
		try{
			
		Statement st = con.createStatement();
		String sql = "select * from  login where "+LOGIN_COLUMN_USERNAME+"='"+client.getUsername()+"' && "+LOGIN_COLUMN_PASSWORD+"='"+client.getPassword()+"' ";
		System.out.println("sql string::"+sql);
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
		while(rs.next()){
			String username = rs.getString(LOGIN_COLUMN_USERNAME);
			String password = rs.getString(LOGIN_COLUMN_PASSWORD);
//			String comments = rs.getString(LOGIN_COLUMN_LOGINID);
//			System.out.println("Comments is::"+comments);
			client.setUsername(username);
			client.setPassword(password);
		}
		}
		else{
			client=null;
		}
		
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		
		
		return client;
		
	}

	public static void  addUser(Client client) {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "insert into login ("+LOGIN_COLUMN_FIRSTNAME+","+LOGIN_COLUMN_LASTNAME+","+LOGIN_COLUMN_USERNAME+","+LOGIN_COLUMN_PASSWORD+") values ('"+client.getFirstname()+"','"+client.getLastname()+"','"+client.getUsername()+"','"+client.getPassword()+"')   ";
			System.out.println("ssql::"+sql);
			st.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

