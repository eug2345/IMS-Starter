package com.qa.ims.persistence.dao;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerDAOTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	}
