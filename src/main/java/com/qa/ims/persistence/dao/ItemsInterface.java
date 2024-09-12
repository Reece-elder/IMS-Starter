package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemsInterface <Item> {



com.qa.ims.persistence.domain.Item modelItems(ResultSet resultSet) throws SQLException;
	
	
	

}
