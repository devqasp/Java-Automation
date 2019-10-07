package br.com.selenium.java.automation.browser.factory;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.selenium.java.automation.driver.factory.DriverManager;

public class ChromeDriverManager extends DriverManager {

	private ChromeDriverService chromeService;

	@Override
	protected void startService() {
		if (chromeService == null) {
			try {
				chromeService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("./resources/drivers/chromedriver.exe").getAbsoluteFile())
						.usingAnyFreePort().build();
				chromeService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void stopService() {
		if (chromeService != null && chromeService.isRunning()) {
			chromeService.stop();
		}
	}

	@Override
	protected void createDriver() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", prefs);
		chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.addArguments("--disable-extensions-file-access-check", 
								   "--disable-popup-blocking",
								   "--reduce-security-for-testing",
								   "--start-maximized");
		driver = new ChromeDriver(chromeService, chromeOptions);
	}
}