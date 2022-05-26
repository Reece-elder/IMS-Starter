package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private long id;
	private long customerID;
	private double cost;
	public Order(long id, long customerID, double cost) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.cost = cost;
		
		
	}
	public Order(long customerID, double cost) {
		super();
		this.customerID = customerID;
		this.cost = cost;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerID=" + customerID + ", cost=" + cost + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (customerID ^ (customerID >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
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
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (customerID != other.customerID)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
