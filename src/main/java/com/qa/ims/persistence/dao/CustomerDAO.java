package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class CustomerDAO implements Dao<Customer>,Customerinter {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Customer modelCustomer(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		return new Customer(id, firstName, surname,username,password);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Customer> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");) {
			List<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(modelCustomer(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
	public Customer read() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelCustomer(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement Stmt = connection
						.prepareStatement("INSERT INTO customers(first_name, surname,username,password) VALUES (?, ?,?,?)");) {
			Stmt.setString(1, customer.getFirstName());
			Stmt.setString(2, customer.getSurname());
			Stmt.setString(3, customer.getUsername());
			Stmt.setString(4, customer.getPassword());
			Stmt.executeUpdate();
			return read();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
@Override
	public Customer read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelCustomer(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
//edited query
@Override
	public Customer update(Customer customer) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE customers SET first_name = ?, surname = ? , username =?, password =? WHERE id = ?");) {
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getSurname());
			statement.setString(3, customer.getUsername());
			statement.setString(4, customer.getPassword());
			statement.setLong(5, customer.getId());
			statement.executeUpdate();
			return read(customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	}


	

