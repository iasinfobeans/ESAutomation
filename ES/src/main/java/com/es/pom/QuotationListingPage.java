package com.es.pom;

import java.util.List;

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
	
	//*[@id='quotation-list-dataTable']/tbody/tr/td/a

	@FindBy(xpath = "//*[@class='odd parent']/td[@class='sorting_1']")
	static WebElement clickonQuoteForDelete;
	
	@FindBy(xpath = "//*[@class='tbl-icon-delete del-quote']")
	static WebElement deleteQuote;

	@FindBy(xpath = "//*[@id='quote_product_type']")
	static WebElement productTypeTextBox;

	@FindBy(xpath = "//*[@id='quote_product_description']")
	static WebElement productDescriptionTextBox;

	@FindBy(xpath = "//*[@id='quote_submit']")
	static WebElement submitQuotationRequest;
	
	@FindBy(xpath = "//*[@id='doc_cat_quotes']/table/tbody")
	static WebElement fileUploaded;
	
	@FindBy(xpath = "//*[@id='quotation-span-msg']/span/ul/li")
	static WebElement quotationUploaded;

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

	/**
	 * This method will click on view quotes link uploaded by staff.
	 */
	@Step("Clicking on 'View Quotes' options...")
	public static void viewQuotesOptions() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForStaff);
		log.info("Verify Staff is able to Click on 'View Quotes' options");
	}

	/*@Step("Click on 'View Quotes' options by Customer ...")
	public static void viewQuotesTab() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForCustomer);
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForCustomer);
		log.info("Verify Customer is able to Click on 'View Quotes' options");
	}*/

	/**
	 * This method will delete the quotation uploaded by staff. 
	 */
	@Step("Click on delete quote by Staff ...")
	public static void deleteQuoteByStaff() {

		// SeleniumUtils.executeJavaScript("arguments[0].click();",
		// clickonQuoteForDelete);
		SeleniumUtils.executeJavaScript("arguments[0].click();", deleteQuote);
		SeleniumUtils.acceptPopup();
		log.info("Verify Staff is able to delete Quote.");
	}

	/**
	 * This method will give product Type while request for quotation.
	 * @param prodType
	 * @return void
	 */
	@Step("Input for Product Type ...")
	public static void inputForProductType(String prodType) {
		SeleniumUtils.waitForElementToBeVisible(productTypeTextBox);
		productTypeTextBox.clear();
		productTypeTextBox.sendKeys(prodType);
		log.info("Input given for Product Type.");
	}

	/**
	 * This method will give product description while request for quotation.
	 * @param prodDescription
	 * @return void
	 */
	@Step("Input for Product Description for get Quotation ...")
	public static void inputForProductDescription(String prodDescription) {
		SeleniumUtils.waitForElementToBeVisible(productDescriptionTextBox);
		productDescriptionTextBox.clear();
		productDescriptionTextBox.sendKeys(prodDescription);
		log.info("Input given Product Description for get Quotation.");
	}

	/**
	 * This method will submit Quotation Request.
	 */
	@Step("Submitting Quotation Request ...")
	public static void submitQuotationRequest() {
		SeleniumUtils.waitForElementToBeVisible(submitQuotationRequest);
		submitQuotationRequest.click();
		log.info("Submitted Quotation Request.");
	}

	/**
	 * This method will verify statuses in Status column.
	 */
	@Step("Verifying status in Status column...")
	public static void verifyDifferentStatus() {
		List<WebElement> rows = Setup.driver.findElements(By.cssSelector("tbody > tr"));
		for (WebElement row : rows) {
			if (row.findElement(By.cssSelector("td:nth-of-type(3)")).getText().equals("Active")) {
				log.info("'Active' Status of Quotes found in Status Coloumn.");
			} else if (row.findElement(By.cssSelector("td:nth-of-type(3)")).getText().equals("Expired")) {
				log.info("'Expired' Status of Quotes found in Status Coloumn.");
			}
		}
	}

	/**
	 * This method will verify whether file is uploaded or not.
	 */
	@Step("Verifying whether file is uploaded or not...")
	public static void verifyFileUploadedOrNot() {
		SeleniumUtils.waitForElementToBeVisible(fileUploaded);
		Assert.assertTrue(fileUploaded.isDisplayed());
		log.info("File uploaded successfully.");
	}

	/**
	 * This method will verify whether Quotation is uploaded or not.
	 */
	@Step("Verifying whether Quotation is uploaded or not...")
	public static void verifyQuotationUploaded() {
		SeleniumUtils.waitForElementToBeVisible(quotationUploaded);
		Assert.assertTrue(quotationUploaded.isDisplayed());
		log.info("Quotation uploaded successfully.");
	}
}
