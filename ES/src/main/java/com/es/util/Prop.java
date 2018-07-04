package com.es.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.es.setup.Setup;

public class Prop {

	private static Logger log = Logger.getLogger(Prop.class.getName());
	private static String configPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "config.properties").toString();
	private static String testDataPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties").toString();

	public static Properties loadPropertiesFile(String filePath) throws IOException {
		FileInputStream fis;
		Properties property = null;
		try {
			fis = new FileInputStream(filePath);
			property = new Properties();
			property.load(fis);
			log.info("Loaded "+filePath+" file");
		} catch (FileNotFoundException e) {
			log.info("Failed to load "+filePath+" file");
		} catch (IOException e) {
			log.info("Faied to open "+filePath+" file");
		}
		return property;
	}
	
	public static String getConfigValue(String key) throws IOException {
		String value = Setup.config.getProperty(key);
		return value;
	}
	
	public static String getTestData(String key) {
		String value = Setup.testData.getProperty(key);
		return value;
	}

}
