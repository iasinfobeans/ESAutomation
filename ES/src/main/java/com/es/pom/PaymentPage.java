package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.RobotUtils;
import com.es.util.SeleniumUtils;


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

	@FindBy(id="other_amount")
	static WebElement payAmountBox;

	@FindBy(id="pmg-renewal-upload")
	static WebElement uploadElement;

	@FindBy(id="address")
	static WebElement billingAddressBox;

	@FindBy(id="city")
	static WebElement cityBox;

	@FindBy(xpath="//a[@class='sbSelector' and contains(text(),'Select State')]")
	static WebElement stateBox;    

	@FindBy(xpath="//a[contains(text(),'Alabama')]")
	static WebElement state; 

	@FindBy(id="zip")
	static WebElement zipBox;

	@FindBy(xpath="//a[@class='sbSelector'and contains(text(),'United States')]")
	static WebElement countryBox; 

	@FindBy(xpath="//a[contains(text(),'United States')]")
	static WebElement country; 

	@FindBy(id="phone")
	static WebElement phoneBox;

	@FindBy(xpath="//*[@id='pay_button'and @class='btn btn-primary btn-lg btn-default payment-button']")
	static WebElement payButton;
	
	@FindBy(xpath="//label[contains(text(),'Renewal')][contains(text(),'Form')]")
	static WebElement renewaFormOption;
	
	
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
	
	@Step("verify Payment page Step...")
	public static void verifyPaymentPage()
	{
		Assert.assertTrue(paymentElement.isDisplayed());
		log.info("Payment page is displayed");
	}

	@Step("details of customer to pay any amount greater than zero for renewal..")
	public static void detailCustomerPayForRenewal(String payAmount,String billingAddress,String city,String zip,String phone){
		SeleniumUtils.waitForElementToBeVisible(payAmountBox);
		payAmountBox.clear();
		payAmountBox.sendKeys(payAmount);
		log.info("Enter pay Amount ");


		uploadElement.click();
		log.info("Enter upload pdf ");

		RobotUtils.uploadFile();
		log.info("upload pdf from drive ");

		billingAddressBox.clear();
		billingAddressBox.sendKeys(billingAddress);
		log.info("Enter billing Address For Renewal of Report ");

		cityBox.clear();
		cityBox.sendKeys(city);
		log.info("Enter your city");

		stateBox.click();
		log.info("choose one state from given states");

		state.click();
		log.info("Enter your state");

		zipBox.clear();
		zipBox.sendKeys(zip);
		log.info("Enter your zip");


		countryBox.click();
		log.info("choose one country from given country");

		country.click();
		log.info("Enter your country");

		SeleniumUtils.waitForElementToBeClickable(phoneBox);
		phoneBox.clear();
		phoneBox.sendKeys(phone);
		log.info("Enter your phone details");

		SeleniumUtils.waitForElementToBeClickable(payButton);
		payButton.click();
		log.info("Enter pay option for payment");
	}

	@Step("the customer is allowed to upload renewal application...")
	public static void uploadRenewalApplicationForCustomer() { 
		uploadElement.click();
		log.info("Enter upload pdf ");

		RobotUtils.uploadFile();
		log.info("upload pdf from drive ");

	}

	@Step("presence of an additional field 'Renewal Form' on the payment screen for Application Renewal payment")
	public static void additionalCustomerFieldRenewalForm() {
		Assert.assertTrue(renewaFormOption.isDisplayed());
		log.info("renewa Form option displayed");
	}

}
