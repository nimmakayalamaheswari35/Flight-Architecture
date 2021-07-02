package com.flight;

public class BookingHistory {
	
	private String flightNo;
	private String source;
	private String destination;
	private String bookingDate;
	private int cost;
	private String paymentMode;
	
	public BookingHistory(String flightNo, String source, String destination, String bookingDate) {
		super();
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.bookingDate = bookingDate;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	
	

}
