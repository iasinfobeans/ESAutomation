package com.es.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class DashboardPage {

	private static Logger log = Logger.getLogger(DashboardPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement dashboardElement;

	@FindBy(linkText="Change Password")
	static WebElement changePasswordLink;

	@FindBy(xpath="//a[contains(@title, 'Dashboard')]")
	static WebElement dashboardOptionElement;

	@FindBy(xpath="//a[contains(@title,'Application')]")
	static WebElement applicationOptionElement;

	@FindBy(xpath="//a[contains(@title,'Payments')]")
	static WebElement paymentsOptionElement;

	@FindBy(xpath="//a[contains(@title, 'Contact Us')]")
	static WebElement contactUsOptionElement;

	@FindBy(xpath="//div[@class='enjoyhint_close_btn']")
	static WebElement popupWindow;

	@FindBy(linkText="Edit Profile")
	static WebElement editProfileLink;

	@FindBy(xpath="//span[@class='dropdown-menu-user-name']")
	static WebElement myAccountDropdown;

	@FindBy(xpath="//*[@title=\"Quotations\"]")
	static WebElement quotationOption;

	@FindBy(xpath="//*[@title=\"Reports\"]")
	static WebElement reportOption;

	@FindBy(xpath="//*[@title=\"Invoices\"]")
	static WebElement invoicesOption;

	@FindBy(xpath="//a[@title='Applications']")
	static WebElement applicationPageLink;

	@FindBy(linkText="PMG Listing Program")
	static WebElement PMGListingProgramLinkApprovedUser;

	@FindBy(xpath="//a[@programslug='pmg']")
	static WebElement PMGListingLinkForUnapprovedUser;

	@FindBy(linkText="Update Profile Requests")
	static WebElement updateProfileRequestsLink;

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement userListingsPageElement;

	@FindBy(xpath="//div[contains(@class,'hide-user-menu-moblie')]//span[text()='My Account']")
	static WebElement myAccountText;

	@FindBy(linkText="Logout")
	static WebElement logoutLink;

	@FindBy(xpath="//span[@class='report-name']")
	static WebElement reportName;

	@FindBy(xpath = "//div[@class='report_renewal_btn']//a[text()='Pay']")
	static WebElement payForReportButton;

	@FindBy(xpath="//a[contains(text(),'View Projects')]")
	static WebElement viewProjectsForReportButton;

	@FindBy(xpath="//a[contains(text(),'View Invoices')]")
	static WebElement viewInvoicesForReportButton;



	@FindBy(linkText = "View")
	static WebElement viewLink;

	@FindBy(xpath = "//*[text()='Requested By: ']")
	static WebElement requestedBy;

	@FindBy(xpath = "//*[text()='Company Name: ']")
	static WebElement companyName;

	@FindBy(xpath = "//*[text()='Email: ']")
	static WebElement email;

	@FindBy(xpath = "//*[text()='Phone: ']")
	static WebElement phone;

	@FindBy(xpath = "//*[text()='Contact Preference: ']")
	static WebElement contactReference;

	@FindBy(xpath = "//*[text()='Address: ']")
	static WebElement address;

	@FindBy(xpath = "//*[text()='City: ']")
	static WebElement city;

	@FindBy(xpath = "//*[text()='State: ']")
	static WebElement state;

	@FindBy(xpath = "//*[text()='Country: ']")
	static WebElement country;

	@FindBy(xpath = "//*[text()='Product Type: ']")
	static WebElement productType;

	@FindBy(xpath = "//*[text()='Product Description: ']")
	static WebElement ProductDescription;

	@FindBy(xpath = "//*[@value='Close']")
	static WebElement close;

	@FindBy(xpath = "//*[contains(text(),'Quotation Request :')]")
	static WebElement quotationRequest;
	
	@FindBy(linkText = "Upload")
	static WebElement upload;
	
	@FindBy(xpath = "//*[contains(text(),'Send Quotation for ')]")
	static WebElement sendQuotation;	 
	
	@FindBy(xpath = "//*[@name='program_type']/following-sibling::div")
	static WebElement dropDownInUploadQuotation;
	
	@FindBy(xpath = "//*[@id='quotes-document']")
	static WebElement uploadButton;
	
	@FindBy(xpath = "//*[@id='amountDiv']")
	static WebElement amountField;
	
	@FindBy(xpath = "//*[@id='quote_amount']")
	static WebElement amountTextBox;
	
	@FindBy(xpath = "//*[@id='expireDateDiv']")
	static WebElement expiredate;
	
	@FindBy(xpath = "//*[@id='upload_quote']")
	static WebElement send;
	
	@FindBy(xpath = "//*[@name='cancel_quote']")
	static WebElement cancelQuote;
	
	@FindBy(linkText = "ES Core")
	static WebElement esCore;
	
	@FindBy(linkText = "Plumbing Mechanical and Gas")
	static WebElement plumbingMechanicAndGas;
	
	@FindBy(linkText = "Evaluation Service Listing")
	static WebElement evaluationServiceListing;

	@Step("verify dashboard page Step...")
	public static void verifyDashboardPage()
	{
		Assert.assertTrue(dashboardElement.isDisplayed());
		log.info("Dashboard displayed");
	}

	@Step("Verify the registration process once correct OTP and other fields are entered Step...")
	public static void verifyRegistrationProcessAfterEnteringCorrectOTP()
	{
		Assert.assertTrue(dashboardOptionElement.isDisplayed());
		log.info("Dashboard Option is displayed");

		Assert.assertTrue(applicationOptionElement.isDisplayed());
		log.info("Application Option is displayed");

		Assert.assertTrue(paymentsOptionElement.isDisplayed());
		log.info("Payments Option is displayed");

		Assert.assertTrue(contactUsOptionElement.isDisplayed());
		log.info("ContactUs Option is displayed");
	}

	@Step("redirecting to password change page...")
	public static void navigateToChangePasswordPage()
	{
		changePasswordLink.click();
		log.info("Clicked on change password link");
	}

	@Step("redirecting to Edit Profile page...")
	public static void navigateToEditProfilePage()
	{
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();   
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}

	@Step("redirecting to Edit Profile page again...")
	public static void navigateToEditProfilePageAgain()
	{
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();   
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}
	
	@Step("User is qualified and all the portal options get available to user.")
	public static void verifyPortalOptionForQualifiedUser() {

		Assert.assertTrue(quotationOption.isDisplayed());
		log.info("Verify Quotation Option displayed");

		Assert.assertTrue(reportOption.isDisplayed());
		log.info("Verify Report Option displayed");

		Assert.assertTrue(invoicesOption.isDisplayed());
		log.info("Verify Invoices Option displayed");
	}

	@Step("redirecting to Application page...")
	public static void navigateToApplicationPage()
	{
		applicationPageLink.click();
		log.info("Navigated to application page");
	}

	@Step("redirecting to PMG Application Form...")
	public static void navigateToPMGApplicationProgramApprovedUser()
	{
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();   
		PMGListingProgramLinkApprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}

	@Step("'Get a Quote' button is present on the Quotation Listing page for the customer.")
	public static void verifyQuotationOption() {
		quotationOption.click();
		log.info("Verify Quotation Option displayed");
	}

	@Step("redirecting to PMG Application Form...")
	public static void navigateToPMGApplicationProgramUnapprovedUser()
	{
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();   
		PMGListingLinkForUnapprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}

	@Step("redirecting to modified users listing page...")
	public static void navigateToModifiedUsersList()
	{
		updateProfileRequestsLink.isDisplayed();
		log.info("Update request link present");
		updateProfileRequestsLink.click();
		log.info("Navigated to update profile requests list page");
		userListingsPageElement.isDisplayed();
		log.info("Verified navigation");
	}

	@Step("Verify the customer Dashboard to have an additional head titled 'Reports.")
	public static void verifyTitleReports(){
		reportOption.click();
		log.info("Verify Reports Option displayed");
	}

	@Step("Logging out from account...")
	public static void logout()
	{
		myAccountText.click();
		log.info("clicked on main menu");
		logoutLink.click();
		log.info("clicked on logout Link");

	}
	
	@Step("actions available on hovering over any report...")
	public static void hoveringOverAnyReport(){
		SeleniumUtils.mouseHover(reportName);
		log.info("Hover on Report Name");
	}
	
	@Step("Verify the actions available on hovering over any report...")
	public static void actionsAvailableHoveringOverAnyReport()
	{
		SeleniumUtils.waitForElementToBeVisible(payForReportButton);

		Assert.assertTrue(payForReportButton.isDisplayed());
		log.info("pay For Report Button is displayed");

		Assert.assertTrue(viewProjectsForReportButton.isDisplayed());
		log.info("view Projects For Report Button is displayed");

		Assert.assertTrue(viewInvoicesForReportButton.isDisplayed());
		log.info("view Invoices For Report  Button is displayed");

	}
	@Step("action on clicking the 'Pay' button...")
	public static void clickActionOnPayButton()
	{
		SeleniumUtils.waitForElementToBeVisible(payForReportButton);
		payForReportButton.click();
		log.info("pay For Report Button is clicked");
	}

	@Step("action on clicking the view Projects button...")
	public static void clickActionOnViewProjectsButton()
	{
		SeleniumUtils.waitForElementToBeVisible(viewProjectsForReportButton);
		viewProjectsForReportButton.click();
		log.info("view Projects button is clicked");
	}

	@Step("action on clicking the view Projects button...")
	public static void clickActionOnViewInvoicesButton()
	{
		SeleniumUtils.waitForElementToBeVisible(viewProjectsForReportButton);
		viewInvoicesForReportButton.click();
		log.info("view Invoices button is clicked");
	}
	
	@Step("Click on View Button")
	public static void verifyViewOption() {
		Assert.assertTrue(viewLink.isDisplayed());
		viewLink.click();
		log.info("Verify View option displayed");
	}

	@Step("Observing Pop up Window")
	public static void verifyPopUpWindowForView() {
		Assert.assertTrue(quotationRequest.isDisplayed());
		Assert.assertTrue(requestedBy.isDisplayed());
		Assert.assertTrue(companyName.isDisplayed());
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(contactReference.isDisplayed());
		Assert.assertTrue(address.isDisplayed());
		Assert.assertTrue(city.isDisplayed());
		Assert.assertTrue(state.isDisplayed());
		Assert.assertTrue(country.isDisplayed());
		Assert.assertTrue(productType.isDisplayed());
		Assert.assertTrue(ProductDescription.isDisplayed());
		Assert.assertTrue(close.isDisplayed());

		log.info("Verified Pop up Window and parameters on it for view option.");

	}
	
	@Step("Verifying Upload option id visible...")
	public static void verifyUploadOption() {
		Assert.assertTrue(upload.isDisplayed());
		upload.click();
		log.info("Verify Upload option displayed");
	}
	
	@Step("Observing Pop up Window for Upload option..")
	public static void verifyPopUpWindowForUpload() {
		SeleniumUtils.waitForElementToBeVisible(sendQuotation);
		Assert.assertTrue(sendQuotation.isDisplayed());
		SeleniumUtils.waitForElementToBeVisible(dropDownInUploadQuotation);
		Assert.assertTrue(dropDownInUploadQuotation.isDisplayed());
		Assert.assertTrue(uploadButton.isDisplayed());
		Assert.assertTrue(amountField.isDisplayed());
		Assert.assertTrue(expiredate.isDisplayed());
		Assert.assertTrue(send.isDisplayed());
		Assert.assertTrue(cancelQuote.isDisplayed());
		
		log.info("Verified Pop up Window and parameters on it for upload option.");

	}
	
	@Step("click on send button while uploading Quotation..")
	public static void clickSendWhileUploadingQuotation() {
		SeleniumUtils.waitForElementToBeVisible(send);
		Assert.assertTrue(send.isDisplayed());
		send.click();
		log.info("clicked on send button while uploading Quotation.");
	}

	@Step("Input valid values while uploading Quotation..")
	public static void InputValuesInUploadOption(String progarmType, String amount, String uploadFilePath) {
		dropDownInUploadQuotation.click();
		if (progarmType.equalsIgnoreCase("ES Core")) {
			esCore.click();
		}
		if (progarmType.equalsIgnoreCase("plumbingMechanicAndGas")) {
			plumbingMechanicAndGas.click();
		}
		if (progarmType.equalsIgnoreCase("Evaluation Service Listing")) {
			evaluationServiceListing.click();
		}
		
		amountTextBox.sendKeys(amount);
		uploadButton.click();
		uploadFilePath = uploadFilePath.replace("/", "\\");
		StringSelection ss = new StringSelection(uploadFilePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    try {
			Robot robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			log.error("Error while uploading file is: "+e);
			e.printStackTrace();
		}
	   
		log.info("Given input while uploading Quotation.");
	}

}
