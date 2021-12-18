package com.wc.model;

import java.util.Date;

public class CustomerEvent {

	private String customerName;
	private Date date;

	public CustomerEvent(String customerName, Date date) {
		super();
		this.customerName = customerName;
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
