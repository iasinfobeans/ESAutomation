package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.setup.Setup;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class ApplicationPageForQuotation {
	private static Logger log = Logger.getLogger(ApplicationPageForQuotation.class.getName());

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement applicationElement;

	@FindBy(id = "appcompanyname")
	static WebElement companyNameTextBox;

	@FindBy(id = "companylegalstatus")
	static WebElement companyLegalStatusTextBox;

	@FindBy(id = "mailingaddress")
	static WebElement mailingAddressTextBox;

	@FindBy(id = "city")
	static WebElement cityTextBox;

	@FindBy(id = "state")
	static WebElement stateTextBox;

	@FindBy(id = "zip")
	static WebElement zipTextBox;

	@FindBy(id = "telephone1")
	static WebElement telephoneTextBox;

	@FindBy(id = "emailaddress")
	static WebElement emailAddressTextBox;

	@FindBy(id = "subject_of_report")
	static WebElement subjectOfReportTextBox;

	@FindBy(id = "app_sidebar_save")
	static WebElement saveButton;

	@FindBy(xpath = "//span[@class='message success alert']")
	static WebElement successAlert;

	@FindBy(xpath = "//*[@id='tech_rep_name']")
	static WebElement technicalRepresentativeName;

	@FindBy(xpath = "//*[@id='auth_sign_name']")
	static WebElement authSignatoryName;

	@FindBy(xpath = "//*[@id='billing_rep_name']")
	static WebElement billingRepresentativeName;

	@FindBy(xpath = "//*[@id='same_as_company_technical']")
	static WebElement sameAsCompanyAddressCheckbox;

	@FindBy(xpath = "//*[@id='same_as_company_authorized']")
	static WebElement sameAsAuthSignAddressCheckbox;

	@FindBy(xpath = "//*[@id='same_as_company_billing']")
	static WebElement sameAsBillingAddressCheckbox;

	@FindBy(xpath = "//*[@id='tech_rep_email']")
	static WebElement technicalRepresentativeEmail;

	@FindBy(xpath = "//*[@id='auth_rep_email']")
	static WebElement authSignatoryEmail;

	@FindBy(xpath = "//*[@id='billing_rep_email']")
	static WebElement billingRepresentativeEmail;

	@FindBy(xpath = "//*[@id='app_sidebar_submit']")
	static WebElement submitApplication;

	@FindBy(xpath = "//h1[text()='Disclaimer']")
	static WebElement submitPopup;

	@FindBy(xpath = "//div[@id='submit_popup']//ul[@class='radio-frm agreement-checkbox']")
	static WebElement submitAgreement;

	@FindBy(xpath = "//*[@id='continue_to_submit']")
	static WebElement continueToSubmit;

	@FindBy(linkText = "Pay")
	static WebElement pay;

	@FindBy(xpath = "//*[@class='custom-input-box basic-fees-phone']")
	static WebElement basicFees;

	@FindBy(xpath = "//*[@id='other_amount']")
	static WebElement quotationAmount;

    @FindBy(xpath = "//*[@id='app_sidebar_pay_btn']")
	static WebElement payNow;
	
	/**
	 * This method will verify Application page for View Quote.
	 * @return void
	 * @param void
	 */
   @Step("Verify Application page for View Quote")
	public static void verifyApplicationPageForViewQuote() {
		Assert.assertTrue(applicationElement.isDisplayed());
		log.info("Application page for View Quote");

	}
	/**
	 * This method will Enter information exactly as it should appear in published report.
	 * @param companyName
	 * @param companyLegalStatus
	 * @param mailingAddress
	 * @param city
	 * @param state
	 * @param  zip
	 * @param companyPhoneNumber
	 * @param companyEmailAddress
	 * @param subjectOfReport
	 * @return void
	 */

	@Step("Enter information for report")
	public static void fillApplication(String companyName, String companyLegalStatus, String mailingAddress,
			String city, String state, String zip, String companyPhoneNumber, String companyEmailAddress,
			String subjectOfReport) {

		Assert.assertTrue(companyNameTextBox.isDisplayed());
		companyNameTextBox.clear();
		companyNameTextBox.sendKeys(companyName);
		log.info("Enter your company name");

		companyLegalStatusTextBox.clear();
		companyLegalStatusTextBox.sendKeys(companyLegalStatus);
		log.info("Enter your company Legal Status");

		mailingAddressTextBox.clear();
		mailingAddressTextBox.sendKeys(mailingAddress);
		log.info("Enter your mailing Address ");

		cityTextBox.clear();
		cityTextBox.sendKeys(city);
		log.info("Enter your city ");

		stateTextBox.clear();
		stateTextBox.sendKeys(state);
		log.info("Enter your state");

		zipTextBox.clear();
		zipTextBox.sendKeys(zip);
		log.info("Enter your zip  ");

		telephoneTextBox.clear();
		telephoneTextBox.sendKeys(companyPhoneNumber);
		log.info("Enter your company Phone Number ");

		emailAddressTextBox.clear();
		emailAddressTextBox.sendKeys(companyEmailAddress);
		log.info("Enter your company Email Address ");

		subjectOfReportTextBox.clear();
		subjectOfReportTextBox.sendKeys(subjectOfReport);
		log.info("Enter your subject Of Report");

		Assert.assertTrue(saveButton.isDisplayed());
		saveButton.click();
		log.info("Click on save Button");
	}
	
	/**
	 * This method will click on save and submit application.
	 */

	@Step("Verify successful submission of information to be published in report")
	public static void verifySuccessfulSubmissionOfreport() {
		Assert.assertTrue(successAlert.isDisplayed());
		log.info("success Alert is displayed");
	}

	/**
	 * This method will click on save and submit application.
	 * @param void
	 * @return void
	 */
	@Step("Click on submit button")
	public static void submitApplication() {
		SeleniumUtils.waitForElementToBeVisible(submitApplication);
		Assert.assertTrue(submitApplication.isDisplayed());
		saveButton.click();
		log.info("Click on save Button");
		submitApplication.click();
		log.info("Clicked on Submit Button");
	}

	/**
	 * This method will fill the contact details while filling the application.
	 * @param techRepName
	 * @param authRepName
	 * @param billingRepName
	 * @param techRepEmail
	 * @param authRepEmail
	 * @param billingRepEmail
	 * @return void
	 */
	@Step("Enter contact information")
	public static void fillContactDetails(String techRepName, String authRepName, String billingRepName,
			String techRepEmail, String authRepEmail, String billingRepEmail) {
		Assert.assertTrue(technicalRepresentativeName.isDisplayed());
		technicalRepresentativeName.clear();
		technicalRepresentativeName.sendKeys(techRepName);
		authSignatoryName.clear();
		authSignatoryName.sendKeys(authRepName);
		billingRepresentativeName.clear();
		billingRepresentativeName.sendKeys(billingRepName);
		sameAsCompanyAddressCheckbox.click();
		sameAsAuthSignAddressCheckbox.click();
		sameAsBillingAddressCheckbox.click();
		technicalRepresentativeEmail.clear();
		technicalRepresentativeEmail.sendKeys(techRepEmail);
		authSignatoryEmail.clear();
		authSignatoryEmail.sendKeys(authRepEmail);
		billingRepresentativeEmail.clear();
		billingRepresentativeEmail.sendKeys(billingRepEmail);

		log.info("Entered contact information");
	}

	/**
	 * This method will accept agreement terms and conditions.
	 * @param billingRepEmail
	 * @return void
	 * @param void
	 */
	@Step("Accept agreement terms and conditions")
	public static void agreementCheckBox() {
		SeleniumUtils.waitForElementToBeVisible(submitPopup);
		Assert.assertTrue(submitPopup.isDisplayed());
		log.info("submit pop up displayed.");

		SeleniumUtils.waitForElementToBeVisible(submitAgreement);
		submitAgreement.click();
		log.info("Accept Agreement terms and condition.");
	}

	/**
	 * This method will submit agreement.
	 * @return void
	 * @param void
	 */
	@Step("Submit agreement")
	public static void submitAgreement() {
		SeleniumUtils.waitForElementToBeVisible(continueToSubmit);
		continueToSubmit.click();
		log.info("Submit Agreement.");
	}

	/**
	 * This method will click on Pay option.
	 * @return void
	 * @param void
	 */
	@Step("click on pay option")
	public static void pay() {
		Assert.assertTrue(pay.isDisplayed());
		pay.click();
		log.info("Clicked on Pay option.");
	}

	/**
	 * This method will observe basic fees and Quotation amount
	 * @return void
	 * @param void
	 */
	@Step("Verify observe basic fees and Quotation amount")
	public static void observeBasicFees() {

		String basicFee = basicFees.getAttribute("Value");
		basicFee = basicFee.substring(0, basicFee.indexOf("."));
		String quotAmount = quotationAmount.getAttribute("Value");
		quotAmount = quotAmount.substring(0, quotAmount.indexOf("."));

		if (Integer.parseInt(basicFee) > Integer.parseInt(quotAmount)) {
			log.info("Basic fees is sufficient.");
		}
		log.info("Observed basic fees and Quotation amount.");
	}

	/**
	 * This method will search for coupon option for application which is applied through Quotation
	 * @return void
	 * @param void
	 */
	@Step("Verify Search for coupon option for application which is applied through Quotation")
	public static void couponOption() {
		if (Setup.driver.getPageSource().contains("Do you have a coupon?")) {
			log.info("Coupon Discount available for Quotation.");
		} else {
			log.info("Coupon Discount is not available for Quotation.");
		}
	}
	
	/**
	 * 
	 * This method will Verify customer tries to make payment after the expiration date of the quote unable to make the payment.
	 * @return void
	 * @param void
	 */
	@Step("Verify customer tries to make payment after the expiration date of the quote unable to make the payment")
	public static void payForExpiredQuote() {
		Assert.assertTrue(payNow.isDisplayed());
		SeleniumUtils.waitForElementToBeClickable(payNow);
		payNow.click();
		log.info("pay for expired Application.");
		
	}

}

