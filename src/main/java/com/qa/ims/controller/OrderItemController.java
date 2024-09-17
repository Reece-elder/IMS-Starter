//package com.qa.ims.controller;
//

// EVIDENCE OF PREVIOUS WORK, DO NOT USE

//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.qa.ims.persistence.dao.OrderItemDAO;
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.OrderItem;
//import com.qa.ims.utils.Utils;
//
//public class OrderItemController implements CrudController<OrderItem>{
//	public static final Logger LOGGER = LogManager.getLogger();
//	
//	private OrderItemDAO orderItemDAO;
//	private Utils utils;
//
//	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
//		super();
//		this.orderItemDAO = orderItemDAO;
//		this.utils = utils;
//	}
//	
//	/**
//	 * Reads all order items to the logger
//	 */
//	@Override
//	public List<OrderItem> readAll() {
//		List<OrderItem> orderItems = orderItemDAO.readAll();
//		for (OrderItem orderItem : orderItems) {
//			LOGGER.info(orderItem);
//		}
//		return orderItems;
//	}
//	
//	/**
//	 * Creates an order item by taking in user input
//	 */
//	@Override
//	public OrderItem create() {
//		LOGGER.info("Please enter a cost");
//		double cost = utils.getDouble();
//		LOGGER.info("Please enter a name");
//		String name = utils.getString();
//		LOGGER.info("Please enter an order ID");
//		Long orderID = utils.getLong();
//		LOGGER.info("Please enter an item ID");
//		Long itemID = utils.getLong();
//		OrderItem orderItem = orderItemDAO.create(new OrderItem(cost, name, orderID, itemID));
//		LOGGER.info("Customer created");
//		return orderItem;
//	}
//	
//	@Override
//	public OrderItem update() {
//		LOGGER.info("Please enter the id of the order item you would like to update");
//		Long id = utils.getLong();
//		LOGGER.info("Please enter a cost");
//		double cost = utils.getDouble();
//		LOGGER.info("Please enter a name");
//		String name = utils.getString();
//		LOGGER.info("Please enter an order ID");
//		Long orderID = utils.getLong();
//		LOGGER.info("Please enter an item ID");
//		Long itemID = utils.getLong();
//		OrderItem orderItem = orderItemDAO.update(new OrderItem(id, cost, name, orderID, itemID));
//		LOGGER.info("Order item Updated");
//		return orderItem;
//	}
//	
//	/**
//	 * Deletes an existing order item by the id of the order item
//	 * 
//	 * @return
//	 */
//	@Override
//	public int delete() {
//		LOGGER.info("Please enter the id of the order item you would like to delete");
//		Long id = utils.getLong();
//		return orderItemDAO.delete(id);
//	}
//
//	
//	
//}
