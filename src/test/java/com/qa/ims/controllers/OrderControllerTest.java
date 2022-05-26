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

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final long CUSTOMER_ID = 1L;
		final double COST = 12.25;
		final Order created = new Order(CUSTOMER_ID, COST);

		

		Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID);
		Mockito.when(utils.getDouble()).thenReturn(COST);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

//		Mockito.verify(utils, Mockito.times(2)).getString();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(2L, 123L, 43.45));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		
		System.out.println("============================");
		Order updated = new Order(1L, 1L, 12.25);
		System.out.println(updated);
		Mockito.when(this.utils.getLong()).thenReturn(1L, 1L);
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		System.out.println(updated);
		System.out.println(this.controller.update());
		assertEquals(updated, this.controller.update());
		
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(2)).getString();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

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
