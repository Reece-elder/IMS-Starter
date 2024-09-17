//package com.qa.ims.controllers;
//
//import static org.junit.Assert.assertEquals;

// EVIDENCE OF PREVIOUS WORK, DO NOT USE

//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.ims.controller.CustomerController;
//import com.qa.ims.controller.OrderItemController;
//import com.qa.ims.persistence.dao.CustomerDAO;
//import com.qa.ims.persistence.dao.OrderItemDAO;
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.OrderItem;
//import com.qa.ims.utils.Utils;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrderItemControllerTest {
//	
//	@Mock
//	private Utils utils;
//
//	@Mock
//	private OrderItemDAO dao;
//
//	@InjectMocks
//	private OrderItemController controller;
//
//	@Test
//	public void testCreate() {
//		final double COST = 12.25;
//		final String  NAME = "testorderitem";
//		final long ORDER_ID = 1066;
//		final long ITEM_ID = 867;
//		final OrderItem created = new OrderItem(COST, NAME, ORDER_ID, ITEM_ID);
//		
//		Mockito.when(utils.getDouble()).thenReturn(COST);
//		Mockito.when(utils.getString()).thenReturn(NAME);
//		Mockito.when(utils.getLong()).thenReturn(ORDER_ID, ITEM_ID);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
////		Mockito.verify(utils, Mockito.times(2)).getString();
////		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}
//
//	@Test
//	public void testReadAll() {
//		List<OrderItem> orderitems = new ArrayList<>();
//		orderitems.add(new OrderItem(2L, 15.50, "orderitemtest2", 1234, 5678));
//
//		Mockito.when(dao.readAll()).thenReturn(orderitems);
//
//		assertEquals(orderitems, controller.readAll());
//
//		Mockito.verify(dao, Mockito.times(1)).readAll();
//	}
//
//	@Test
//	public void testUpdate() {
//		OrderItem updated = new OrderItem(1L, 12.25, "testorderitem", 1066, 867);
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getOrderID(), updated.getItemID());
//		Mockito.when(this.utils.getDouble()).thenReturn(updated.getCost());
//		Mockito.when(this.utils.getString()).thenReturn(updated.getName());
//		
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
////		Mockito.verify(this.utils, Mockito.times(1)).getLong();
////		Mockito.verify(this.utils, Mockito.times(2)).getString();
////		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}
//
//	@Test
//	public void testDelete() {
//		final long ID = 1L;
//
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(dao.delete(ID)).thenReturn(1);
//
//		assertEquals(1L, this.controller.delete());
//
////		Mockito.verify(utils, Mockito.times(1)).getLong();
////		Mockito.verify(dao, Mockito.times(1)).delete(ID);
//	}
//
//
//}
