package com.es.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.es.setup.Driver;
import com.es.setup.Setup;

public class CommonUtils {

	private static Logger log = Logger.getLogger(CommonUtils.class.getName());

	public static String getURL() throws IOException {
		String url = null;
		if (System.getProperty("Env").equalsIgnoreCase("qa")) {
			url = Prop.getTestData("applicationURL-QA").toString();
		} else if (System.getProperty("Env").equalsIgnoreCase("uat")) {
			url = Prop.getTestData("applicationURL-UAT").toString();
		} else {
			url = Prop.getTestData("applicationURL-PROD").toString();
		}
		return url;
	}

	public static String getChromeDriverPath(){
		Path chromeDriverPath;
		if(System.getProperty("os.name").startsWith("Mac")){
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver", "chromedriver");
		}else{
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver", "chromedriver.exe");
		}
		return chromeDriverPath.toString();
	}


	public static String CaptureScreenshot(String testName) throws IOException {
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

	public static String getCurrentTimeForScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_hh-mm-ss_aaa(zzz)");
		java.util.Date curDate = new java.util.Date();
		String strDate = sdf.format(curDate);
		String strActDate = strDate.toString();
		return strActDate;
	}
}
