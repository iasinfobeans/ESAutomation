package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.setup.Driver;
import io.qameta.allure.Step;

public class DashboardPage {

	private static Logger log = Logger.getLogger(Driver.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement dashboardElement;

	@FindBy(linkText="Change Password")
	static WebElement changePasswordLink;

	@FindBy(xpath="//a[@programslug='esr']")
	static WebElement applyESRElement;

	@FindBy(xpath="//a[@programslug='pmg']")
	static WebElement applyPMGElement;

	@FindBy(xpath="//a[@programslug='esl']")
	static WebElement applyESLElement;

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

	@Step("verify dashboard page for ER Step...")
	public static void verifyDashboardPageforER() {
		applyESRElement.click();
		log.info("Apply on DashboardPage is Displayed for ER ");


	}

	@Step("verify dashboard page for PMG Step...")
	public static void verifyDashboardPageforPMG()	{
		applyPMGElement.click();
		log.info("apply on DashboardPage is Displayed for PMG");
	}		

	@Step("verify dashboard page for ESL Step...")
	public static void verifyDashboardPageforESL() {
		applyESLElement.click();
		log.info("apply on DashboardPage is Displayed for ESL");
	}
}