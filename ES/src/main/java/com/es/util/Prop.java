package com.es.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Prop {

	private static Logger log = Logger.getLogger(Prop.class.getName());

	public static String getConfigValue(String key) throws IOException {
		FileInputStream fis;
		Properties property = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties");
			property = new Properties();
			property.load(fis);
			log.info("config file loaded");
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
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\testData.properties");
			property = new Properties();
			
			property.load(fis);
			log.info("test data file loaded");
		} catch (FileNotFoundException e) {
			log.info("Failed to load testdata file");
		} catch (IOException e) {
			log.info("Faied to open testdata file");
		}
		return property.get(key).toString();
	}

}
