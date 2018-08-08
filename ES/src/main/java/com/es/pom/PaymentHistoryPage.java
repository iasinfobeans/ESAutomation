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

	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static WebElement paymentSuccessMessege;

	@FindBy(xpath="//span[@class='pull-right']/parent::div/preceding-sibling::div//label[text()='Order ID:']/../following-sibling::div/span")
	static WebElement newApplication;

	@Step("Verify that the payment was successful.")
	public static void verifyPaymentSucess(){
		if(paymentSuccessMessege.getText().equals(Prop.getTestData("paymentSuccessMessage"))){
			log.info("Payment was successful");
		}
	}

	@Step("A new application should be created on the portal of the same program type....")
	public static void verifyNewApplicationCreated()
	{
		SeleniumUtils.waitForElementToBeClickable(newApplication);
		Assert.assertTrue(newApplication.isDisplayed());
		log.info("New Application is displayed");
	}
}
