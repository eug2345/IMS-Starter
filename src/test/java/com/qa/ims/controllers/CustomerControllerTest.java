package com.qa.ims.controllers;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
public class CustomerControllerTest{

@Test
public void testEquals() {
	EqualsVerifier.simple().forClass(CustomerControllerTest.class).verify();
}

}
