package com.flight;


import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Map;

public class RegisterUserInformation {

	String insertQuery = "insert into customer (firstName,lastName, dateOfbirth, contactNumber, userName, password, mailId)";

	public boolean registerUser(Registration reg, Map<String, Registration> registerMap, String userName) {

		try {
			Connection con = FlightDB.getdbConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date dob = sdf.parse(reg.getDateOfBirth());
			Date sqlDate = new Date(dob.getTime());
            System.out.println("dob  "+sqlDate);
			insertQuery = insertQuery + " values ('" + reg.getFirstName() + "','" + reg.getLastName() + "','" + sqlDate + "',"
					+ reg.getContactNumber() + ",'" + reg.getUserName() + "','" + reg.getPassword() + "','"
					+ reg.getMailId() + "')";
			System.out.println(insertQuery);
			Statement stmt = con.createStatement();
			stmt.execute(insertQuery);
			  
            	System.out.println("record inserted");
            
            return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
