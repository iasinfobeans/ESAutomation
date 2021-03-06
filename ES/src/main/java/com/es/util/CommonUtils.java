package com.es.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class CommonUtils {

	private static Logger log = Logger.getLogger(CommonUtils.class.getName());

	/**
	 * @description This method returns application url based on execution
	 *              environment.
	 * @return String
	 * @param void
	 */
	public static String getURL() throws IOException {
		String url = null;
		if (System.getProperty("Env").equalsIgnoreCase("qa")) {
			url = Prop.getConfigValue("applicationURL-QA").toString();
		} else if (System.getProperty("Env").equalsIgnoreCase("uat")) {
			url = Prop.getConfigValue("applicationURL-UAT").toString();
		} else {
			url = Prop.getConfigValue("applicationURL-PROD").toString();
		}
		return url;
	}

	/**
	 * @description This method returns Chrome driver path based on execution
	 *              operating system.
	 * @return String
	 * @param void
	 */
	public static String getChromeDriverPath() {
		Path chromeDriverPath;
		if (System.getProperty("os.name").startsWith("Mac")) {
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver",
					"chromedriver");
		} else {
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver",
					"chromedriver.exe");
		}
		return chromeDriverPath.toString();
	}

	/**
	 * @description This method returns current time in
	 *              dd_MMM_yyyy_hh-mm-ss_aaa(zzz) format.
	 * @return String
	 * @param void
	 */
	public static String getCurrentTimeForScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_hh-mm-ss_aaa(zzz)");
		java.util.Date curDate = new java.util.Date();
		String strDate = sdf.format(curDate);
		String strActDate = strDate.toString();
		return strActDate;
	}

	/**
	 * This method deletes all the files of a directory or create a directory if it
	 * doesn't exist.
	 * 
	 * @return void
	 * @param directoy
	 *            Path
	 */
	public static void cleanOrCreateDirectory(String dirPath) {
		try {
			FileUtils.cleanDirectory(new File(dirPath));
			log.info("empty " + dirPath + " directory");
		} catch (java.lang.IllegalArgumentException e) {
			log.info(dirPath + "  directory is not exist, created it");
			File directory = new File(dirPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
		} catch (IOException e) {
			log.info("invalid path: " + dirPath);
			e.printStackTrace();
		}
	}

	/**
	 * This method generate random yopmail id i.e.
	 * TestESApp.yyyyMMdd-HHmmss@yopmail.com
	 * 
	 * @return String
	 * @param void
	 */
	public static String getRandomYopMailId() {
		return "TestESApp." + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + "@yopmail.com";
	}

	/**
	 * This method will return current date.
	 * 
	 * @return current date
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	}

	/**
	 * This method will return date with added thirty days to current date..
	 * @return current date
	 * 
	 */
	public static String getDateAddedThirtyDaysToCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = formatter.format(date);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		// Date after adding the days to the current date
		String newDate = formatter.format(cal.getTime());
		return newDate;
	}
}
