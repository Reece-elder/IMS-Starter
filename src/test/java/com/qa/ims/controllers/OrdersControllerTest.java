package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrdersController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrdersDAO dao;
	
	@InjectMocks
	private OrdersController controller;
	
	//testing creating an order
	@Test
	public void testCreate() {
		final Long orderId = 1L, customerId = 1L;
		final String orderDesc = "Apple", orderStatus = "Deleived";
		final Orders created = new Orders(orderId, customerId, orderDesc, orderStatus);

		Mockito.when(utils.getLong()).thenReturn(orderId, customerId);
		Mockito.when(utils.getString()).thenReturn(orderDesc, orderStatus);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	//testing updating an order
	@Test
	public void testUpdate() {
		Orders updated = new Orders(1L, 1L ,1L , "Apple", "Delievered");

		Mockito.when(this.utils.getLong()).thenReturn(updated.getDetailsId(), updated.getOrderId(), updated.getCustomerId());
		Mockito.when(this.utils.getString()).thenReturn(updated.getOrderDescription(), updated.getOrderStatus());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	//testing reading an order
	@Test
	public void testReadAll() {
		List<Orders> orders = new ArrayList<>();
		orders.add(new Orders(1L, 1L, 1L, "Apples", "Delivered"));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	//testing deleting orders
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}


}
