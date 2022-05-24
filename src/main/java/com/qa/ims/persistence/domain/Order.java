package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private int orderID;
	private int customerID;
	public Order(int orderID, int customerID) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerID, orderID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return customerID == other.customerID && orderID == other.orderID;
	}
	
	

}
