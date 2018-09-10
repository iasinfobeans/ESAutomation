package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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

	
	@FindBy(xpath = "//div[@class='unpaid-lwa-loading']")
	static WebElement loadingIcon;

	@FindBy(linkText = "Invoices")
	static WebElement invoicePageLink;

	@FindBy(xpath = "//a[@title='SOW']")
	static WebElement sowSection;
	
	@FindBy(xpath = "//*[@id='expiredate']")
	static WebElement checkexpiryDate;
	
	@FindBy(xpath = "//a[@title='Dashboard']")
	static WebElement dashboardLink;
	
	/**
	 *This method will verify dashboard page.
	 * @return void
	 * @param void
	 */
	@Step("verify dashboard page")
	public static void verifyDashboardPage() {
		Assert.assertTrue(dashboardElement.isDisplayed());
		log.info("Dashboard displayed");
	}
	/**
	 * This method will Verify the registration process once correct OTP and other fields are entered and User is on DashboardPage .
	 * @return void
	 * @param void
	 */
	@Step("Verify the registration process once correct OTP and other fields are entered")
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

	/**
	 * This Method will navigate user to change password page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to password change page")
	public static void navigateToChangePasswordPage() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(changePasswordLink);
		Assert.assertTrue(changePasswordLink.isDisplayed());
		changePasswordLink.click();
		log.info("Clicked on change password link");
	}

	/**
	 * This Method will navigate user 
	 * to Edit Profile Page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to Edit Profile page")
	public static void navigateToEditProfilePage() {
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();
		Assert.assertTrue(editProfileLink.isDisplayed());
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}
	
	/**
	 * This Method will navigate a user 
	 * to Edit Profile Page when he was already logged in
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to Edit Profile page when already logged in")
	public static void navigateToEditProfilePageAgain(){
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeVisible(editProfileLink);
		Assert.assertTrue(editProfileLink.isDisplayed());
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}
	/**
	 * This method will Verify User is qualified and all the portal options get available to user.
	 * @return void
	 * @param void
	 */
	@Step("Verify User is qualified and all the portal options get available to user.")
	public static void verifyPortalOptionForQualifiedUser() {

		Assert.assertTrue(quotationOption.isDisplayed());
		log.info("Verify Quotation Option displayed");

		Assert.assertTrue(reportOption.isDisplayed());
		log.info("Verify Report Option displayed");

		Assert.assertTrue(invoicesOption.isDisplayed());
		log.info("Verify Invoices Option displayed");
	}

	/**
	 * This Method will navigate you to Application listings page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to Application Listing page")
	public static void navigateToApplicationListingPage()
	{	
		//SeleniumUtils.refreshPage();   
		SeleniumUtils.waitForElementToBeClickable(applicationListingPageLink);
		//Assert.assertTrue(applicationListingPageLink.isDisplayed());
		applicationListingPageLink.click();
		log.info("Navigated to application page");
	}

	/**
	 * This Method will navigate to Application listing page when logged it.
	 * 
	 * @param void 
	 * @return void
	 */
	@Step("Navigate to Application Listing page when already logged in")
	public static void navigateToApplicationListingPageWhenLoggedIn()
	{
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeClickable(applicationListingPageLink);
		Assert.assertTrue(applicationListingPageLink.isDisplayed());
		applicationListingPageLink.click();
		log.info("Navigated to application page");
	}
	
	/**
	 * This Method will navigate an Approved user 
	 * to PMG Application Program page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to PMG Application Form")
	public static void navigateToPMGApplicationProgramApprovedUser()
	{
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();
		Assert.assertTrue(pmgListingProgramLinkApprovedUser.isDisplayed());
		pmgListingProgramLinkApprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}

	/**
	 * This Method will navigate an Un-approved user 
	 * to PMG Application Program page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to PMG Application Form")
	public static void navigateToPMGApplicationProgramWithNoPopup()
	{
		SeleniumUtils.refreshPage();   
		SeleniumUtils.waitForElementToBeVisible(pmgListingLinkForUnapprovedUser);
		Assert.assertTrue(pmgListingLinkForUnapprovedUser.isDisplayed());
		pmgListingLinkForUnapprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}
	
	/**
	 * Quotation Option is present on the Dash-board for the customer
	 * @param void
	 * @return void
	 */
	@Step("Verify Quotation Option is present")
	public static void verifyQuotationOption() {
		Assert.assertTrue(quotationOption.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", quotationOption);
		log.info("Verify Quotation Option displayed");
	}
	/**
	 * This Method will navigate an Un-approved user 
	 * to PMG Application Program page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to PMG Application Form")
	public static void navigateToPMGApplicationProgram()
	{
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.refreshPage();   
		SeleniumUtils.waitForElementToBeVisible(pmgListingLinkForUnapprovedUser);
		Assert.assertTrue(pmgListingLinkForUnapprovedUser.isDisplayed());
		pmgListingLinkForUnapprovedUser.click();
		log.info("Navigated to PMG Application Form");
	}

	/**
	 * This Method will navigate to Modified users list 
	 * from dashboard
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to modified users listing page")
	public static void navigateToModifiedUsersList(){
		updateProfileRequestsLink.isDisplayed();
		log.info("Update request link present");
		updateProfileRequestsLink.click();
		log.info("Navigated to update profile requests list page");
		Assert.assertTrue(userListingsPageElement.isDisplayed());
		log.info("Verified navigation");
	}

	/**
	 * This method will verify customer Dash-board to have an additional head titled 'Reports.
	 * @return void
	 * @param void
	 */
	@Step("Verify the customer Dashboard to have an additional head titled 'Reports.")
	public static void verifyReportsOption() {
		
		Assert.assertTrue(reportOption.isDisplayed());
		log.info("Verify report Option displayed");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

	/**
	 * This Method will log out from the logged in account
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Log Out")
	public static void logout()
	{
		Assert.assertTrue(myAccountText.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", myAccountText);
		log.info("clicked on main menu");
		
		Assert.assertTrue(logoutLink.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", logoutLink);
		
		log.info("clicked on logout Link");

	}

	/**
	 * This method will verify the actions available on hovering over any report.
	 * @return void
	 * @param void
	 */
	@Step("Mouse hover over any report")
	public static void hoveringOverAnyReport() {
		SeleniumUtils.waitForElementToBeInvisible(loadingIcon);
		SeleniumUtils.waitForElementToBeVisible(reportName);

		Assert.assertTrue(reportName.isDisplayed());
		log.info("Verify report Name displayed");

		SeleniumUtils.mouseHover(reportName);
		log.info("Hover on Report Name");
	}

	/**
	 * This method will verify hovering over any report.
	 * @return void
	 * @param void
	 */
	@Step("Verify actions available on Mouse hover on Report.")
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
	 *This method will verify the action on clicking the 'Pay' button.
	 * @return void
	 * @param void
	 */
	@Step("Click on 'Pay' button")
	public static void clickActionOnPayButton() {
		SeleniumUtils.waitForElementToBeVisible(payForReportButton);
	    Assert.assertTrue(payForReportButton.isDisplayed());
		log.info("pay For Report Button is displayed");
		SeleniumUtils.executeJavaScript("arguments[0].click();", payForReportButton);
		log.info("pay For Report Button is clicked");
	}


	/**
	 * This method will verify the action on clicking the 'view Projects' button.
	 * @return void
	 * @param void
	 */
	@Step("Click on view Projects button")
	public static void clickActionOnViewProjectsButton() {
		SeleniumUtils.waitForElementToBeVisible(viewProjectsForReportButton);

		Assert.assertTrue(viewProjectsForReportButton.isDisplayed());
		log.info("view Projects For Report Button is displayed");

		viewProjectsForReportButton.click();
		log.info("view Projects button is clicked");
	}

	/**
	 * This method will verify the action on clicking the 'view Invoices' button.
	 * @return void
	 * @param void
	 */
	@Step("Click on view Invoices button")
	public static void clickActionOnViewInvoicesButton() {
		SeleniumUtils.waitForElementToBeVisible(viewInvoicesForReportButton);

		Assert.assertTrue(viewInvoicesForReportButton.isDisplayed());
		log.info("view Projects For Report Button is displayed");

		viewInvoicesForReportButton.click();
		log.info("view Invoices button is clicked");
	}
	
    /**
	 * This Method will navigate to Invoice listings page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigating to invoice page...")
	public static void navigatingToMyInvoices() {
		log.info("popup closed");
		SeleniumUtils.refreshPage(); 
		SeleniumUtils.waitForElementToBeVisible(invoicePageLink);
		Assert.assertTrue(invoicePageLink.isDisplayed());
		invoicePageLink.click();
		log.info("Nvaigating to my invoices page");
	}
	
	/**
	 * This Method will navigate to invoice listings page when already logged in
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigating to invoice page when already logged in")
	public static void navigatingToMyInvoicesWhenLoggedInAlready() {
		SeleniumUtils.refreshPage(); 
		SeleniumUtils.waitForElementToBeVisible(invoicePageLink);
		Assert.assertTrue(invoicePageLink.isDisplayed());
		invoicePageLink.click();
		log.info("Navigating to my invoices page");
	}

	/**
	 * This method will verifyTechnical contact associated with the report can see the report at the Dashboard.
	 * under the head 'Reports (Pending Approval).
	 * @return void
	 * @param void
	 */
	@Step("verify technical contact associated with the report can see the report at the Dashboard")
	public static void technicalContactAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Technical Contact Associated is displayed");
	}

	/**
	 * This method will verify Additional Technical contact associated with the report can see the report at the Dashboard
	 * under the head 'Reports (Pending Approval).
	 * @return void
	 * @param void
	 */
	@Step("verify Additional Technical contact associated with the report can see the report at the Dashboard")
	public static void additionalTechnicalContactAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Additional Technical Contact Associated is displayed");
	}

	/**
	 * This method will verify Authorized signatory associated with the report can see the report at the Dashboard
	 * under the head 'Reports (Pending Approval).
	 * @return void
	 * @param void
	 */
	@Step("verify Authorized signatory associated with the report can see the report at the Dashboard")
	public static void authorizedSignatoryAssociatedWithReport() {
		Assert.assertTrue(reportName.isDisplayed());
		log.info("Technical Contact Associated is displayed");
	}

	/**
	 * This method will click on the SOW option from the header section.
	 * @return void
	 * @param void
	 */
	@Step("click on the SOW option")
	public static void clickOnSOWOption() {

		Assert.assertTrue(sowSection.isDisplayed());
		log.info("SOW Section is displayed");

		sowSection.click();
		log.info("clicked on the SOW option from the header section");
	}

	/**
	 * This method will check expiry date while uploading Quotation.
	 */
	@Step("check expiry date..")
	public static void checkExpiryDate() {
		Assert.assertTrue(checkexpiryDate.isDisplayed());
		String date = checkexpiryDate.getAttribute("Value");
		log.info("Expiry date is :"+date);
	}
	
	
	/**
	 * This Method will navigate to Dashboard
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to modified users listing page")
	public static void navigateToDashboard(){
		Assert.assertTrue(dashboardLink.isDisplayed());
		dashboardLink.click();
		log.info("Navigated to dashboard");
	}

}
