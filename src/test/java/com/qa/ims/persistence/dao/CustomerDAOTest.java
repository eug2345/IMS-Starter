package com.qa.ims.persistence.dao;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerDAOTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(CustomerDAO.class).verify();
	}

	}
