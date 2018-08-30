package com.es.pom;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;

public class AdminPage {
	private static Logger log = Logger.getLogger(AdminPage.class.getName());

	@FindBy(xpath = "//*[text()='Portal Jobs']")
	static WebElement portalJobs;
	
	@FindBy(xpath = "//*[text()='Quote Expiry Notification']/following-sibling::td/following-sibling::td")
	static WebElement runJobs;
	
	/**
	 * This method will Run Quote Expiry Notification job to send Quote Expiry notification to customer.
	 */
	@Step("Running Quote Expiry Notification job")
	public static void runQuoteExpiryJob() {
		Assert.assertTrue(portalJobs.isDisplayed());
		portalJobs.click();
		runJobs.click();
		try {
			TimeUnit.MINUTES.sleep(2);
		} catch (InterruptedException e) {
			log.error(e);
			e.printStackTrace();
		}
		Assert.assertTrue(portalJobs.isDisplayed());
		log.info("Run Quote Expiry Notification Job.");
	}
	
}
