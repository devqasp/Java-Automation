package br.com.selenium.java.automation.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

import br.com.selenium.java.automation.action.config.FileReaderManager;
import br.com.selenium.java.automation.driver.factory.DriverClass;

public class UsefulFunctions extends DriverClass {

	private static long timeOutInSeconds;

	public static void setTimeOutInSeconds(long timeOutInSeconds) {
		UsefulFunctions.timeOutInSeconds = timeOutInSeconds;
	}

	public static long getTimeOutInSeconds() {
		return timeOutInSeconds;
	}

	private static final WebDriver DRIVER;
	private static final WebDriverWait WAIT;

	static {
		DRIVER = getDriver();
		WAIT = new WebDriverWait(DRIVER, getTimeOutInSeconds());
	}

	public static void sendMessageConsole(String file) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = null;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	/*
	 * public static void publishAuthorReportExtentReport(Scenario scenario) { if
	 * (scenario.getName().equals("---"))
	 * Reporter.assignAuthor("Projeto Automação - Niky Palleta"); }
	 */

	public static void publishAuthorReportExtentReport() {
		Reporter.assignAuthor("Projeto Automa&ccedil;&atilde;o&nbsp;-&nbsp;Niky&nbsp;Palleta");
	}

	public static void writeReportExtentReport() {
		publishAuthorReportExtentReport();
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		// Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Nome do Usuário", "Niky Palleta");
		Reporter.setSystemInfo("Fuso Horário", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Máquina", describeMachineData());
		Reporter.setSystemInfo("Selenium-Java", "3.10.0");
		Reporter.setSystemInfo("Maven", "3.5.3");
		Reporter.setSystemInfo("Java", System.getProperty("java.runtime.name"));
		Reporter.setSystemInfo("Versão da VM", System.getProperty("java.vm.version"));
	}

	private static String describeMachineData() {
		String architecture = System.getProperty("os.arch").equals("amd64") ? "64x" : "86x";

		return System.getenv().get("userdomain".toUpperCase()) + " " + System.getProperty("os.name") + " "
		// + System.getProperty("os.version")
		// + " "
				+ architecture;
	}

	@SuppressWarnings("deprecation")
	public static WebElement waitElementPresentWithInteval(long timerSeg, By expression) {
		setTimeOutInSeconds(timerSeg);
		return WAIT.pollingEvery(10, TimeUnit.SECONDS).until(ExpectedConditions.presenceOfElementLocated(expression));
	}

	@SuppressWarnings("deprecation")
	public static WebElement waitElementPresentWithInteval(long timerSeg, WebElement element) {
		setTimeOutInSeconds(timerSeg);
		return WAIT.pollingEvery(10, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement searchElementSetByText(Set<WebElement> elements, String text) {
		WebElement element = null;
		try {
			for (WebElement el : elements) {
				if (el.getText() != null && el.getText().length() > 0) {
					if (el.getText().replaceAll("\\s+", "").equals(text.replaceAll("\\s+", ""))) {
						element = el;
						break;
					}
					break;
				}
			}
		} catch (NoSuchElementException noSuchElementEx) {
			noSuchElementEx.printStackTrace();
			noSuchElementEx.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		return element;
	}

	public static WebElement searchElementSetByTextUsingStream(Set<WebElement> elements, String text) {
		WebElement element = null;
		elements = new HashSet<WebElement>();
		try {
			element = elements.stream()
					.filter((el) -> el.getText().replaceAll("\\s+", "").equals(text.replaceAll("\\s+", ""))).findAny()
					.orElse(null);
		} catch (NoSuchElementException noSuchElementEx) {
			noSuchElementEx.printStackTrace();
			noSuchElementEx.getMessage();
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		return element;
	}

	public static String generateReferenceDate() {
		return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(Calendar.getInstance().getTime());
	}
}