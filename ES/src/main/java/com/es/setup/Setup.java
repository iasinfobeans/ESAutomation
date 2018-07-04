package com.es.setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.es.pom.DashboardPage;
import com.es.pom.QuotationRequestFormPage;
import com.es.pom.SignInPage;

public class Setup {
	public static WebDriver driver;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	private static String screenshotPath = System.getProperty("user.dir") + "\\" + "screenshots";
	private static String allureReportPath = System.getProperty("user.dir") + "\\" + "alure-reports";
	private static String logPath = System.getProperty("user.dir") + "\\" + "log";
	
	// public static ExtentTestManager test;

	public static void testSetup() throws IOException {
		driver = Driver.getDriver();
		PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, DashboardPage.class);
		PageFactory.initElements(driver, QuotationRequestFormPage.class);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Driver.getURL());
	}

	public static void testTearDown() {
		driver.close();
		Reporter.log("Closed browser ", true);
	}

	public static String getCurrentTimeForScreenShot() {

		SimpleDateFormat sdf = new SimpleDateFormat("ddMM_hhmmss_aaa(zzz)");
		java.util.Date curDate = new java.util.Date();
		String strDate = sdf.format(curDate);
		String strActDate = strDate.toString();
		return strActDate;
	}

	public static String CaptureScreenshot(String testName) throws IOException {

		String filePath = null;
		try {
			File scrFile = null;
			log.info("Driver>>>>>> " + driver.toString());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String scrFileName = testName + " AT-" + "-" + getCurrentTimeForScreenShot() + ".png";

			File directory = new File(screenshotPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
			filePath = directory + "\\" + scrFileName;
			FileUtils.copyFile(scrFile, new File(filePath));
			log.info(": => Please refer " + filePath);
			log.debug(": => For Verification, Please refer " + scrFileName);
		} catch (Exception e) {
			// Setup.test.log(Status.FAIL, "Failed to take screenshot : " + e.getMessage());
			log.info("Failed to take screenshot : " + e.getMessage());
			e.printStackTrace();
		}
		return filePath;
	}

	@BeforeSuite(alwaysRun = true)
	public void setup() throws Exception {
		// Clean or create screenshot directory
		try {
			log.info("in before suite");
			FileUtils.cleanDirectory(new File(screenshotPath));
			log.info("Cleaned Screenshots directory");
		} catch (java.lang.IllegalArgumentException e) {
			log.info(screenshotPath + "  directory is not exist, created it");
			File directory = new File(screenshotPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
		}

		// Clean or create allure report directory
		try {
			FileUtils.cleanDirectory(new File(allureReportPath));
			log.info("Cleaned Extent Report directory");
		} catch (java.lang.IllegalArgumentException e) {
			log.info(allureReportPath + "  directory is not exist, created it");
			File directory = new File(allureReportPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
		}

		// Clean or create log directory
		try {
			FileUtils.cleanDirectory(new File(logPath));
			log.info("Cleaned Log directory");
		} catch (java.lang.IllegalArgumentException e) {
			log.info(logPath + "  directory is not exist, created it");
			File directory = new File(logPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
		}

	}
}