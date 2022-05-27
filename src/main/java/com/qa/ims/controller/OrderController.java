package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public abstract class OrderController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private static final Item order = null;

	private Utils utils;

	public OrderController(@SuppressWarnings("rawtypes") CustomerDAO customerDAO, Utils utils) {
		super();
		this.utils = utils;
	}


	/**
	 * Reads all customers to the logger
	 * @param orders 
	 */
	

public List<Order> readAll(List<Order> orders) 
			for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */

	public Order create() {
		LOGGER.info("Please enter your customer ID");
		Long customerID = utils.getLong();
		Order newOrder = OrderDao.create(new OrderDao(customerID, null));
		System.out.println(newOrder);
		LOGGER.info("Order initialised");
		
		return newOrder;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		utils.getLong();
		LOGGER.info("Please enter id of the item you would like to update");
		utils.getLong();
		LOGGER.info("Please enter item name");
		LOGGER.info("Order Updated");
		
		return order;
	}


	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
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
