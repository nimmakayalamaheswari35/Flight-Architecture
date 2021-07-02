package com.flight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookingHistoryInfo {

	public void displayBookingHistory(Map<String, List<BookingHistory>> historyMap, String userName) {

		List<BookingHistory> bookingList = historyMap.get(userName);
		Iterator<BookingHistory> iterator = bookingList.iterator();
		while (iterator.hasNext()) {
			BookingHistory history = iterator.next();
			System.out.println("flightNo: " + history.getFlightNo());
			System.out.println("Booking Date: " + history.getBookingDate());
			System.out.println("Source: " + history.getSource());
			System.out.println("Destionation: " + history.getDestination());
		}
		

	}
	
	
	public boolean flightBooking(BookingHistory  bookingHistory,Map<String,List<BookingHistory>> historyMap, String userName) {
		
		List<BookingHistory> bookingList = historyMap.get(userName);
		if(bookingList == null || bookingList.isEmpty()) {
			List<BookingHistory> list = new ArrayList<>();
			list.add(bookingHistory);
	    	historyMap.put(userName, list);
		}
		else {
			bookingList.add(bookingHistory);
		}
		
		System.out.println("Ticket Booking success");
		return true;
	}

}