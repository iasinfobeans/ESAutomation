package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.RobotUtils;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class DashboardPage {

	private static Logger log = Logger.getLogger(DashboardPage.class.getName());

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement dashboardElement;

	@FindBy(linkText = "Change Password")
	static WebElement changePasswordLink;

	@FindBy(xpath = "//a[contains(@title, 'Dashboard')]")
	static WebElement dashboardOptionElement;

	@FindBy(xpath = "//a[contains(@title,'Application')]")
	static WebElement applicationOptionElement;

	@FindBy(xpath = "//a[contains(@title,'Payments')]")
	static WebElement paymentsOptionElement;

	@FindBy(xpath = "//a[contains(@title, 'Contact Us')]")
	static WebElement contactUsOptionElement;

	@FindBy(xpath = "//div[@class='enjoyhint_close_btn']")
	static WebElement popupWindow;

	@FindBy(linkText = "Edit Profile")
	static WebElement editProfileLink;

	@FindBy(xpath = "//span[@class='dropdown-menu-user-name']")
	static WebElement myAccountDropdown;

	@FindBy(xpath = "//*[@title='Quotations']")
	static WebElement quotationOption;

	@FindBy(xpath = "//*[@title='Reports']")
	static WebElement reportOption;

	@FindBy(xpath = "//*[@title='Invoices']")
	static WebElement invoicesOption;

	@FindBy(xpath = "//a[@title='Applications']")
	static WebElement applicationListingPageLink;

	@FindBy(linkText = "PMG Listing Program")
	static WebElement pmgListingProgramLinkApprovedUser;

	@FindBy(xpath = "//a[@programslug='pmg']")
	static WebElement pmgListingLinkForUnapprovedUser;

	@FindBy(linkText = "Update Profile Requests")
	static WebElement updateProfileRequestsLink;

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement userListingsPageElement;

	@FindBy(xpath = "//div[contains(@class,'hide-user-menu-moblie')]//span[text()='My Account']")
	static WebElement myAccountText;

	@FindBy(linkText = "Logout")
	static WebElement logoutLink;

	@FindBy(xpath = "//span[@class='report-name']")
	static WebElement reportName;

	@FindBy(xpath = "//div[@class='report_renewal_btn']//a[text()='Pay']")
	static WebElement payForReportButton;

	@FindBy(xpath = "//a[contains(text(),'View Projects')]")
	static WebElement viewProjectsForReportButton;

	@FindBy(xpath = "//a[contains(text(),'View Invoices')]")
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

	@FindBy(xpath = "//div[@class='unpaid-lwa-loading']")
	static WebElement loadingIcon;

	@FindBy(linkText = "Invoices")
	static WebElement invoicePageLink;

	@FindBy(xpath = "//a[@title='SOW']")
	static WebElement sowSection;

	@Step("verify dashboard page Step...")
	public static void verifyDashboardPage() {
		Assert.assertTrue(dashboardElement.isDisplayed());
		log.info("Dashboard displayed");
	}
	/**
	 * @author Shefali.Garg
	 * @description This method will Verify the registration process once correct OTP and other fields are entered and User is on DashboardPage .
	 * @return void
	 * @param void
	 */
	@Step("Verify the registration process once correct OTP and other fields are entered Step...")
	public static void verifyRegistrationProcessAfterEnteringCorrectOTP() {
		Assert.assertTrue(dashboardOptionElement.isDisplayed());
		log.info("Dashboard Option is displayed");

		Assert.assertTrue(applicationOptionElement.isDisplayed());
		log.info("Application Option is displayed");

		Assert.assertTrue(paymentsOptionElement.isDisplayed());
		log.info("Payments Option is displayed");

		Assert.assertTrue(contactUsOptionElement.isDisplayed());
		log.info("ContactUs Option is displayed");
	}

	@Step("Redirecting to password change page...")
	public static void navigateToChangePasswordPage() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(changePasswordLink);
		changePasswordLink.click();
		log.info("Clicked on change password link");
	}

	@Step("Redirecting to Edit Profile page...")
	public static void navigateToEditProfilePage() {
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
	public static void navigateToEditProfilePageAgain() {
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}
	/**
	 * @author Shefali.Garg
	 * @description This method will Verify User is qualified and all the portal options get available to user.
	 * @return void
	 * @param void
	 */
	@Step("User is qualified and all the portal options get available to user.")
	public static void verifyPortalOptionForQualifiedUser() {

		Assert.assertTrue(quotationOption.isDisplayed());
		log.info("Verify Quotation Option displayed");

		Assert.assertTrue(reportOption.isDisplayed());
		log.info("Verify Report Option displayed");

		Assert.assertTrue(invoicesOption.isDisplayed());
		log.info("Verify Invoices Option displayed");
	}

	@Step("redirecting to Application Listing page...")
	public static void navigateToApplicationListingPage() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();
		applicationListingPageLink.click();
		log.info("Navigated to application page");
	}

	@Step("redirecting to Application page when already logged in...")
	public static void navigateToApplicationPageWhenLoggedIn() {
		SeleniumUtils.refreshPage();
		applicationListingPageLink.click();
		log.info("Navigated to application page");
	}

	@Step("redirecting to PMG Application Form...")
	public static void navigateToPMGApplicationProgramApprovedUser() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();
		pmgListingProgramLinkApprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}
	
	/**
	 * @author Shefali.Garg
	 * @description This method will verify Quotation Option is present on Dash-board.
	 * @return void
	 * @param void
	 */
	@Step("verify Quotation Option is present on Dashboard.")
	public static void verifyQuotationOption() {
		quotationOption.click();
		log.info("Verify Quotation Option displayed");
	}

	@Step("redirecting to PMG Application Form...")
	public static void navigateToPMGApplicationProgram() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(pmgListingLinkForUnapprovedUser);
		pmgListingLinkForUnapprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}

	@Step("redirecting to modified users listing page...")
	public static void navigateToModifiedUsersList() {
		updateProfileRequestsLink.isDisplayed();
		log.info("Update request link present");
		updateProfileRequestsLink.click();
		log.info("Navigated to update profile requests list page");
		userListingsPageElement.isDisplayed();
		log.info("Verified navigation");
	}

	/**
	 * @author Shefali.Garg
	 * @description This method will verify customer Dash-board to have an additional head titled 'Reports.
	 * @return void
	 * @param void
	 */
	@Step("Verify the customer Dashboard to have an additional head titled 'Reports.")
	public static void verifyTitleReports() {
		reportOption.click();
		log.info("Verify Reports Option displayed");
	}

	@Step("Logging out from account...")
	public static void logout() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", myAccountText);
		log.info("clicked on main menu");
		SeleniumUtils.executeJavaScript("arguments[0].click();", logoutLink);
		log.info("clicked on logout Link");

	}

	/**
	 * @author Shefali.Garg
	 * @description This method will verify the actions available on hovering over any report.
	 * @return void
	 * @param void
	 */
	@Step("actions available on hovering over any report...")
	public static void hoveringOverAnyReport() {
		SeleniumUtils.waitForElementToBeInvisible(loadingIcon);
		SeleniumUtils.waitForElementToBeVisible(reportName);
		SeleniumUtils.mouseHover(reportName);
		log.info("Hover on Report Name");
	}
	/**
	 * @author Shefali.Garg
	 * @description This method will verify hovering over any report.
	 * @return void
	 * @param void
	 */
	@Step("Verify the actions available on hovering over any report...")
	public static void actionsAvailableHoveringOverAnyReport() {
		SeleniumUtils.waitForElementToBeVisible(payForReportButton);

		Assert.assertTrue(payForReportButton.isDisplayed());
		log.info("pay For Report Button is displayed");

		Assert.assertTrue(viewProjectsForReportButton.isDisplayed());
		log.info("view Projects For Report Button is displayed");

		Assert.assertTrue(viewInvoicesForReportButton.isDisplayed());
		log.info("view Invoices For Report  Button is displayed");

	}

	/**
	 * @author Shefali.Garg
	 * @description This method will verify the action on clicking the 'Pay' button.
	 * @return void
	 * @param void
	 */
	@Step("action on clicking the 'Pay' button...")
	public static void clickActionOnPayButton() {
		SeleniumUtils.waitForElementToBeVisible(payForReportButton);
		payForReportButton.click();
		log.info("pay For Report Button is clicked");
	}
	
	
	/**
	 * @author Shefali.Garg
	 * @description This method will verify the action on clicking the 'view Projects' button.
	 * @return void
	 * @param void
	 */
	@Step("action on clicking the view Projects button...")
	public static void clickActionOnViewProjectsButton() {
		SeleniumUtils.waitForElementToBeVisible(viewProjectsForReportButton);
		viewProjectsForReportButton.click();
		log.info("view Projects button is clicked");
	}

	/**
	 * @author Shefali.Garg
	 * @description This method will verify the action on clicking the 'view Invoices' button.
	 * @return void
	 * @param void
	 */
	@Step("action on clicking the view Invoices button...")
	public static void clickActionOnViewInvoicesButton() {
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
		log.info("Enter upload pdf ");
		String uploadfilePath = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
		RobotUtils.uploadFile(uploadfilePath);
		log.info("upload pdf from drive ");
		log.info("Given input while uploading Quotation.");
	}

	@Step("Navigating to invoice page...")
	public static void navigatingToMyInvoices() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(invoicePageLink);
		invoicePageLink.click();
		log.info("Nvaigating to my invoices page");
	}

	@Step("Navigating to invoice page when already logged in...")
	public static void navigatingToMyInvoicesWhenLoggedInAlready() {
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(invoicePageLink);
		invoicePageLink.click();
		log.info("Nvaigating to my invoices page");
	}

	@Step("Technical contact associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval).")
	public static void technicalContactAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Technical Contact Associated is displayed");
	}

	@Step("Additional Technical contact associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval).")
	public static void additionalTechnicalContactAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Additional Technical Contact Associated is displayed");
	}

	@Step("Authorized signatory associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval)")
	public static void authorizedSignatoryAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Technical Contact Associated is displayed");
	}

	@Step("click on the SOW option from the header section")
	public static void clickOnSOWOption() {
		sowSection.click();
		log.info("clicked on the SOW option from the header section");
	}

}
