package com.es.setup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.es.pom.ChangePasswordPage;
import com.es.pom.ApplicationPage;

import com.es.pom.DashboardPage;
import com.es.pom.ForgotPasswordPage;
import com.es.pom.OverlayPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.pom.YopmailPage;
import com.es.util.CommonUtils;
import com.es.util.Prop;

public class Setup {
	public static WebDriver driver;
	public static int i=1;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	public static String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots";
	private static String allureReportPath = System.getProperty("user.dir") + File.separator + "alure-reports";
	private static String logPath = System.getProperty("user.dir") + File.separator + "log";
	public static Properties testData = null;
	public static Properties config = null;
	private static String configPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "config.properties").toString();
	private static String testDataPropertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties").toString();


	@BeforeSuite(alwaysRun = true)
	public void testBedSetup() throws Exception {
		
		// Create or clean screenshot directory
		CommonUtils.cleanOrCreateDirectory(screenshotPath);

		// Create or clean allure report directory
		CommonUtils.cleanOrCreateDirectory(allureReportPath);

		// Create or clean log directory
		CommonUtils.cleanOrCreateDirectory(logPath);
		
		// load properties files
		config = Prop.loadPropertiesFile(configPropertiesFilePath);
		testData = Prop.loadPropertiesFile(testDataPropertiesFilePath);
	}
	
	@AfterSuite(alwaysRun = true)
	public void testBedTearDown() throws Exception {
		try{
			driver.close();
			log.info("Closed browser");
		}catch(Exception e){
			log.info("Browser is already closed by test method");
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
		
		//Initialize PageFactory classes
		PageFactory.initElements(driver, SignInPage.class);
		PageFactory.initElements(driver, DashboardPage.class);
		PageFactory.initElements(driver, ForgotPasswordPage.class);
		PageFactory.initElements(driver, YopmailPage.class);
		PageFactory.initElements(driver, ApplicationPage.class);
		PageFactory.initElements(driver, RegisterPage.class);
		PageFactory.initElements(driver, OverlayPage.class);
<<<<<<< HEAD
		PageFactory.initElements(driver, ChangePasswordPage.class);
=======
>>>>>>> branch 'master' of https://github.com/iasinfobeans/ESAutomation.git
	}

	@AfterMethod(alwaysRun = true)
	public static void testTearDown() {
		driver.close();
		log.info("Closed browser");
	}


}