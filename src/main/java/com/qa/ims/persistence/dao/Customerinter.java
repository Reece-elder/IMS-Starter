package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistence.domain.Customer;

public  interface Customerinter <Customer> {
	
	Customer modelCustomer(ResultSet resultSet) throws SQLException;
	

}
