package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public abstract class ItemController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO<?> customerController;
	private Utils utils;

	public ItemController(@SuppressWarnings("rawtypes") CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerController = customerDAO;
		this.utils = utils;
	}

	public ItemController(Customer custDAO, Utils utils2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerController.readAll(); 
		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String firstName = utils.getString();
		LOGGER.info("Please enter a surname");
		String surname = utils.getString();
		Dao<Customer> customerController = null;
		@SuppressWarnings("null")
		Customer customer = customerController.create(new Customer(0, firstName, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		utils.getLong();
		LOGGER.info("Please enter a first name");
		utils.getString();
		LOGGER.info("Please enter a surname");
		utils.getString();
		Item customer = new Item(null, 0);
		LOGGER.info("Customer Updated");
		
		return customer;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
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
}
