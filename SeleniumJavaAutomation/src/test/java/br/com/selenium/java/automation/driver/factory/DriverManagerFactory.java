package br.com.selenium.java.automation.driver.factory;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.selenium.java.automation.browser.factory.ChromeDriverManager;
import br.com.selenium.java.automation.browser.factory.FirefoxDriverManager;
import br.com.selenium.java.automation.browser.factory.InternetExplorerDriverManager;

public class DriverManagerFactory {

	static DriverManager driverManager;

	public static DriverManager executeDriverManager(String driverName) {
		//
		if (driverName.equalsIgnoreCase("ie"))
			driverManager = new InternetExplorerDriverManager();
		else if (driverName.equalsIgnoreCase("firefox"))
			driverManager = new FirefoxDriverManager();
		else if (driverName.equalsIgnoreCase("chrome"))
			driverManager = new ChromeDriverManager();
		else
			JOptionPane.showMessageDialog(new JFrame(),
					"Driver name: " + "' " + driverName + " '" + " is wrong or does not exist!", "# ERROR! #",
					JOptionPane.ERROR_MESSAGE);
		return driverManager;
	}
}