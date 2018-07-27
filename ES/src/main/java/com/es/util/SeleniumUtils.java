package com.es.util;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		log.info("Navigated to " + url);
	}

	public static void switchToIframeByName(String name) {
		Setup.driver.switchTo().frame(name);
		log.info("Switched to " + name + " iframe");
	}

	public static void switchToIframeById(String id) {
		Setup.driver.switchTo().frame(id);
		log.info("Switched to " + id + " iframe");
	}

	public static void switchToIframeByIndex(int i) {
		Setup.driver.switchTo().frame(i);
		log.info("Switched to " + i + " iframe");
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

	public static void waitForElementToBeClickable(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String getCurrentUrl() {
		String currentUrl = Setup.driver.getCurrentUrl();
		return currentUrl;
	}

	public static Set<String> openUrlInNewWindow(String url) {
		((JavascriptExecutor) Setup.driver).executeScript("window.open(arguments[0])", url);
		Set<String> windowHandles = Setup.driver.getWindowHandles();
		return windowHandles;
	}

	public static void switchToWindow(String handle) {
		Setup.driver.switchTo().window(handle);
	}

	public static void switchToWindowAndClose(String handle) {
		Setup.driver.switchTo().window(handle).close();
	}

	public static void scrollToBottom() {
		((JavascriptExecutor) Setup.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void refreshPage() {
		Setup.driver.navigate().refresh();
	}
	
	public static void acceptPopup() {
		Setup.driver.switchTo().alert().accept();
	}
	
	public static void dismissPopup() {
		Setup.driver.switchTo().alert().dismiss();
	}
	
	public static void executeJavaScript(String javaScript, WebElement webElement) {
		SeleniumUtils.waitForElementToBeVisible(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Setup.driver;
		javascriptExecutor.executeScript(javaScript, webElement);
	}
	
	public static void mouseHover(WebElement webElement) {
		SeleniumUtils.waitForElementToBeVisible(webElement);
		Actions actionBuilder = new Actions(Setup.driver);
		actionBuilder.moveToElement(webElement).build().perform();	
	}

}
