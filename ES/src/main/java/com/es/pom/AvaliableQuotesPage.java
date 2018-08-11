package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AvaliableQuotesPage {

	private static Logger log = Logger.getLogger(AvaliableQuotesPage.class.getName());

	@FindBy(xpath = "//*[@programslug='esr']")
	static WebElement applyButton;

	@Step(" Click on the Apply button ...")
	public static void applyForViewQuotesOptions() {
		applyButton.click();
		log.info("Verify Customer is able to Click on Apply button ");

	}
}
