package com.skeleton.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ServiceIntegTest {
	Logger logger;

	@BeforeClass
	public void oneTimeSetup() {
		logger = LoggerFactory.getLogger(ServiceIntegTest.class);
		logger.info("ServiceIntegTest - oneTimeSetup");
	}

	@AfterClass
	public void oneTimeTeardown() {
		logger.info("ServiceIntegTest - oneTimeTeardown");
		logger = null;
	}

	@Test
	public void FakeTest() {
		assertEquals(1, 2);
		assertEquals(true, false);
		Object x = null;
		assertNotNull(x);
		logger.info("ServiceIntegTest - running FakeTest");
	}
}
