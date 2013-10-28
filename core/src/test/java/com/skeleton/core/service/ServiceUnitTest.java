package com.skeleton.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
		logger.info("ServiceUnitTest - running FakeTest");

		Path path = Paths.get("core/build/resources/test/test.json");
		assertNotNull(path);
		String dataString = readJsonFileToString(path);
		assertNotNull(dataString);
	}

	public static String readJsonFileToString(Path path) {
		try {
			byte[] bytes = Files.readAllBytes(path);
			String data = new String(bytes);
			return data.replace("\r", "").replace("\t", " ");
		} catch (Throwable e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return null;
		}
	}
}
