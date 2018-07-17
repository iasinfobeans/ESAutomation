package com.es.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.es.setup.Setup;

public class SeleniumUtils {

	private static Logger log = Logger.getLogger(SeleniumUtils.class.getName());

	public static String captureScreenshot(String testName) {
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

	public static void openUrl(String url) {
		Setup.driver.navigate().to(url);
		log.info("Navigated to "+url);
	}

	public static void switchToIframeByName(String name) {
		Setup.driver.switchTo().frame(name);
		log.info("Switched to "+name+" iframe");
	}

	public static void switchToIframeById(String id) {
		Setup.driver.switchTo().frame(id);
		log.info("Switched to "+id+" iframe");
	}

	public static void switchToDefaultIframe() {
		Setup.driver.switchTo().defaultContent();
		log.info("Switched to default iframe");
	}

	public static void waitForElementToBeVisible(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 120);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String getCurrentUrl() {
		String currentUrl =  Setup.driver.getCurrentUrl();	
		return currentUrl;
	}
	
	public static String openUrlInNewWindow(String url) {
		((JavascriptExecutor) Setup.driver).executeScript("window.open(arguments[0])", url);
		Set<String> windowHandles = Setup.driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		String parentWindowHandle = null;
		String newWindowHandle = null;
		while(itr.hasNext()){
			parentWindowHandle = itr.next();
			newWindowHandle = itr.next();
		}
		SeleniumUtils.switchToWindow(newWindowHandle);
		return parentWindowHandle;
	}
	
	public static void switchToWindow(String handle) {
		Setup.driver.switchTo().window(handle);
	}
}
