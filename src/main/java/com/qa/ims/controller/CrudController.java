package com.qa.ims.controller;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

/**
 * Create, Read, Update and Delete controller. Takes in inputs for each action
 * to be sent to a service class
 */
public interface CrudController<T> {

	<item> List<Customer> readAll();

	Customer create();

	Item update();

	int delete();

}
