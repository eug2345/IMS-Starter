package com.qa.ims.persistence.dao;

import org.junit.Test;

import com.qa.ims.persistence.domain.Item;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemDaoTest{
	
@Test
public void testEquals() {
	EqualsVerifier.simple().forClass(Item.class).verify();
}

}