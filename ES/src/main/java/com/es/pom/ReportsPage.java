package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class ReportsPage {
	private static Logger log = Logger.getLogger(ReportsPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement reportsElement;

	@Step("Dashboard to have an additional head titled 'Reports.")
	public static void verifyTitleReport(){
		Assert.assertTrue(reportsElement.isDisplayed());
		log.info("Reports is displayed on Dashboard");
	}	
}
