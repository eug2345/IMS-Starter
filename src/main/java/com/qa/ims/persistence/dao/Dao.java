package com.qa.ims.persistence.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.Item;

public interface Dao<T> {

	List<T> readAll();
	
	T read(Long id);

	T create(T t);

	Item update(Item item);

	int delete(long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;

}