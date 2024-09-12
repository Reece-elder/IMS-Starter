package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

public interface Dao<T> {

	
	
	T read(Long id);

	T create(T t);

	T update(T t);

	int delete(long id);

	

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	List<T> readAll();

	T read();

	

	

	//Item readLatestitem(long id);

	//int deleteItem(long id);

	//Item updateitem(Item item);

	//List<Item> readallitem();

	//Item modelitems(ResultSet resultSet) throws SQLException;

	//Customer readLatest();

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	//List<Customer> readAll();
}
