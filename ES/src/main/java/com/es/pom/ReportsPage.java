package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class ReportsPage {
	private static Logger log = Logger.getLogger(ReportsPage.class.getName());

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement reportsElement;

	@FindBy(xpath = "//*[@id='programReportsTable']/tbody/tr/td/a/parent::td/following-sibling::td/a")
	static WebElement viewReportOption;

	/**
	 * This method will verify Dash-board to have an additional head titled 'Reports'..
	 * @return void
	 * @param void
	 */
	@Step("Dashboard to have an additional head titled 'Reports.")
	public static void verifyTitleReports() {
		Assert.assertTrue(reportsElement.isDisplayed());
		log.info("Reports is displayed on Dashboard");
	}

	@Step(" Navigate to Project listing page")
	public static void navigateToProjectListingPage() {
		viewReportOption.click();
		log.info(" Navigate to Project listing page");
	}
}
