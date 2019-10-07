package br.com.selenium.java.automation.runner;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.selenium.java.automation.driver.factory.DriverClass;
import br.com.selenium.java.automation.driver.factory.DriverManager;
import br.com.selenium.java.automation.driver.factory.DriverManagerFactory;

public class TestNGTestRunner extends DriverClass {

	DriverManager driverManager;

	@BeforeTest
	public void beforeTest() {
		driverManager = DriverManagerFactory.executeDriverManager("chrome");
		// driverManager = DriverManagerFactory.executeDriverManager("firefox");
	}

	@BeforeMethod
	public void beforeMethod() {
		setDriver(driverManager.getDriver());
		configureURL();
	}

	@AfterMethod
	public void afterMethod() {
		driverManager.quitDriver();
	}

	@Test
	public void firstTest() {
		assertEquals(getDriver().getTitle(), "My Store");
	}
}