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

	
	@Step("verify dashboard page Step...")
	public static void verifyDashboardPage()
	{
		Assert.assertTrue(dashboardElement.isDisplayed());
		log.info("Dashboard displayed");
	}

	@Step("redicting to password change page...")
	public static void navigateToChangePasswordPage()
	{
		changePasswordLink.click();
		log.info("Clicked on change password link");

	}

	   }