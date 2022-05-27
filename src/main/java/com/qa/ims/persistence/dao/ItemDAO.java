package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.controller.CrudController;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public abstract class ItemDAO implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private static final Item order = null;

	private Utils utils;

	public ItemDAO(@SuppressWarnings("rawtypes") CustomerDAO itemDAO, Utils utils) {
		super();
		this.utils = utils;
	}


	/**
	 * Reads all customers to the logger
	 * @param orders 
	 */
	
	public List<Order> readAll(List<Order> orders) {
			for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */

	public Item create() {
		LOGGER.info("Please enter your Item ID");
		Long itemrID = utils.getLong();
		Item newItem = Item.create(new Item(itemrID, null));
		System.out.println(newItem);
		LOGGER.info("Order initialised");
		
		return newItem;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
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
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from Item where id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}
