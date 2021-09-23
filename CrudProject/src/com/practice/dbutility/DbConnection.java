package com.practice.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	String url = "jdbc:mysql://localhost:3306/db2";
	String uname = "root";
	String passw = "Aditya@20";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, passw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
