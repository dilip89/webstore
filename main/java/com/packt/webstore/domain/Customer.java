package com.packt.webstore.domain;

public class Customer {
	private String name;
	private String address;
	private String customerId;
	private long noOfOrdersMade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
	
	public Customer() {
		super();
	}
	public Customer(String customerId, String name, String address) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
	}

}
