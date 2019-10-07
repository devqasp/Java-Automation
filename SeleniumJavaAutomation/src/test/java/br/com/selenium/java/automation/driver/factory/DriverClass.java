package br.com.selenium.java.automation.driver.factory;

import org.openqa.selenium.WebDriver;

public class DriverClass {

	public static final String URL = "http://automationpractice.com/index.php";

	private static WebDriver driver;

	protected static void setDriver(WebDriver driver) {
		DriverClass.driver = driver;
	}

	protected static WebDriver getDriver() {
		return driver;
	}

	protected static void configureURL() {
		getDriver().get(URL);
	}
}