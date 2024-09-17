//package com.qa.ims.persistence.domain;
//

// EVIDENCE OF PREVIOUS WORK, DO NOT USE

//import java.util.Objects;
//
//public class OrderItem {
//	private long ID;
//	private double cost;
//	private String name;
//	private long orderID;
//	private long itemID;
//	
//	public OrderItem(double cost, String name, long orderID, long itemID) {
//		super();
//		this.cost = cost;
//		this.name = name;
//		this.orderID = orderID;
//		this.itemID = itemID;
//	}
//
//	public OrderItem(long iD, double cost, String name, long orderID, long itemID) {
//		super();
//		ID = iD;
//		this.cost = cost;
//		this.name = name;
//		this.orderID = orderID;
//		this.itemID = itemID;
//	}
//
//	public long getID() {
//		return ID;
//	}
//
//	public void setID(int iD) {
//		ID = iD;
//	}
//
//	public double getCost() {
//		return cost;
//	}
//
//	public void setCost(float cost) {
//		this.cost = cost;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public long getOrderID() {
//		return orderID;
//	}
//
//	public void setOrderID(int orderID) {
//		this.orderID = orderID;
//	}
//
//	public long getItemID() {
//		return itemID;
//	}
//
//	public void setItemID(int itemID) {
//		this.itemID = itemID;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderItem [ID=" + ID + ", cost=" + cost + ", name=" + name + ", orderID=" + orderID + ", itemID="
//				+ itemID + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(ID, cost, itemID, name, orderID);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderItem other = (OrderItem) obj;
//		return ID == other.ID && Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
//				&& itemID == other.itemID && Objects.equals(name, other.name) && orderID == other.orderID;
//	}
//
//	
//	
//	
//	
//	
//
//}
