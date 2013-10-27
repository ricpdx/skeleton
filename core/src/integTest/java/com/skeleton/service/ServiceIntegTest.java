package com.skeleton.service;

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
		logger.info("ServiceIntegTest - FakeTest begin");

		logger.info("read and parse json file.");
		Path path = Paths.get("core/build/resources/integrationTest/abc.json");
		assertNotNull(path);
		String dataString = readJsonFileToString(path);
		assertNotNull(dataString);

		logger.info("ServiceIntegTest - FakeTest end");
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
