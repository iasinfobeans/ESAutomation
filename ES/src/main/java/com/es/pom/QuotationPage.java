package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.SeleniumUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class QuotationPage {

	private static Logger log = Logger.getLogger(QuotationPage.class.getName());

	@FindBy(xpath="//a[contains(text(),'Get a Quote')]")
	static WebElement getQuoteButton;

	@Step("Verify that a 'Get a Quote' button is present on the Quotation Listing page for the customer...")
	public static void verifyGetAQuoteButton(){
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
	    Assert.assertTrue(getQuoteButton.isDisplayed());
		log.info("Get A QuoteButton is displayed");
	}	

	@Step("Verify that the customer is able to click on the Get a Quote button...")
	public static void customerClickOnGetAQuoteButton() {
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
		getQuoteButton.click();
		log.info("Verify Customer is able to Click onGet a Quote' button");
	}
 }
