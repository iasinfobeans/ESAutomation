package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class PaymentPage {
	private static Logger log = Logger.getLogger(PaymentPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement paymentElement;

	@Step("verify Payment page Step...")
	public static void verifyPaymentPage()
	{
		Assert.assertTrue(paymentElement.isDisplayed());
		log.info("Payment page is displayed");
	}
}
