package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class OverlayPage {

	private static Logger log = Logger.getLogger(OverlayPage.class.getName());

	@FindBy(xpath = "//div[contains(@class,'enjoyhint_skip_btn') and text()='Skip']")
	static WebElement skipButtonMessage;

	@Step("Overlay Page is dispayed whwn User Completed Registration...")
	public static void skipoverlayPage()

	{
		try {
			SeleniumUtils.waitForElementToBeVisible(skipButtonMessage);
			log.info("Overlay Page is displayed");
			skipButtonMessage.click();
			log.info("Skip button is clicked");
			try {
				Thread.sleep(5000);
				SeleniumUtils.waitForElementToBeInvisible(DashboardPage.loadingIcon);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchElementException e) {
			log.info("Overlay Page is not displayed");
		}
	}
}