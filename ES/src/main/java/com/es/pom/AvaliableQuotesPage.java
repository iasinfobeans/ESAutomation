package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class AvaliableQuotesPage {

	private static Logger log = Logger.getLogger(AvaliableQuotesPage.class.getName());

	@FindBy(xpath = "//*[@class='sbHolder']//a[contains(text(),'All Status')]")
	static WebElement statusAvailableQuotes;

	@FindBy(xpath = "//a[contains(text(),'Apply')]")
	static WebElement applyButton;

	@FindBy(xpath = "//*[@class='sbHolder']//a[contains(text(),'Applied')]")
	static WebElement appliedQuotes;

	@FindBy(xpath = "//strong[contains(text(),'Applied')]")
	static WebElement appliedQuoteStatus;

    @FindBy(xpath ="//*[@id='view-quotes-dataTable']//a[@class='tbl-btn'][contains(text(),'View')]")
	static WebElement view;
	
	@FindBy(xpath="//div[@id='app-list-dataTable_processing']")
	static WebElement processingTableElement;
	
	

	/**
	 * This method will verify customer Click on the Apply button .
	 * @return void
	 * @param void
	 */
	@Step("Click on the Apply button")
	public static void applyForViewQuotesOptions() {
		Assert.assertTrue(applyButton.isDisplayed());
		SeleniumUtils.waitForElementToBeVisible(applyButton);
		SeleniumUtils.executeJavaScript("arguments[0].click();",applyButton);
		log.info("Verify Customer is able to Click on Apply button ");

	}

	/**
	 * This method will verify quote should not be allowed to be used for submitting another application.
	 * @return void
	 * @param void
	 */
	@Step("Verify quote not allowed to be used to submitt another application")
	public static void verifyAppliedQuote() {
		Assert.assertTrue(appliedQuoteStatus.isDisplayed());
		Assert.assertTrue(view.isDisplayed());
		log.info("Verify Customer is able to view on Applied Quote but cannot apply again.");

	}

	/**
	 * This method will verify customer Click on the view button .
	 * @return void
	 * @param void
	 */
	@Step("Click on the view button")
	public static void viewQuotesForExpiredQuote() {
		SeleniumUtils.waitForElementToBeVisible(view);
		//SeleniumUtils.waitForElementToBeClickable(view);
		Assert.assertTrue(view.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();",view);
	    log.info("Verify Customer is able to Click on view button ");

	}

}
