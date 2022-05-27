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

import com.qa.ims.persistence.domain.Customer1;
import com.qa.ims.utils.DBUtils;

public abstract class CustomerDAO<DAO, executeQuery> implements Dao<Customer1> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Customer1 modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String firstName = resultSet.getString("first_name");
		String surname = resultSet.getString("surname");
		return new Customer1(id, firstName, surname);
	}

	/**
	 * Reads all customers from the database
	 * @param <executeQuery>
	 * 
	 * @return A list of customers
	 */
	
	@SuppressWarnings("hiding")
	public  <executeQuery> CustomerDAO() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");) {
			List<Customer1> customer = new ArrayList<>();
			while (resultSet.next()) {
				customer.add(modelFromResultSet(resultSet));
				
			}
			return;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return;
	}

	public Customer1 readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database
	 * 
	 * @param item - takes in a customer object. id will be ignored
	 */
	public Customer create(Customer customer) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO customers(first_name, surname) VALUES (?, ?)");) {
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getSurname());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer1 read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * @param <customer>
	 * 
	 * @param customer - takes in a customer1 object, the id field will be used to
	 *                 update that customer1 in the database
	 * @return
	 */
		public <customer> Customer1 update1(Customer1 customer1) {
	
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE customers SET first_name = ?, surname = ? WHERE id = ?");) {
			statement.setString(1, customer1.getFirstName());
			statement.setString(2, customer1.getSurname());
			statement.setLong(3, (long) customer1.getId());
			statement.executeUpdate();
			return read((Long) customer1.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return customer1;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from customers where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public Customer1 update11(Customer1 customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer1 update(Customer1 customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
	