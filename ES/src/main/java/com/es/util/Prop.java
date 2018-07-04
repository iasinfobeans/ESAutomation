package com.es.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Prop {

	private static Logger log = Logger.getLogger(Prop.class.getName());
	private static String configPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "config.properties").toString();
	private static String testDataPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties").toString();

	public static String getConfigValue(String key) throws IOException {
		FileInputStream fis;
		Properties property = null;
		try {
			fis = new FileInputStream(configPropertiesFilePath);
			property = new Properties();
			property.load(fis);
			log.info("Loaded config file");
		} catch (FileNotFoundException e) {
			log.info("Failed to load testdata file");
		} catch (IOException e) {
			log.info("Faied to open testdata file");
		}
		return property.get(key).toString();
	}

	public static String getTestData(String key) {
		FileInputStream fis;
		Properties property = null;
		try {
			fis = new FileInputStream(testDataPropertiesFilePath);
			property = new Properties();
			property.load(fis);
			log.info("Loaded test data file");
		} catch (FileNotFoundException e) {
			log.info("Failed to load testdata file");
		} catch (IOException e) {
			log.info("Faied to open testdata file");
		}
		return property.get(key).toString();
	}

}
