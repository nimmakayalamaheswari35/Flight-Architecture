package com.flight;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class FlightBookingMainTest {
	
	private Map<String,List<BookingHistory>> historyMap = new HashMap<>(); 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	public void loginTest() {
		 String userName = "ABC";
		 String password = "XYZ";
		 Login login = new Login();
		 
		 assertTrue(login.getLogin(userName, password));
	}
	
	@Test
	public void loginFalse() {
		String userName = "Sravani";
		String password="srava12";
		Login l1 = new Login();
		
		assertFalse(l1.getLogin(userName, password));
	}
	
	
	@Test
	public void addRegistration() {
		Map<String, Registration> registerMap = new HashMap<>();
		String firstName = "Maheswari";
		String lastName = "Nimmakayala";
		String dateOfBirth = "22-11-1999";
		String contactNumber = "12356";
		String userName = "Mahi";
        String password="chinni";
        String mailId="mahi35@gmail.com";
		
		
		Registration reg =  new Registration(firstName, lastName, dateOfBirth, contactNumber, userName, password, mailId);
		RegisterUserInformation regInfo = new RegisterUserInformation();
		assertTrue(regInfo.registerUser(reg, registerMap, userName));
	}
	
	
	@Test
	public void flightBooking() {
		
		String flightNo = "";
		int cost = 9000;		
		String paymnetMode = "Debitcard";
		String source = "Kadapa";
		String destination = "Rajahmundry";
		String BookingDate = "01-07-2021";
		String userName = "jyothi";
		BookingHistory  bookingHistory = new BookingHistory(flightNo,source,destination,BookingDate);
		bookingHistory.setPaymentMode(paymnetMode);
		bookingHistory.setCost(cost);
		
		BookingHistoryInfo bookingInfo = new BookingHistoryInfo();
		assertTrue(bookingInfo.flightBooking(bookingHistory, historyMap, userName));
	
	}

}
