package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyProfilePage {

	private static Logger log = Logger.getLogger(MyProfilePage.class.getName());

	@FindBy(xpath="//*[@title=\"Quotations\"]")
	static WebElement quotationOption;

	@FindBy(xpath="//*[@title=\"Reports\"]")
	static WebElement reportOption;


	@FindBy(xpath="//*[@title=\"Invoices\"]")
	static WebElement invoicesOption;

	public static void portalOptionForQualifiedUser() {

		Assert.assertTrue(quotationOption.isDisplayed());
		log.info("Verify Quotation Option displayed");

		Assert.assertTrue(reportOption.isDisplayed());
		log.info("Verify Report Option displayed");

		Assert.assertTrue(invoicesOption.isDisplayed());
		log.info("Verify Invoices Option displayed");
	}

}	 





