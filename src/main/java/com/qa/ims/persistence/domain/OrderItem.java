package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	private int ID;
	private float cost;
	private String name;
	private int orderID;
	private int itemID;
	
	public OrderItem(float cost, String name, int orderID, int itemID) {
		super();
		this.cost = cost;
		this.name = name;
		this.orderID = orderID;
		this.itemID = itemID;
	}

	public OrderItem(int iD, float cost, String name, int orderID, int itemID) {
		super();
		ID = iD;
		this.cost = cost;
		this.name = name;
		this.orderID = orderID;
		this.itemID = itemID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	@Override
	public String toString() {
		return "OrderItem [ID=" + ID + ", cost=" + cost + ", name=" + name + ", orderID=" + orderID + ", itemID="
				+ itemID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, cost, itemID, name, orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return ID == other.ID && Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
				&& itemID == other.itemID && Objects.equals(name, other.name) && orderID == other.orderID;
	}
	
	
	
	
	

}
