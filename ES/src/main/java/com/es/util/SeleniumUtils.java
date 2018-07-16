package com.es.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.es.setup.Setup;

public class SeleniumUtils {

	private static Logger log = Logger.getLogger(SeleniumUtils.class.getName());

	public static String captureScreenshot(String testName) throws IOException {
		String filePath = null;
		try {
			File scrFile = null;
			log.info("Driver>>>>>> " + Setup.driver.toString());
			scrFile = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.FILE);
			String scrFileName = testName + "_" + CommonUtils.getCurrentTimeForScreenShot() + ".png";
			File directory = new File(Setup.screenshotPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
			filePath = directory + File.separator + scrFileName;
			FileUtils.copyFile(scrFile, new File(filePath));
			log.info(": => Please refer " + filePath);
			log.debug(": => For Verification, Please refer " + scrFileName);
		} catch (Exception e) {
			log.info("Failed to take screenshot : " + e.getMessage());
			e.printStackTrace();
		}
		return filePath;
	}
}
