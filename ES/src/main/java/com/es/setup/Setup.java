package com.es.setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.es.pom.DashboardPage;
import com.es.pom.QuotationRequestFormPage;
import com.es.pom.SignInPage;
import com.es.util.CommonUtils;

public class Setup {
	public static WebDriver driver;
	public static int i=1;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	public static String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots";
	private static String allureReportPath = System.getProperty("user.dir") + File.separator + "alure-reports";
	private static String logPath = System.getProperty("user.dir") + File.separator + "log";
	public static Properties testData = null;
	public static Properties config = null;

	@BeforeSuite(alwaysRun = true)
	public void setup() throws Exception {
		// Clean or create screenshot directory
		try {
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

	@BeforeMethod(alwaysRun = true)
	public static void testSetup() throws IOException {
		log.info("\n");
		log.info("**********************************************");
		log.info("Executing Test Case Number: "+i++);
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(CommonUtils.getURL());
		//Initilize PageFactory classes
		log.info("Initilize PageFactory classes");
		PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, DashboardPage.class);
		PageFactory.initElements(driver, QuotationRequestFormPage.class);
	}

	@AfterMethod(alwaysRun = true)
	public static void testTearDown() {
		driver.close();
		log.info("Closed browser");
	}


}