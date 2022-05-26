package com.qa.ims.persistence.dao;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderDaoTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderDao.class).verify();
	}

}

