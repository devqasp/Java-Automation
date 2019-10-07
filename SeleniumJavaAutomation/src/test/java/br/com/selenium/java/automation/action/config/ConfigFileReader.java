package br.com.selenium.java.automation.action.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String diretorioArquivoPropriedade = "./configs/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(diretorioArquivoPropriedade));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
			throw new RuntimeException("¡Configuration.properties não foi encontrado no " + diretorioArquivoPropriedade + "!");
		}
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException("¡O caminho do Report Config não foi especificado no arquivo Configuration.properties::Key:reportConfigPath!");
	}
}