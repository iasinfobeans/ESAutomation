package com.es.pom;

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
<<<<<<< HEAD
	
	@FindBy(xpath="//a[@title='Applications']")
	static WebElement applicationPageLink;
	
=======

>>>>>>> branch 'master' of https://github.com/iasinfobeans/ESAutomation.git
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
}