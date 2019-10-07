package br.com.selenium.java.automation.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.selenium.java.automation.action.UsefulFunctions;
import br.com.selenium.java.automation.driver.factory.DriverClass;
import br.com.selenium.java.automation.driver.factory.DriverManager;
import br.com.selenium.java.automation.driver.factory.DriverManagerFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.events.PickleEvent;

@SuppressWarnings("deprecation")
@CucumberOptions
			(
				strict		= false,
				features	= "./specification/features", 
				glue		= { "br.com.automacao.selenium.steps.definition" }, 
				plugin		= { "pretty",
								"json:target/cucumber-reports/Cucumber.json",
								"junit:target/cucumber-reports/Cucumber.xml",
								"html:target/cucumber-reports",
								"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
							  },
				tags		= { "~@ignore" },
				monochrome	= true,
				dryRun		= false
			)

public class CucumberTestRunner extends DriverClass {

	private TestNGCucumberRunner testNGCucumberRunner;

	public CucumberTestRunner() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	static DriverManager driverManager;
	
	@BeforeClass(alwaysRun = true)
	public static void beforeClass() {
		// driverManager = DriverManagerFactory.executeDriverManager("chrome");
		// driverManager = DriverManagerFactory.executeDriverManager("firefox");
		driverManager = DriverManagerFactory.executeDriverManager("ie");
		setDriver(driverManager.getDriver());
		configureURL();
		// UsefulFunctions.publishAuthorReportExtentReport();
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature, PickleEvent pickleEvent) {
		try {
			testNGCucumberRunner.runScenario(pickleEvent);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return (Object[][]) new Object();
	}

	@AfterClass(alwaysRun = true)
	public static void afterClass() {
		UsefulFunctions.writeReportExtentReport();
		driverManager.quitDriver();
	}
}