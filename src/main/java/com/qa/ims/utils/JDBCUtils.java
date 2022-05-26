package com.qa.ims.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCUtils<Fish> {
	// When testing the app, using a testDatabase 
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/petShop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		final String USER = "root";
		final String PASSWORD = "root";
		Connection conn;
		
		public Connection connect() {
			
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(JDBC_DRIVER, USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
				return conn;
			}
			System.out.println("Connected to Database succesfully :)");
			return conn;

		}

		public Object convertResults(ResultSet result) {
			try {
				result.getLong("id");
				String type = result.getString("type");
				result.getString("colour");
				result.getInt("length");
				result.getFloat("cost");

				return new File(type);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

	}