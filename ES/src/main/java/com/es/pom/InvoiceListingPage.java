package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class InvoiceListingPage {

	private static Logger log = Logger.getLogger(InvoiceListingPage.class.getName());

	@FindBy(xpath = "//span[@class='message notices alert']//ul//li")
	static WebElement messageNoticeAlert;

	@FindBy(xpath = "//th[@tabindex='0']")
	static WebElement elementsToWaitForReload;

	@FindBy(linkText = "All Status")
	static WebElement sortingDropdown;

	@FindBy(linkText = "Partial")
	static WebElement partialSort;

	@FindBy(linkText = "Pay")
	static WebElement paymentPageLink;

	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement invoicessElement;

	/**
	 * This Method will verify navigation to invoice listing page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify user is on invoice listing page")
	public static void verifyViewInvoicesPage(){
		Assert.assertTrue(invoicessElement.isDisplayed());
		log.info("verify View Invoices Page");
	}

	/**
	 * This Method will navigate to payment page
	 * from Invoice-Listings Page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to Payment Page from Invoice-Listings Page")
	public static void navigateToPaymentPage(){
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeClickable(sortingDropdown);
		Assert.assertTrue(sortingDropdown.isDisplayed());
		sortingDropdown.click();
		log.info("Sorting selected");
		SeleniumUtils.waitForElementToBeClickable(partialSort);
		partialSort.click();
		log.info("partially sorted");
		paymentPageLink.click();
		log.info("Payment page");
	}
}