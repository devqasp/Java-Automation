package br.com.selenium.java.automation.browser.factory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.selenium.java.automation.driver.factory.DriverManager;

public class FirefoxDriverManager extends DriverManager {

	private GeckoDriverService servicoFirefox;

	@Override
	protected void startService() {
		if (servicoFirefox == null) {
			try {
				servicoFirefox = new GeckoDriverService.Builder()
					 // .usingDriverExecutable(new File("./resources/drivers/geckodriver.exe").getAbsoluteFile())
						.usingDriverExecutable(new File("resources/drivers-for-linux/geckodriver").getAbsoluteFile())
						.usingAnyFreePort().build();
				servicoFirefox.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void stopService() {
		if (servicoFirefox != null && servicoFirefox.isRunning()) {
			servicoFirefox.stop();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(servicoFirefox, capabilities);
		driver.manage().window().maximize();
	}
}