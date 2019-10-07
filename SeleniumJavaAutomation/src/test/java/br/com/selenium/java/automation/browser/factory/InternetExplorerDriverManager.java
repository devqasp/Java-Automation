package br.com.selenium.java.automation.browser.factory;

import java.io.File;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.selenium.java.automation.driver.factory.DriverManager;

public class InternetExplorerDriverManager extends DriverManager {

	private InternetExplorerDriverService servicoIExplorer;

	@Override
	protected void startService() {
		if (servicoIExplorer == null) {
			try {
				servicoIExplorer = new InternetExplorerDriverService.Builder()
						.usingDriverExecutable(new File("./resources/drivers/iedriver_(86x).exe").getAbsoluteFile())
						.usingAnyFreePort().build();
				servicoIExplorer.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void stopService() {
		if (servicoIExplorer != null && servicoIExplorer.isRunning()) {
			servicoIExplorer.stop();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		// capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(servicoIExplorer, capabilities);
		driver.manage().window().maximize();
	}
}