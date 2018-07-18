package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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

	@Step("redicting to password change page...")
	public static void navigateToChangePasswordPage()
	{
		changePasswordLink.click();
		log.info("Clicked on change password link");

	}

}