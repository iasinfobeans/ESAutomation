package com.es.pom;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PaymentPage {
	private static Logger log = Logger.getLogger(PaymentPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement paymentElement;

	@FindBy(xpath="//span[@class='message notices alert']//ul//li")
	static WebElement messageNoticeAlert;
	
	@FindBy(xpath="//div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Invoice')]")
	static WebElement invoiceLabel;
	
	@FindBy(xpath="//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'Total Amount')]")
	static WebElement totalAmountLabel;
	
	@FindBy(xpath="//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'Balance Amount')]")
	static WebElement balanceAmountLabel;
	
	@FindBy(xpath="//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'')]//span[@class='mandatory']")
	static WebElement payAmountLabelWithAsterick;
	
	@FindBy(id="address")
	static WebElement billingAddressLable;
	
	@FindBy(id="city")
	static WebElement cityLable;
	
	@FindBy(xpath="//div[@class='form-group']//label[contains(text(),'State / Province')]")
	static WebElement stateOrProvinceLable;
	
	@FindBy(xpath="//div[@class='form-group']//label[contains(text(),'Zip or Postal Code')]")
	static WebElement zipCodeLable;
	
	@FindBy(xpath="//div[@class='form-group']//label[contains(text(),'Country')]")
	static WebElement CountryLable;
	
	@FindBy(xpath="//div[@class='form-group']//label[contains(text(),'Phone')]")
	static WebElement phoneLable;
	
	@FindBy(linkText="Go Back")
	static WebElement goBackLink;
	
	@FindBy(xpath="//input[@type='submit']")
	static WebElement payLink;
	
	@FindBy(id="other_amount")
	static WebElement payAmountTextbox ;
	
	@FindBy(id="address")
	static WebElement addressTextbox ;
	
	@FindBy(id="city")
	static WebElement cityTextbox ;
	
	@FindBy(xpath="//div[@tabindex='8']")
	static WebElement stateTextbox;

	@FindBy(xpath="//label[contains(text(),'State')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> stateList;

	@FindBy(xpath="//div[@tabindex='10']")
	static WebElement countryDropdown;
	
	@FindBy(xpath="//label[contains(text(),'Country')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> countryList;
	
	@FindBy(id="zip")
	static WebElement zipTextbox ;
	
	@FindBy(id="phone")
	static WebElement phoneTextbox ;
	
	@Step("verify Payment page elements...")
	public static void verifyPaymentPageElements()
	{
		Assert.assertEquals(messageNoticeAlert.getText(),Prop.getTestData("message_invoice_payment"));
		log.info(messageNoticeAlert.getText());
		Assert.assertTrue(invoiceLabel.isDisplayed());
		log.info("label for invoice displayed");
		Assert.assertTrue(totalAmountLabel.isDisplayed());
		log.info("label for total Amount displayed");
		Assert.assertTrue(balanceAmountLabel.isDisplayed());
		log.info("label for balance amount displayed");
		Assert.assertTrue(payAmountLabelWithAsterick.isDisplayed());
		log.info("label for Pay Amount displayed and it is mandatory");
		Assert.assertTrue(billingAddressLable.isDisplayed());
		log.info("label for billing address displayed");
		Assert.assertTrue(cityLable.isDisplayed());
		log.info("label for city displayed");
		Assert.assertTrue(stateOrProvinceLable.isDisplayed());
		log.info("label for state Or Province displayed");
		Assert.assertTrue(CountryLable.isDisplayed());
		log.info("label for Country displayed");
		Assert.assertTrue(phoneLable.isDisplayed());
		log.info("label for phone displayed");
		Assert.assertTrue(goBackLink.isDisplayed());
		log.info("Go Back link displayed");
		Assert.assertTrue(payLink.isDisplayed());
		log.info("Pay Link displayed");
	}
	
	@Step("Fill Payment Page Form...")
	public static void fillPaymentPageForm()
	{
		payAmountTextbox.clear();
		payAmountTextbox.sendKeys(Prop.getTestData("payAmount"));
		log.info("Pay amount entered");
		addressTextbox.clear();
		addressTextbox.sendKeys(Prop.getTestData("billingAddress"));
		log.info("Address entered");
		cityTextbox.clear();
		cityTextbox.sendKeys(Prop.getTestData("billingCity"));
		log.info("City entered");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.waitForElementToBeVisible(stateTextbox);
		stateTextbox.click();
		log.info("selecting state");
		stateList.get(3).click();
		log.info("state selected");
		countryDropdown.click();
		log.info("selecting country");
		countryList.get(1).click();
		log.info("country selected");
		phoneTextbox.clear();
		phoneTextbox.sendKeys(Prop.getTestData("billingPhone"));
		log.info("Phone number entered");
	}
	
	@Step("Navigate to payment detail page...")
	public static void navigateToPaymentDetailPage()
	{
		payLink.click();
		log.info("Clicked on pay link");
	}
	
}
