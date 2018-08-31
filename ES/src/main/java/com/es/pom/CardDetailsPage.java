package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class CardDetailsPage {

	private static Logger log = Logger.getLogger(CardDetailsPage.class.getName());

	@FindBy(id = "name")
	static WebElement cardHolderName;

	@FindBy(id = "card_type")
	static WebElement creditCardType;

	@FindBy(id = "PAN")
	static WebElement creditCardNumberElement;

	@FindBy(xpath = "//select[@name='cresecure_cc_expires_year']")
	static WebElement expirationDate;

	@FindBy(xpath = "//select[@name='cresecure_cc_expires_year']//option[@value='25']")
	static WebElement expirationYear;

	@FindBy(id = "cv_data")
	static WebElement cVCNumberElement;
	
	@FindBy(xpath = "//span[@class='pull-right']/parent::div/preceding-sibling::div//label[text()='Order ID:']")
	static WebElement oderId;

	@FindBy(xpath = "//span[@class='pull-right']/parent::div/preceding-sibling::div//label[text()='Order ID:']/../following-sibling::div/span")
	static WebElement oderIdReport;

	@FindBy(id = "submitButton")
	static WebElement submitButton;

	/**
	 * This Method will verify navigation to payment gateway page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify Payment Gateway Page")
	public static void paymentGatewayPageVerification() {
		SeleniumUtils.waitForElementToBeVisible(submitButton);
		Assert.assertTrue(submitButton.isDisplayed());
		log.info("Payment Gateway Page displayed");
	}

	@Step("customer to pay any amount greater than zero for renewal..")
	public static void customerPayForRenewal(String name, String creditCardNumber, String cVCNumber) {

		SeleniumUtils.waitForElementToBeClickable(cardHolderName);
		cardHolderName.clear();
		cardHolderName.sendKeys(name);
		log.info("Enter card Holder Name  for payment");

		creditCardType.click();
		log.info("credit Card Type for payment");

		creditCardNumberElement.clear();
		creditCardNumberElement.sendKeys(creditCardNumber);
		log.info("credit Card Number for payment");

		cVCNumberElement.clear();
		cVCNumberElement.sendKeys(cVCNumber);
		log.info("CVC Number for payment");

		expirationDate.click();
		log.info("expiration Date for payment");

		expirationYear.click();
		log.info("expiration year for payment");

		Assert.assertTrue(submitButton.isDisplayed());
		submitButton.click();
		log.info("Sumbit payment Details");

	}
	
	/**
	 *This method will verify User should be navigated to the payment gateway.
	 * @return void
	 * @param void
	 */
    @Step("User should be navigated to the payment gateway.")
	public static void verifyUserNavigatedPaymentGateway() {
		SeleniumUtils.waitForElementToBeClickable(cardHolderName);
		Assert.assertTrue(cardHolderName.isDisplayed());
		log.info(" Card Holder Name is displayed");
	}
    
    
    /**
	 *This method will verify A new oderId should be created on the portal of the same program type.
	 * @return void
	 * @param void
	 */
	@Step("A new oderId should be created on the portal of the same program type.")
	public static String verifyOderIdNewApplicationCreated() {
		Assert.assertTrue(oderId.isDisplayed());
		log.info("OderId is displayed");
		
		String orderId = oderIdReport.getText();
		log.info("Oder Id for Report " + orderId);
		return orderId;
	}
}
