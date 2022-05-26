package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;


@SuppressWarnings("unused")
public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

}
