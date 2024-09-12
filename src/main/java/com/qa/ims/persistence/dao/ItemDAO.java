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

public class ItemDAO implements Dao<Item>,ItemsInterface {

	public static final Logger LOGGER = LogManager.getLogger();

	
	//model
	@Override
	public Item modelItems(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		double cost = resultSet.getDouble("cost");
		String name = resultSet.getString("name");
		return new Item(id,cost,name);
	}
	@Override
	public List<Item> readAll(){
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item");) {
			
			//items data type into array list
			List<Item> item = new ArrayList<>();
			while (resultSet.next()) {
				item.add(modelItems(resultSet));
			}
			
			return item;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
@Override
public Item read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM item ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelItems(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
}
	@Override 
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM item WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		}

@Override
public Item update(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement preStmt = connection
						.prepareStatement("UPDATE item SET cost = ?, name = ? WHERE id = ?");) {
			System.out.println("item has been connected");
			preStmt.setDouble(1, item.getCost());
			preStmt.setString(2, item.getName());
			preStmt.setLong(3, item.getId());
			preStmt.executeUpdate();
			return read(item.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
		
	
		

	
	}


@Override
public Item create(Item item) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement Stmt = connection
					.prepareStatement("INSERT INTO item(cost,name) VALUES (?, ?)");) {
		Stmt.setDouble(1, item.getCost());
		Stmt.setString(2, item.getName());
		
		Stmt.executeUpdate();
		return read();
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;

}


public Item read() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
		resultSet.next();
		return modelItems(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;

}


	




}