package com.skeleton.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

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
	public void fakeTest() {
		logger.info("ServiceIntegTest - running fakeTest");

//		Path path = Paths.get("core/build/resources/test/abc.json");
//		assertNotNull(path);
//		String dataString = readJsonFileToString(path);
//		assertNotNull(dataString);

		URL url = null;
		InputStream stream = null;

		url = getClass().getClassLoader().getResource("abc.json");
		assertNotNull(url);
		logger.info(String.format("getClass().getClassLoader().getResource: url=%s",url.toString()));

//		url = getClass().getResource("abc.json");
//		assertNotNull(url);

		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("abc.json");
		assertNotNull(stream);
		logger.info(String.format("Thread.currentThread().getContextClassLoader().getResourceAsStream: url=%s",url.toString()));
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
