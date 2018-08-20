package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PaymentHistoryPage {
	private static Logger log = Logger.getLogger(PaymentHistoryPage.class.getName());

	@FindBy(xpath = "//span[@class='message success alert']//ul//li")
	static WebElement paymentSuccessMessege;

	@FindBy(xpath = "//*[@id='paymentListTable_filter']//label//input[@class='form-control input-sm']")
	static WebElement searchTextbox;

	@FindBy(xpath = "//*[contains(text(),'Credit Card')]")
	static WebElement paymentMode;

	@Step("Verify that the payment was successful.")
	public static void verifyPaymentSucess() {
		if (paymentSuccessMessege.getText().equals(Prop.getTestData("paymentSuccessMessage"))) {
			log.info("Payment was successful");
		}
	}

	@Step("A new application should be created on the portal of the same program type....")
	public static void verifyNewApplicationCreated(String orderId) {
		searchTextbox.clear();
		searchTextbox.sendKeys(orderId);
		log.info("Enter the OderId in the Search Box");
		
		SeleniumUtils.waitForElementToBeVisible(paymentMode);
		Assert.assertTrue(paymentMode.isDisplayed());
		log.info("payment Mode for application is displayed");
	}
}
