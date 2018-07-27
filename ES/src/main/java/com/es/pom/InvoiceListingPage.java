package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;

public class InvoiceListingPage {
	private static Logger log = Logger.getLogger(InvoiceListingPage.class.getName());

	@FindBy(xpath="//div[@class='ehading']")
	static WebElement invoicessElement;

	@Step("Dashboard to have an additional head titled 'Reports.")
	public static void verifyViewInvoicesPage(){
		Assert.assertTrue(invoicessElement.isDisplayed());
		log.info("verify View Invoices Page");
	}	

}
