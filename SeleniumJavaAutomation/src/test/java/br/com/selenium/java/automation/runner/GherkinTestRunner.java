package br.com.selenium.java.automation.runner;

import br.com.selenium.java.automation.action.ScreenshotGenerator;
import br.com.selenium.java.automation.driver.factory.DriverClass;
import br.com.selenium.java.automation.driver.factory.DriverManager;
import br.com.selenium.java.automation.driver.factory.DriverManagerFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GherkinTestRunner extends DriverClass {

	DriverManager driverManager;

	@Before()
	public void before(Scenario scenario) {
		// driverManager = DriverManagerFactory.executeDriverManager("chrome");
		driverManager = DriverManagerFactory.executeDriverManager("firefox");
		// driverManager = DriverManagerFactory.executeDriverManager("ie");
		setDriver(driverManager.getDriver());
		configureURL();
		// UsefulFunctions.publishAuthorReportExtentReport(scenario);
	}

	@After
	public void after(Scenario scenario) {
		ScreenshotGenerator.generateScreenshot(scenario, driverManager.getDriver());
		driverManager.quitDriver();
	}
}