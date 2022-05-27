package com.qa.ims.utils;

import org.apache.logging.log4j.LogManager;

public class Runner {

	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		new Utils();
		Utils.imsSystem();
		LOGGER.info("SO LONG!");
	}}