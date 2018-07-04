package com.es.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import com.es.util.Prop;

public class Driver {

	public static WebDriver driver;
	public static String url;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	public static WebDriver getDriver() throws IOException {

		switch (System.getProperty("Browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FireFox":
			System.setProperty("webdriver.firefox.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			log.info("Set browser name - chrome or FireFox or IE ");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public static String getURL() throws IOException {

		if (System.getProperty("Env").equalsIgnoreCase("qa")) {
			url = Prop.getTestData("applicationURL-QA").toString();
		} else if (System.getProperty("Env").equalsIgnoreCase("uat")) {
			url = Prop.getTestData("applicationURL-UAT").toString();
		} else {
			url = Prop.getTestData("applicationURL-PROD").toString();
		}
		return url;
	}

	@AfterMethod
	public static void tearDown() {
		driver.close();
	}
}
