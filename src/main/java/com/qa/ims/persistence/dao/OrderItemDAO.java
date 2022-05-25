package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.OrderItem;

public class OrderItemDAO implements Dao<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		double cost = resultSet.getDouble("cost");
		String name = resultSet.getString("name");
		long orderID = resultSet.getLong("orderID");
		long itemID = resultSet.getLong("itemID");
		return new OrderItem(id, cost, name, orderID, itemID);
	}
	
	

}
