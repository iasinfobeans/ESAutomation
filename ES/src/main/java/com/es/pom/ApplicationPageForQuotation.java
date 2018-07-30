package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;

public class ApplicationPageForQuotation {
	private static Logger log = Logger.getLogger(ApplicationPageForQuotation.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement applicationElement;

	@FindBy(id="appcompanyname")
	static WebElement companyNameTextBox;

	@FindBy(id="companylegalstatus")
	static WebElement companyLegalStatusTextBox;

	@FindBy(id="mailingaddress")
	static WebElement mailingAddressTextBox;

	@FindBy(id="city")
	static WebElement cityTextBox;

	@FindBy(id="state")
	static WebElement stateTextBox;

	@FindBy(id="zip")
	static WebElement zipTextBox;

	@FindBy(id="telephone1")
	static WebElement telephoneTextBox;

	@FindBy(id="emailaddress")
	static WebElement emailAddressTextBox;

	@FindBy(id="subject_of_report")
	static WebElement subjectOfReportTextBox;

	@FindBy(id="app_sidebar_save")
	static WebElement saveButton;

	@FindBy(xpath="//span[@class='message success alert']")
	static WebElement successAlert;


	@Step("verify Application page for View Quote...")
	public static void verifyApplicationPageForViewQuote() {
		Assert.assertTrue(applicationElement.isDisplayed());
		log.info("Verify Register from PMG displayed");

	}


	@Step("Enter information exactly as it should appear in published report...")
	public static void fillApplication (String companyName,String companyLegalStatus,String mailingAddress,String city,String state,String zip, String companyPhoneNumber,String companyEmailAddress, String subjectOfReport ) {

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

		saveButton.click();
		log.info("Click on save Button");
	}

	@Step("Verify successful submission of information to be published in report...")
	public static void verifySuccessfulSubmissionOfreport()
	{
        Assert.assertTrue(successAlert.isDisplayed());
		log.info("success Alert is displayed");
	}
}
