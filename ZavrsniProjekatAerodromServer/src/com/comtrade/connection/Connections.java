package com.comtrade.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connections  {
	
	public static Connections object;
	public Connection con;
	private Connections() {
		readDriver();
	}
	private void readDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connections getObject() {
		if(object==null) {
			object=new Connections();
		}
		return object;
	}
	public void startTransaction() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void confirmTransaction() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reverseTransaciton() {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeConection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return con;
	}

	
}
