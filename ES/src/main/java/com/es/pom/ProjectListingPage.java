package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class ProjectListingPage {

	private static Logger log = Logger.getLogger(ProjectListingPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement projectsElement;

	@FindBy(xpath="//*[@id='projectTable']//a[contains(text(),'View SOW')]")
	static WebElement viewSOWOption;

	@Step("Dashboard to have an additional head titled 'Reports.")
	public static void verifyViewProjectsPage(){
		Assert.assertTrue(projectsElement.isDisplayed());
		log.info("Reports is displayed on Dashboard");
	}	

	@Step("Click on view SOW to be Download")
	public static void navigateToProjectListingPage() {
		viewSOWOption.click();
		log.info("View SOW to be Download");
	}

}