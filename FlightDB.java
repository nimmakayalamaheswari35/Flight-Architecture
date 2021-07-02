package com.flight;


import java.sql.Connection;
import java.sql.DriverManager;

public class FlightDB {

		public static Connection getdbConnection() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "Mahi@1122");
		return con;
			
			} catch (Exception e) {
			  e.printStackTrace();
		}
			
			
			return null;
		}
}
