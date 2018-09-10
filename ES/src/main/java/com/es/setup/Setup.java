package com.es.setup;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.es.pom.AdminPage;
import com.es.pom.ApplicationPage;
import com.es.pom.ApplicationPageForQuotation;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.AvaliableQuotesPage;
import com.es.pom.CRMPage;
import com.es.pom.CardDetailsPage;
import com.es.pom.ChangePasswordPage;
import com.es.pom.DashboardPage;
import com.es.pom.DependsOn;
import com.es.pom.ForgotPasswordPage;
import com.es.pom.GetAQuotePage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.OverlayPage;
import com.es.pom.QuotationListingPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.PaymentHistoryPage;
import com.es.pom.PaymentPage;
import com.es.pom.RegisterPage;
import com.es.pom.ReportsPage;
import com.es.pom.ResetPasswordPage;
import com.es.pom.SOWFeaturePage;
import com.es.pom.SignInPage;
import com.es.pom.UpdateProfilePage;
import com.es.pom.UserListingsPage;
import com.es.pom.YopmailPage;
import com.es.util.CommonUtils;
import com.es.util.Prop;
import com.es.util.Yopmail;
import com.es.pom.ProjectListingPage;

public class Setup {
	public static WebDriver driver;
	public static int i = 1;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	public static String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots";
	private static String allureReportPath = System.getProperty("user.dir") + File.separator + "alure-reports";
	private static String logPath = System.getProperty("user.dir") + File.separator + "log";
	public static Properties testData = null;
	public static Properties config = null;
	private static String configPropertiesFilePath = Paths
			.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "config.properties")
			.toString();
	public static String testDataPropertiesFilePath = Paths
			.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties")
			.toString();

	@BeforeSuite(alwaysRun = true)
	public void testBedSetup() throws Exception {

		// Create or clean screenshot directory
		CommonUtils.cleanOrCreateDirectory(screenshotPath);

		// Create or clean allure report directory
		CommonUtils.cleanOrCreateDirectory(allureReportPath);

		// Create or clean log directory
		//	CommonUtils.cleanOrCreateDirectory(logPath);

		// load properties files
		config = Prop.loadPropertiesFile(configPropertiesFilePath);
		testData = Prop.loadPropertiesFile(testDataPropertiesFilePath);
	}

	@AfterSuite(alwaysRun = true)
	public void testBedTearDown() throws Exception {
		try {
			driver.quit();
			log.info("Closed browser");
		} catch (Exception e) {
			log.info("Browser is already closed by test method");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public static void testSetup(Method method) throws IOException {
		log.info("\n");
		log.info("**********************************************");
		log.info("Executing Test Case Number: " + i++);
		Annotation[] annotationArray = method.getAnnotations();		
		if(annotationArray[0].toString().contains("dependsOnMethods=[]")) {
			driver = Driver.getDriver();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(CommonUtils.getURL());

			// Initialize PageFactory classes
			PageFactory.initElements(driver, SignInPage.class);
			PageFactory.initElements(driver, DashboardPage.class);
			PageFactory.initElements(driver, ForgotPasswordPage.class);
			PageFactory.initElements(driver, YopmailPage.class);
			PageFactory.initElements(driver, ApplicationsListingPage.class);
			PageFactory.initElements(driver, RegisterPage.class);
			PageFactory.initElements(driver, OverlayPage.class);
			PageFactory.initElements(driver, ChangePasswordPage.class);
			PageFactory.initElements(driver, Yopmail.class);
			PageFactory.initElements(driver, UpdateProfilePage.class);
			PageFactory.initElements(driver, ResetPasswordPage.class);
			PageFactory.initElements(driver, ApplicationPage.class);
			PageFactory.initElements(driver, QuotationListingPage.class);
			PageFactory.initElements(driver, GetAQuotePage.class);
			PageFactory.initElements(driver, ReportsPage.class);
			PageFactory.initElements(driver, AvaliableQuotesPage.class);
			PageFactory.initElements(driver, ApplicationPageForQuotation.class);
			PageFactory.initElements(driver, GetAQuotePage.class);
			PageFactory.initElements(driver, CRMPage.class);
			PageFactory.initElements(driver, UserListingsPage.class);
			PageFactory.initElements(driver, PMGApplicationFormPage.class);
			PageFactory.initElements(driver, PaymentPage.class);
			PageFactory.initElements(driver, ProjectListingPage.class);
			PageFactory.initElements(driver, InvoiceListingPage.class);
			PageFactory.initElements(driver, CardDetailsPage.class);
			PageFactory.initElements(driver, PaymentHistoryPage.class);
			PageFactory.initElements(driver, PaymentHistoryPage.class);
			PageFactory.initElements(driver, SOWFeaturePage.class);
			PageFactory.initElements(driver, AdminPage.class);
			PageFactory.initElements(driver, DependsOn.class);
			
		}
	}

	
	@AfterMethod(alwaysRun = true)
	public static void testTearDown(Method method) {
		Annotation[] annotationArray = method.getAnnotations();		
		if(annotationArray[0].toString().contains("dependsOnMethods=[]")) {
			driver.quit();
			log.info("Closed browser");
		}
	}

}