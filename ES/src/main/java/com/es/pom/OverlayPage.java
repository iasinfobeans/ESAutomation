package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;


public class OverlayPage {

	private static Logger log = Logger.getLogger(OverlayPage.class.getName());

	@FindBy(xpath="//div[contains(@class,'enjoyhint_skip_btn') and text()='Skip']")
	static WebElement skipButtonMessage;

	/**   
	 * @author Shefali.Garg
	 * @description This method would perform login based on account type
	 * @return void
	 * @param driver
	 */
	@Step("Overlay Page is dispayed whwn User Completed Registration...")
	public static void skipoverlayPage()
	{
		skipButtonMessage.click();
		log.info("Overlay Page is displayed");
	}
}