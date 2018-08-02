package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PaymentDetailsPage {

	private static Logger log = Logger.getLogger(PaymentDetailsPage.class.getName());

	@FindBy(id="name")
	static WebElement cardHolderName;

	@FindBy(id="card_type")
	static WebElement creditCardType;

	@FindBy(id="PAN")
	static WebElement creditCardNumberElement;

	@FindBy(xpath="//select[@name='cresecure_cc_expires_year']")
	static WebElement expirationDate;
	
	@FindBy(xpath="//select[@name='cresecure_cc_expires_year']//option[@value='25']")
	static WebElement expirationYear;

	@FindBy(id="cv_data")
	static WebElement cVCNumberElement;

	@FindBy(id="submitButton")
	static WebElement submitButton;

	@Step("customer to pay any amount greater than zero for renewal..")
	public static void customerPayForRenewal(String name,String creditCardNumber,String cVCNumber){
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

		submitButton.click();
		log.info("Sumbit payment Details");
	}
}