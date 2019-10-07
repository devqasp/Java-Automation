package br.com.selenium.java.automation.runner;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.selenium.java.automation.driver.factory.DriverClass;
import br.com.selenium.java.automation.driver.factory.DriverManager;
import br.com.selenium.java.automation.driver.factory.DriverManagerFactory;

public class JUnitTestRunner extends DriverClass {

	DriverManager driverManager;

	@Before
	public void before() {
		// driverManager = DriverManagerFactory.executeDriverManager("chrome");
		// driverManager = DriverManagerFactory.executeDriverManager("firefox");
		driverManager = DriverManagerFactory.executeDriverManager("ie");
		setDriver(driverManager.getDriver());
		configureURL();
	}

	@After
	public void after() {
		driverManager.quitDriver();
	}

	@Test
	public void firstTest() {
		assertEquals("My Store", getDriver().getTitle());
	}
}