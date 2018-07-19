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
		log.info("Nvaigated to Edit profile page");
		log.info("popup arrived");
		SeleniumUtils.waitForElementToBeVisible(popupWindow);
		popupWindow.click();
		log.info("popup closed");
		SeleniumUtils.scrollToBottom();
		SeleniumUtils.refreshPage();   
		editProfileLink.click();
		log.info("Navigated to edit profile page");
	}

}