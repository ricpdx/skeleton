package com.skeleton.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ServiceUnitTest {
	Logger logger;

	@BeforeClass
	public void oneTimeSetup() {
		logger = LoggerFactory.getLogger(ServiceUnitTest.class);
		logger.info("ServiceUnitTest - oneTimeSetup");
	}

	@AfterClass
	public void oneTimeTeardown() {
		logger.info("ServiceUnitTest - oneTimeTeardown");
		logger = null;
	}

	@Test
	public void FakeTest() {
		assertEquals(1, 1);
		logger.info("ServiceUnitTest - running FakeTest");
	}
}
