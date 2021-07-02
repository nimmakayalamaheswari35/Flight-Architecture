package com.flight;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FlightBookingMain {
	
	private String userName;
	
	Map<String, Registration> registerMap = new HashMap<>();
	List<String> loginList =  new ArrayList<>();
	
	Map<String, List<String>> flightInfoMap = new HashMap<>();
	

	private final String flight1 = "Emirates"; 
	private final String flight2 = "Indigo"; 
	private final String flight3 = "GoAir"; 
	private final String flight4 = "AirIndia"; 
	
	private  String[] flight1Timing = {"06.00","11.00", "14.30", "21.00"};
	private  String[] flight2Timing = {"08.00","15.00", "16.30", "21.00"};
	private  String[] flight3Timing = {"09.00","14.00", "16.30", "22.00"};
	private  String[] flight4Timing = {"03.00","11.00", "18.30", "20.00"};
	
	
	private Map<String,List<BookingHistory>> historyMap = new HashMap<>(); 
	
	public static void main(String[] args) {
		FlightBookingMain fbm = new FlightBookingMain();
		fbm.loadFlightData();
		fbm.getLogin();
		   //calling login method

	}
	
	private void loadFlightData() {
		
		flightInfoMap.put(flight1, Arrays.asList(flight1Timing));
		flightInfoMap.put(flight2, Arrays.asList(flight2Timing));
		flightInfoMap.put(flight3, Arrays.asList(flight3Timing));
		flightInfoMap.put(flight4, Arrays.asList(flight4Timing));
		
	}
	
	
	private void getLogin() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter user name: ");
		String userName = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		Login login = new Login();
		
		boolean isValid = login.getLogin(userName, password);
	//	scanner.close();
		if(isValid) {
			this.userName = userName;
			System.out.println("Login success");
			loginList.add(userName);
			//login success
			flightTicketBooking();
		}
		else {
			//calling registration
			System.out.println("Login failed");
			register();
		}
		
		//Flight ticket booking
		
		
		
	}
	
	
	private void register() {
		
		 String firstName;
		 String lastName;
		 String dateOfBirth;
		 String contactNumber;
		 String userName;
		 String password;
		 String mailId;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter user first name: ");
		firstName = scanner.nextLine();
		System.out.println("Enter user last name");
		lastName = scanner.nextLine();
		System.out.println("Enter Date Of Birth");
		dateOfBirth = scanner.nextLine();
		
		System.out.println("Enter contact number: ");
		contactNumber = scanner.nextLine();
		System.out.println("Enter mail id: ");
		mailId = scanner.nextLine();
		System.out.println("Enter user name");
		userName = scanner.nextLine();
		System.out.println("Enter password");
		password = scanner.nextLine();
		
		Registration reg =  new Registration(firstName, lastName, dateOfBirth, contactNumber, userName, password, mailId);
		RegisterUserInformation regInfo = new RegisterUserInformation();
		regInfo.registerUser(reg, registerMap, userName);
	   // registerMap.put(userName, reg);
	    scanner.close();
	}
	
	private void flightTicketBooking() {
			
		System.out.println(" Choose Your option - 1. Booking History 2. New Booking");
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.nextLine());
		//scanner.close();
		if(option == 1) {
			//display History
			displayBookingHistory();
		}
		else if(option == 2) {
			//flight Booking
			flightBooking();
		}
	}
	
	
	private void displayBookingHistory() {
		
		BookingHistoryInfo bookingInfo = new BookingHistoryInfo();
		bookingInfo.displayBookingHistory(historyMap, userName);
	}
	
	private void flightBooking() {

		//display flight information
		FlightDetails();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Flight No");
		String flightNo = scanner.nextLine();
		System.out.println("Enter Flight Timing");
		String timing =  scanner.nextLine();
		System.out.println("Enter Number of seats");
		String seats =  scanner.nextLine();
		System.out.println("Enter Destionation: ");
		String destination = scanner.nextLine();
		System.out.println("Enter source");
		String source = scanner.nextLine();
		int cost = 9000;
		System.out.println("Total cose (Inc. Tax): INR "+cost);
		String BookingDate = new Date().toString();
		BookingHistory  bookingHistory = new BookingHistory(flightNo,source,destination,BookingDate);
    	System.out.println("Enter payment mode");
		System.out.println("Credit Card,  Debit Card, NetBanking, QR Code");
		String paymnetMode = scanner.nextLine();
		bookingHistory.setPaymentMode(paymnetMode);
		bookingHistory.setCost(cost);
		
		BookingHistoryInfo bookingInfo = new BookingHistoryInfo();
		bookingInfo.flightBooking(bookingHistory, historyMap, userName);
		
		
		
		System.out.println("Cancel Ticket, Booking History,  Exit");
		String option = scanner.nextLine();
		
		if("Booking History".equals(option)) {
			displayBookingHistory();
		}
		
		scanner.close();
	}
	
	private void FlightDetails() {
		
		Iterator<String> iterator = flightInfoMap.keySet().iterator();
		while(iterator.hasNext()) {
			String keyFlightNo = iterator.next();
			List<String> timingList = flightInfoMap.get(keyFlightNo);
			
			flightTimings(timingList, keyFlightNo);
		}
	}
	
	
	private void flightTimings(List<String> timingsList, String flightNo) {
		System.out.println("-----------------------");
		System.out.println("Flight No: "+flightNo +" Timings are: ");
		Iterator<String> iterator = timingsList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
		System.out.println();
	}
	

}