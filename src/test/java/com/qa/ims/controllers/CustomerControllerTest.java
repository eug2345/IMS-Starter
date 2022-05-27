package com.qa.ims.controllers;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer1;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerControllerTest{

@Test
public void testEquals() {
	
	EqualsVerifier.forClass(Customer1.class).verify(); 
	
}

}