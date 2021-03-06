package com.es.pom;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.Prop;
import com.es.util.RobotUtils;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PaymentPage {
	private static Logger log = Logger.getLogger(PaymentPage.class.getName());

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement paymentElement;

	@FindBy(id = "other_amount")
	static WebElement payAmountBox;

	@FindBy(id = "pmg-renewal-upload")
	static WebElement uploadElement;

	@FindBy(id = "address")
	static WebElement billingAddressBox;

	@FindBy(id = "city")
	static WebElement cityBox;

	@FindBy(xpath="//a[@class='sbSelector' and contains(text(),'Select State')]")
	static WebElement stateBox;    

	@FindBy(xpath = "//a[contains(text(),'Alabama')]")
	static WebElement state; 

	@FindBy(id = "zip")
	static WebElement zipBox;

	@FindBy(xpath = "//a[@class='sbSelector'and contains(text(),'United States')]")
	static WebElement countryBox;

	@FindBy(xpath = "//a[contains(text(),'United States')]")
	static WebElement country;

	@FindBy(id = "phone")
	static WebElement phoneBox;

	@FindBy(xpath = "//*[@id='pay_button'and @class='btn btn-primary btn-lg btn-default payment-button']")
	static WebElement payButton;

	@FindBy(xpath = "//label[contains(text(),'Renewal')][contains(text(),'Form')]")
	static WebElement renewaFormOption;

	@FindBy(xpath = "//span[@class='message notices alert']//ul//li")
	static WebElement messageNoticeAlert;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Invoice')]")
	static WebElement invoiceLabel;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'Total Amount')]")
	static WebElement totalAmountLabel;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'Balance Amount')]")
	static WebElement balanceAmountLabel;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody/tr//td//label[contains(text(),'')]//span[@class='mandatory']")
	static WebElement payAmountLabelWithAsterick;

	@FindBy(id = "address")
	static WebElement billingAddressLable;

	@FindBy(id = "city")
	static WebElement cityLable;

	@FindBy(xpath = "//div[@class='form-group']//label[contains(text(),'State / Province')]")
	static WebElement stateOrProvinceLable;

	@FindBy(xpath = "//div[@class='form-group']//label[contains(text(),'Zip or Postal Code')]")
	static WebElement zipCodeLable;

	@FindBy(xpath = "//div[@class='form-group']//label[contains(text(),'Country')]")
	static WebElement CountryLable;

	@FindBy(xpath = "//div[@class='form-group']//label[contains(text(),'Phone')]")
	static WebElement phoneLable;

	@FindBy(linkText = "Go Back")
	static WebElement goBackLink;

	@FindBy(xpath = "//input[@type='submit']")
	static WebElement payLink;

	@FindBy(id = "other_amount")
	static WebElement payAmountTextbox;

	@FindBy(id = "address")
	static WebElement addressTextbox;

	@FindBy(id = "city")
	static WebElement cityTextbox;

	@FindBy(xpath = "//div[@tabindex='8']")
	static WebElement stateTextbox;

	@FindBy(xpath = "//label[contains(text(),'State')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> stateList;

	@FindBy(xpath = "//div[@tabindex='10']")
	static WebElement countryDropdown;

	@FindBy(xpath = "//label[contains(text(),'Country')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> countryList;

	@FindBy(id = "zip")
	static WebElement zipTextbox;

	@FindBy(id = "phone")
	static WebElement phoneTextbox;

	@FindBy(xpath ="//li[contains(text(),'Quote')]")
	static WebElement applicationExpiredMessage ;

	@FindBy(xpath = "//input[@class='custom-input-box balance_amount']")
	static WebElement balanceAmount;

	@FindBy(xpath = "///div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Application')][contains(text(),'No.')]")
	static WebElement ApplicationNumberLabel;

	@FindBy(xpath = "//tr//td//label[contains(text(),'Pay')][contains(text(),'Amount')]")
	static WebElement payAmountLabelForApplication;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Quotation Id')]")
	static WebElement quotationIdLabel;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Basic Fees')]")
	static WebElement basicFeesLabel;

	@FindBy(xpath = "//div[@class='form-group invoice-no-patch']//table//tbody//tr//td//label[contains(text(),'Pay')][contains(text(),'Amount')]")
	static WebElement payAmountLabel;

	@FindBy(xpath = "//table//tbody//tr//td//label[contains(text(),'Comment')][contains(text(),'if')][contains(text(),'any')]")
	static WebElement commentLabelInApplicationPaymentPage;

	static String balanceAmountbeforePay;

	static String balanceAmountAfterPay;
	
	@FindBy(xpath = "//div[contains(text(),'Please select file')]")
	static WebElement pleaseSelectFileMessage;


	/**
	 * This Method will verify payment page elements for invoice payment
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify Payment page elements for Invoice")
	public static void verifyPaymentPageElementsForInvoice()
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

	/**
	 *This method will verify Payment page.
	 * @return void
	 * @param void
	 */
	@Step("verify Payment page Step")
	public static void verifyPaymentPage() {
		Assert.assertTrue(paymentElement.isDisplayed());
		log.info("Payment page is displayed");
	}

	/**
	 *This method will verify details of customer to pay any amount greater than zero for renewal.
	 * @return void
	 * @param payAmount 
	 * @param billingAddress
	 * @param city
	 * @param zip 
	 * @param phone
	 */
	@Step("Verify Details of customer")
	public static void customerDetailsForRenewal(String payAmount, String billingAddress, String city, String zip,String phone) {
		SeleniumUtils.waitForElementToBeVisible(payAmountBox);
		payAmountBox.clear();
		payAmountBox.sendKeys(payAmount);
		log.info("Enter pay Amount ");

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

		phoneBox.clear();
		phoneBox.sendKeys(phone);
		log.info("Enter your phone details");

		SeleniumUtils.waitForElementToBeClickable(payButton);
		Assert.assertTrue(payButton.isDisplayed());
		log.info("pay option for payment is displayed");
		SeleniumUtils.executeJavaScript("arguments[0].click();", payButton);
		log.info("Enter pay option for payment");
	}

	/**
	 *This method will verify the customer is allowed to upload renewal application.
	 * @return void
	 * @param void.
	 */
	@Step("Verify Upload renewal application")
	public static void uploadRenewalApplicationForCustomer() {
		Assert.assertTrue(payAmountBox.isDisplayed());
		uploadElement.click();
		log.info("Enter upload pdf ");
		String uploadfilePath = System.getProperty("user.dir")+ "\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
		RobotUtils.uploadFile(uploadfilePath);
		log.info("upload pdf from drive ");
	}

	/**
	 *This method will verify presence of an additional field 'Renewal Form' on the payment screen for Application Renewal payment.
	 * @return void
	 * @param void.
	 */
	@Step("Verify Additional field 'Renewal Form' on the payment screen for Application Renewal payment")
	public static void additionalCustomerFieldRenewalForm() {
		Assert.assertTrue(renewaFormOption.isDisplayed());
		log.info("renewal Form option displayed");
	}


	/**
	 * This Method will fill payment page form for an invoice
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Fill Payment Page Form for invoice")
	public static void fillPaymentPageFormForInvoice()
	{
		SeleniumUtils.refreshPage();
		Assert.assertTrue(payAmountTextbox.isDisplayed());
		balanceAmountbeforePay=balanceAmount.getAttribute("value");
		log.info("stored balance amount");
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
		SeleniumUtils.waitForElementToBeClickable(stateList.get(3));
		stateList.get(3).click();
		log.info("state selected");
		zipTextbox.clear();
		zipTextbox.sendKeys(Prop.getTestData("zipBillingCity"));
		SeleniumUtils.waitForElementToBeVisible(countryDropdown);
		countryDropdown.click();
		log.info("selecting country");
		SeleniumUtils.waitForElementToBeClickable(countryList.get(1));
		countryList.get(1).click();
		log.info("country selected");
		phoneTextbox.clear();
		phoneTextbox.sendKeys(Prop.getTestData("billingPhone"));
		log.info("Phone number entered");
	}

	/**
	 * This Method will verify payment page elements of Application
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify payment page elements for Applications")
	public static void verifyPaymentPageElementsForApplication()
	{
		Assert.assertEquals(messageNoticeAlert.getText(),Prop.getTestData("message_invoice_payment"));
		log.info(messageNoticeAlert.getText());
		Assert.assertTrue(ApplicationNumberLabel.isDisplayed());
		log.info("label for Application no. displayed");
		Assert.assertTrue(payAmountLabel.isDisplayed());
		log.info("label for Pay amount displayed");
		Assert.assertTrue(commentLabelInApplicationPaymentPage.isDisplayed());
		log.info("label for comment displayed");
		Assert.assertTrue(billingAddressLable.isDisplayed());
		log.info("label for billing address displayed");
		Assert.assertTrue(cityLable.isDisplayed());
		log.info("label for city displayed");
		Assert.assertTrue(stateOrProvinceLable.isDisplayed());
		log.info("label for state Or Province displayed");
		Assert.assertTrue(zipTextbox.isDisplayed());
		log.info("label for Zip displayed");
		Assert.assertTrue(CountryLable.isDisplayed());
		log.info("label for Country displayed");
		Assert.assertTrue(phoneLable.isDisplayed());
		log.info("label for phone displayed");
		Assert.assertTrue(goBackLink.isDisplayed());
		log.info("Go Back link displayed");
		Assert.assertTrue(payLink.isDisplayed());
		log.info("Pay Link displayed");
	}

	/**
	 * This Method will fill the payment page form
	 * for an application
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Fill Payment Page Form")
	public static void fillPaymentPageFormForApplication()
	{
		SeleniumUtils.refreshPage();
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
		SeleniumUtils.waitForElementToBeClickable(stateList.get(3));
		stateList.get(3).click();
		log.info("state selected");
		zipTextbox.clear();
		zipTextbox.sendKeys(Prop.getTestData("zipBillingCity"));
		SeleniumUtils.waitForElementToBeVisible(countryDropdown);
		countryDropdown.click();
		log.info("selecting country");
		SeleniumUtils.waitForElementToBeClickable(countryList.get(1));
		countryList.get(1).click();
		log.info("country selected");
		phoneTextbox.clear();
		phoneTextbox.sendKeys(Prop.getTestData("billingPhone"));
		log.info("Phone number entered");
	}


	/**
	 * This Method will navigate you to Payment Gateway page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to payment Gateway page")
	public static void navigateToPaymentGatewayPage()
	{
		SeleniumUtils.waitForElementToBeVisible(payLink);
		Assert.assertTrue(payLink.isDisplayed());
		payLink.click();
		log.info("Clicked on pay link");
	}


	/**
	 * This Method will verify that due amount gets reduced by x 
	 * after a payment of x amount has been made
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify the Balance due amount on the Portal")
	public static void compareBalanceAmountBeforAndAfterPay()
	{
		balanceAmountAfterPay=balanceAmount.getAttribute("value");
		log.info("stored balance amount after pay");
		assertEquals(balanceAmountAfterPay, balanceAmountbeforePay, "Compare balance amount before and after pay");
	}

	/**
	 *This method will verify Renewal Form field is not a mandatory field for ESL & ESR renewal..
	 * @return void
	 * @param void.
	 */
	@Step("Verify Renewal Form field is not a mandatory field for ESL & ESR renewal")
	public static void renewalFormNotMandatoryEslEsr(String payAmount,String billingAddress,String city,String zip,String phone){
		SeleniumUtils.waitForElementToBeVisible(payAmountBox);
		payAmountBox.clear();
		payAmountBox.sendKeys(payAmount);
		log.info("Enter pay Amount ");

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
		Assert.assertTrue(payButton.isDisplayed());
		log.info("pay option for payment is displayed");

		payButton.click();
		log.info("Enter pay option for payment");
	}

	@Step("Verify payment page elements for Applications...")
	public static void verifyPaymentPageElementsForApplication_1Nisha() {
		Assert.assertEquals(messageNoticeAlert.getText(), Prop.getTestData("message_invoice_payment"));
		log.info(messageNoticeAlert.getText());
		Assert.assertTrue(ApplicationNumberLabel.isDisplayed());
		log.info("label for Application no. displayed");
		Assert.assertTrue(quotationIdLabel.isDisplayed());
		log.info("label for Quotation Id is displayed");
		Assert.assertTrue(payAmountLabel.isDisplayed());
		log.info("label for Pay amount displayed");
		Assert.assertTrue(basicFeesLabel.isDisplayed());
		log.info("label for Basic Fees displayed");
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
	/**
	 * This method will verify payment page elements for ReportRenewal.
	 * @return void
	 * @param void
	 */
	@Step("Verify payment page Element")
	public static void verifyPaymentPageElementsForReportRenewal() {
		Assert.assertTrue(paymentElement.isDisplayed());
		log.info("Payment Element displayed");

	}

	/**
	 * Verify that if the customer has selected the quote and saved/submitted the application, but tries to make payment 
	 * after the expiration date of the quote, then for such applications, the customer should not be able to make the payment.
	 * @return void
	 * @param void
	 */
	@Step("Verify customer tries to make payment after the expiration date of the quote unable to make the payment")
	public static void paymenAfterExpirationDate() {
		Assert.assertTrue(applicationExpiredMessage.isDisplayed());
		log.info("application Expired Message.");
	}


/**
 *This method will verify  please Select File Message when Renewal Form field is a mandatory field for PMG renewal.
 * @return void
 * @param void
 */
@Step("verify please Select File Message for Renewal of PMG")
public static void verifyRenewalFormMandatoryFieldPMG() {
	Assert.assertTrue( pleaseSelectFileMessage.isDisplayed());
	log.info("Payment page is displayed");
  }
}
