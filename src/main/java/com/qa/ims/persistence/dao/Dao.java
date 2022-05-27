package com.qa.ims.persistence.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.domain.Customer1;
import com.qa.ims.persistence.domain.Item;

public interface Dao<T> {

	List<Customer1> readAll();
	
	T read(Long id);

	T create(T t);

	Item update(Item item);

	int delete(long id);

	Customer1 modelFromResultSet(ResultSet resultSet) throws SQLException;

	Order addItem(Long orderID);

	void addOrder(Long orderID);

}