package com.es.pom;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.setup.Setup;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class QuotationListingPage {

	private static Logger log = Logger.getLogger(QuotationListingPage.class.getName());

	@FindBy(xpath = "//a[contains(text(),'Get a Quote')]")
	static WebElement getQuoteButton;

	@FindBy(xpath = "//*[@id='quotation-list-dataTable']/thead/tr/th[contains(text(),'View Quotes')]")
	static WebElement viewQuotesBoxForCustomer;

	@FindBy(xpath = "//strong[text()='Active']/ancestor::tr[@role='row']//a[@class='view-quote-popupbox']")
	static WebElement viewQuotesBoxForStaff;

	@FindBy(xpath = "//*[@class='tbl-icon-delete del-quote']")
	static WebElement deleteQuote;

	@FindBy(xpath = "//*[@id='quote_product_type']")
	static WebElement productTypeTextBox;

	@FindBy(xpath = "//*[@id='quote_product_description']")
	static WebElement productDescriptionTextBox;

	@FindBy(xpath = "//*[@id='quote_submit']")
	static WebElement submitQuotationRequest;

	@Step("Verify that a 'Get a Quote' button is present on the Quotation Listing page for the customer...")
	public static void verifyGetAQuoteButton() {
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
		Assert.assertTrue(getQuoteButton.isDisplayed());
		log.info("Get A QuoteButton is displayed");
	}

	@Step("Verify that the customer is able to click on the Get a Quote button...")
	public static void customerClickOnGetAQuoteButton() {
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
		getQuoteButton.click();
		log.info("Verify Customer is able to Click onGet a Quote' button");
	}

	@Step("Click on 'View Quotes' options by staff ...")
	public static void viewQuotesOptions() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForStaff);
		log.info("Verify Staff is able to Click on 'View Quotes' options");
	}
	
	@Step("Click on 'View Quotes' options by Customer ...")
	public static void viewQuotesTab() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForCustomer);
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForCustomer);
		log.info("Verify Customer is able to Click on 'View Quotes' options");
		}

	@Step("Click on delete quote by Staff ...")
	public static void deleteQuoteByStaff() {
		try {
			SeleniumUtils.executeJavaScript("arguments[0].click();", deleteQuote);
			//deleteQuote.click();
		} catch (Exception e) {
			SeleniumUtils.acceptPopup();
			log.info("Verify Staff is able to delete Quote.");
		}

	}

	@Step("Input for Product Type ...")
	public static void inputForProductType(String prodType) {
		SeleniumUtils.waitForElementToBeVisible(productTypeTextBox);
		productTypeTextBox.clear();
		productTypeTextBox.sendKeys(prodType);
		log.info("Input given for Product Type.");
	}


	@Step("Input for Product Description for get Quotation ...")
	public static void inputForProductDescription(String prodDescription) {
		SeleniumUtils.waitForElementToBeVisible(productDescriptionTextBox);
		productDescriptionTextBox.clear();
		productDescriptionTextBox.sendKeys(prodDescription);
		log.info("Input given Product Description for get Quotation.");
	}

	@Step("Submitting Quotation Request ...")
	public static void submitQuotationRequest() {
		SeleniumUtils.waitForElementToBeVisible(submitQuotationRequest);
		submitQuotationRequest.click();
		log.info("Submitted Quotation Request.");
	}

	@Step("Verifying status in Status column...")
	public static void verifyDifferentStatus() {
		List<WebElement> rows = Setup.driver.findElements(By.cssSelector("tbody > tr"));
	    for(WebElement row : rows){
	        if(row.findElement(By.cssSelector("td:nth-of-type(3)")).getText().equals("Active")  ){
	            log.info("'Active' Status of Quotes found in Status Coloumn.");
	        }else if(row.findElement(By.cssSelector("td:nth-of-type(3)")).getText().equals("Expired")) {
	        	log.info("'Expired' Status of Quotes found in Status Coloumn.");
	        }
	    }
	}
}
