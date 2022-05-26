//package com.qa.ims.persistence.dao;

// EVIDENCE OF PREVIOUS WORK, DO NOT USE

//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.OrderItem;
//import com.qa.ims.utils.DBUtils;
//
//public class OrderItemDAO implements Dao<OrderItem> {
//	
//	public static final Logger LOGGER = LogManager.getLogger();
//	
//	@Override
//	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
//		Long id = resultSet.getLong("id");
//		double cost = resultSet.getDouble("cost");
//		String name = resultSet.getString("name");
//		long orderID = resultSet.getLong("orderID");
//		long itemID = resultSet.getLong("itemID");
//		return new OrderItem(id, cost, name, orderID, itemID);
//	}
//	
//	/**
//	 * Reads all order items from the database
//	 * 
//	 * @return A list of order items
//	 */
//	@Override
//	public List<OrderItem> readAll() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderItems");) {
//			List<OrderItem> orderitems = new ArrayList<>();
//			while (resultSet.next()) {
//				orderitems.add(modelFromResultSet(resultSet));
//			}
//			return orderitems;
//		} catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return new ArrayList<>();
//	}
//	
//	@Override
//	public OrderItem readLatest() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderItems ORDER BY id DESC LIMIT 1");) {
//			resultSet.next();
//			return modelFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	
//	
//	// Creates an order item in the database
//	@Override
//	public OrderItem create(OrderItem orderitem) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection
//						.prepareStatement("INSERT INTO orderItems(cost, name, orderID, itemID) VALUES (?, ?, ?, ?)");) {
//			statement.setDouble(1, orderitem.getCost());
//			statement.setString(2, orderitem.getName());
//			statement.setLong(3, orderitem.getOrderID());
//			statement.setLong(4, orderitem.getItemID());
//			statement.executeUpdate();
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	
//	@Override
//	public OrderItem read(Long id) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderItems WHERE id = ?");) {
//			statement.setLong(1, id);
//			try (ResultSet resultSet = statement.executeQuery();) {
//				resultSet.next();
//				return modelFromResultSet(resultSet);
//			}
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	
//	@Override
//	public OrderItem update(OrderItem orderitem) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection
//						.prepareStatement("UPDATE orderItems SET cost = ?, name = ?, orderID = ?, itemID = ? WHERE id = ?");) {
//			statement.setDouble(1, orderitem.getCost());
//			statement.setString(2, orderitem.getName());
//			statement.setLong(3, orderitem.getOrderID());
//			statement.setLong(4, orderitem.getItemID());
//			statement.setLong(5, orderitem.getID());
//			statement.executeUpdate();
//			return read(orderitem.getID());
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
//	
//	/**
//	 * Deletes a customer in the database
//	 * 
//	 * @param id - id of the customer
//	 */
//	@Override
//	public int delete(long id) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderItems WHERE id = ?");) {
//			statement.setLong(1, id);
//			return statement.executeUpdate();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return 0;
//	}
//	
//	
//
//}