package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class GetAQuotePage {

	private static Logger log = Logger.getLogger(GetAQuotePage.class.getName());

	@FindBy(xpath="//textarea[@class='producttype-textarea requiredField']")
	static WebElement productTypeBox;

	@FindBy(xpath="//textarea[@class='productdec-textarea requiredField']")
	static WebElement productDescriptionBox;

	@FindBy(id="quote_submit")
	static WebElement submitButton;

	@Step("Verify The Get a Quote screen to have the following fields:ProductType,Description and submit...")
	public static void verifyGetAQuoteButton(){
		SeleniumUtils.waitForElementToBeVisible(productTypeBox);

		Assert.assertTrue(productTypeBox.isDisplayed());
		log.info("Product Type is displayed");

		Assert.assertTrue(productDescriptionBox.isDisplayed());
		log.info("Product Description is displayed");

		Assert.assertTrue(submitButton.isDisplayed());
		log.info("Submit Button is displayed");

	}	

	@Step("Verify that the customer is able to request for a quote")
	public static void verifyCustomerRequestforQuote(String productType,String productDescription) {
		SeleniumUtils.waitForElementToBeVisible(productTypeBox);

		productTypeBox.clear();
		productTypeBox.sendKeys(productType);
		log.info("Product Type is displayed");

		productDescriptionBox.clear();
		productDescriptionBox.sendKeys(productDescription);
		log.info("Product Description is displayed");

		submitButton.click();
		log.info("Submit Button is displayed");
	}
}
