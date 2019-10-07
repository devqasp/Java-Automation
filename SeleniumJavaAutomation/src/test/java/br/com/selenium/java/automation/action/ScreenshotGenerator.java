package br.com.selenium.java.automation.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class ScreenshotGenerator {

	public static void generateScreenshot(Scenario scenario, WebDriver driver) {

		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
			EvidencePathGenerator.generateEvidencePath(scenario, arquivo);
		}
	}
}

class EvidencePath {

	private static final String evidencePath = "./relatorio/evidencias/";

	public static String getEvidencePath(Scenario scenario) {
		return evidencePath + scenario.getName();
	}
}

class EvidencePathGenerator {

	static void generateEvidencePath(Scenario scenario, File file) {

		long i = 1;

		try {
			if (Counter.accountFileDirectory(scenario) > 0)
				Counter.setCounter(i += Counter.accountFileDirectory(scenario));
			else
				Counter.setCounter(i);
			FileUtils.copyFile(file, new File(EvidencePath.getEvidencePath(scenario) + "/" + "evidencia_0"
					+ Long.toString(Counter.getCounter()) + "_" + UsefulFunctions.generateReferenceDate() + ".png"));
			System.out.println("Evidence was successfully generated...!");
		} catch (IOException iOException) {
			System.out.println("¡Exception thrown! ¡Failure to generate evidence!" + iOException.getMessage());
		}
	}
}

class Counter {

	private static long counter;

	static long getCounter() {
		return counter;
	}

	static void setCounter(long counter) {
		Counter.counter = counter;
	}

	public static long accountFileDirectory(Scenario scenario) {

		long $iterator = 0;

		try {
			$iterator = Files.list(Paths.get(EvidencePath.getEvidencePath(scenario)))
					.filter(arq -> arq.toFile().isFile()).count();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}

		return $iterator;
	}
}