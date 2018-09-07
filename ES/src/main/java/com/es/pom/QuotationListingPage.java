package com.es.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.setup.Setup;
import com.es.util.CommonUtils;
import com.es.util.RobotUtils;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class QuotationListingPage {

	private static Logger log = Logger.getLogger(QuotationListingPage.class.getName());

	@FindBy(xpath = "//a[contains(text(),'Get a Quote')]")
	static WebElement getQuoteButton;

	@FindBy(xpath = "//a[contains(text(),'All Status')]")
	static WebElement statusOfQuotes;

	@FindBy(xpath = "//a[contains(text(),'Active')]")
	static WebElement activeQuotes;

	@FindBy(xpath = "//a[contains(text(),'Expired')]")
	static WebElement ExpiredQuotes;

	@FindBy(xpath = "//*[@id='quotation-list-dataTable']/thead/tr/th[contains(text(),'View Quotes')]")
	static WebElement viewQuotesBoxForCustomer;

	@FindBy(xpath = "//strong[text()='Active']/ancestor::tr[@role='row']//a[@class='view-quote-popupbox']")
	static WebElement viewActiveQuotesBox;

	@FindBy(xpath = "//*[@id='quotation-list-dataTable']//a[@class='view-quote-popupbox']")
	static WebElement viewExpiredQuotesBox;

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

	@FindBy(linkText = "View")
	static WebElement viewLink;

	@FindBy(linkText = "Upload")
	static WebElement upload;

	@FindBy(xpath = "//*[contains(text(),'Quotation Request :')]")
	static WebElement quotationRequest;

	@FindBy(xpath = "//*[text()='Requested By: ']")
	static WebElement requestedBy;

	@FindBy(xpath = "//*[text()='Company Name: ']")
	static WebElement companyName;

	@FindBy(xpath = "//*[text()='Email: ']")
	static WebElement email;

	@FindBy(xpath = "//*[text()='Phone: ']")
	static WebElement phone;

	@FindBy(xpath = "//*[text()='Contact Preference: ']")
	static WebElement contactReference;

	@FindBy(xpath = "//*[text()='Address: ']")
	static WebElement address;

	@FindBy(xpath = "//*[text()='City: ']")
	static WebElement city;

	@FindBy(xpath = "//*[text()='State: ']")
	static WebElement state;

	@FindBy(xpath = "//*[text()='Country: ']")
	static WebElement country;

	@FindBy(xpath = "//*[text()='Product Type: ']")
	static WebElement productType;

	@FindBy(xpath = "//*[text()='Product Description: ']")
	static WebElement ProductDescription;

	@FindBy(xpath = "//*[@value='Close']")
	static WebElement close;

	@FindBy(xpath = "//*[contains(text(),'Send Quotation for ')]")
	static WebElement sendQuotation;

	@FindBy(xpath = "//*[@name='program_type']/following-sibling::div")
	static WebElement dropDownInUploadQuotation;

	@FindBy(xpath = "//*[@id='quotes-document']")
	static WebElement uploadButton;

	@FindBy(xpath = "//*[@id='amountDiv']")
	static WebElement amountField;

	@FindBy(xpath = "//*[@id='quote_amount']")
	static WebElement amountTextBox;

	@FindBy(xpath = "//*[@id='expireDateDiv']")
	static WebElement expireDate;

	@FindBy(xpath = "other_amount")
	static WebElement amountForBasicFees;

	@FindBy(xpath = "//*[@id='expiredate']")
	static WebElement expireDateValue;

	@FindBy(xpath = "//span[contains(text(),'Previous')]")
	static WebElement  previousDate;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")
	static WebElement previousDateOfExpiration;

	@FindBy(xpath = "//*[@id='upload_quote']")
	static WebElement send;

	@FindBy(xpath = "//*[@name='cancel_quote']")
	static WebElement cancelQuote;

	@FindBy(linkText = "ES Core")
	static WebElement esCore;

	@FindBy(linkText = "Plumbing Mechanical and Gas")
	static WebElement plumbingMechanicAndGas;

	@FindBy(linkText = "Evaluation Service Listing")
	static WebElement evaluationServiceListing;

	@FindBy(xpath = "//*[@id='quotation-list-dataTable_filter']/label/input")
	static WebElement expiredQuotation;
	
	@FindBy(xpath = "//*[@id='view-quotes-dataTable']/tbody/tr/td/a")
	static WebElement quotationDownloaded;
	
	@FindBy(xpath = "//strong[text()='Active']/ancestor::tr[@role='row']//a[@class='view-quote-popupbox']")
	static WebElement viewQuotesBoxForStaff;
	
    @FindBy(xpath="//div[@id='app-list-dataTable_processing']")
	static WebElement processingTableElement;
    
    @FindBy(xpath = "//strong[text()='Expired']/ancestor::tr[@role='row']//a[@class='view-quote-popupbox']")
	static WebElement viewQuotesBoxForExpired;
    
  @FindBy(xpath = "//strong[contains(text(),'Expired')]")
	static WebElement statusSavedApplication;


	/**
	 * This method will verify'Get a Quote' button is present on the Quotation Listing page for the customer.
	 * @return void
	 * @param void
	 */
	@Step("Verify 'Get a Quote' button on the Quotation Listing page")
	public static void verifyGetAQuoteButton() {
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
		Assert.assertTrue(getQuoteButton.isDisplayed());
		log.info("Get A QuoteButton is displayed");
	}
	
	/**
	 * This method will verify that the customer is able to click on the Get a Quote button.
	 * @return void
	 * @param void
	 */
	@Step("Verify that the customer is able to click on the Get a Quote button")
	public static void clickOnGetAQuoteButton() {
		SeleniumUtils.waitForElementToBeVisible(getQuoteButton);
		Assert.assertTrue(getQuoteButton.isDisplayed());
		getQuoteButton.click();
		log.info("Verify Customer is able to Click onGet a Quote' button");
	}

	/**
	 * This method will click on view quotes link for Active quotes uploaded by staff.
	 * @return void
	 * @param void
	 */
	@Step("Verify click on Active Quotes")
	public static void viewQuotesOptions() {
		SeleniumUtils.waitForElementToBeVisible(viewQuotesBoxForStaff);
		Assert.assertTrue(viewQuotesBoxForStaff.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForStaff);
		log.info("Verify Staff is able to Click on 'View Quotes' options");
	}

	/**
	 * This method will click on view quotes for Expired quotes link uploaded by staff.
	 * @return void
	 * @param void
	 */
	@Step("Verify click on Expired Quotes")
	public static void viewExpiredQuotesOptions() {
		SeleniumUtils.waitForElementToBeVisible(viewExpiredQuotesBox);
		SeleniumUtils.waitForElementToBeClickable(viewExpiredQuotesBox);
		Assert.assertTrue(viewExpiredQuotesBox.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewExpiredQuotesBox);
		log.info("Verify Staff is able to Click on 'View Quotes' options");
	}

	/**
	 * 
	 *This method will verify Click on View Button.
	 * @return void
	 * @param void
	 */
	@Step("Click on View Button")
	public static void verifyViewOption() {
		Assert.assertTrue(viewLink.isDisplayed());
		viewLink.click();
		log.info("Verify View option displayed");
	}

	/**
	 * This method would Verifying Upload option.
	 * @return void
	 * @param void
	 */
	@Step("Verify Upload option")
	public static void verifyUploadOption() {
		Assert.assertTrue(upload.isDisplayed());
		upload.click();
		log.info("Verify Upload option displayed");
	}

	/**
	 * This method will verify Active Status of Quote.
	 * @return void
	 * @param void
	 */
	@Step("Click on Active Status of Quote")
	public static void viewActiveStatusofQuote() {
		Assert.assertTrue(statusOfQuotes.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();",statusOfQuotes );
		log.info("Customer is able to Click on 'status Of Quotes' options");
		
		SeleniumUtils.executeJavaScript("arguments[0].click();",activeQuotes );
		log.info("Customer is able to Click on 'active Quotes' options");

	}

	/**
	 * This method will verify Expired Status of Quote.
	 * @return void
	 * @param void
	 */
	@Step("Click on Expired Status of Quote")
	public static void viewExpiredStatusofQuote() {
		Assert.assertTrue(statusOfQuotes.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();",statusOfQuotes );
		log.info("Customer is able to Click on 'status Of Quotes' options");

		SeleniumUtils.executeJavaScript("arguments[0].click();",ExpiredQuotes );
		log.info("Customer is able to Click on 'Expired Quotes' options");


	}

	/**
	 * 
	 * This method will verify Click on 'View Quotes' options by Customer.
	 * @return void
	 * @param void
	 */
	@Step("Click on 'View Quotes' option")
	public static void viewQuotesTab() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForCustomer);
		log.info("Verify Customer is able to Click on 'View Quotes' options");
	}


	/**
	 * 
	 *This method will verify quotation Request.
	 * @return void
	 * @param void
	 */
	@Step("Verify quotation Request")
	public static void verifyQuotationRequest() {
		Assert.assertTrue(quotationRequest.isDisplayed());
		log.info("Verify quotation Request");
	}
	
	/**
	 * 
	 *This method will verify Observe Pop up Window.
	 * @return void
	 * @param void
	 */
	@Step("Verify Observe Pop up Window")
	public static void verifyPopUpWindowForView() {
		Assert.assertTrue(quotationRequest.isDisplayed());
		Assert.assertTrue(requestedBy.isDisplayed());
		Assert.assertTrue(companyName.isDisplayed());
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(contactReference.isDisplayed());
		Assert.assertTrue(address.isDisplayed());
		Assert.assertTrue(city.isDisplayed());
		Assert.assertTrue(state.isDisplayed());
		Assert.assertTrue(country.isDisplayed());
		Assert.assertTrue(productType.isDisplayed());
		Assert.assertTrue(ProductDescription.isDisplayed());
		Assert.assertTrue(close.isDisplayed());
		log.info("Verified Pop up Window and parameters on it for view option.");

	}

	/**
	 * 
	 *This method will verify Observe Pop up Window for Upload option.
	 * @return void
	 * @param void
	 */
	@Step("Verify Observe Pop up Window for Upload option")
	public static void verifyPopUpWindowForUpload() {
		SeleniumUtils.waitForElementToBeVisible(sendQuotation);
		Assert.assertTrue(sendQuotation.isDisplayed());
		SeleniumUtils.waitForElementToBeVisible(dropDownInUploadQuotation);
		Assert.assertTrue(dropDownInUploadQuotation.isDisplayed());
		Assert.assertTrue(uploadButton.isDisplayed());
		Assert.assertTrue(amountField.isDisplayed());
		Assert.assertTrue(expireDate.isDisplayed());
		Assert.assertTrue(send.isDisplayed());
		Assert.assertTrue(cancelQuote.isDisplayed());
		log.info("Verified Pop up Window and parameters on it for upload option.");

	}
	/**
	 * This method will verify click on send button . 
	 * @return void
	 * @param void
	 * 
	 */
	@Step("Verify click on send button")
	public static void clickSendWhileUploadingQuotation() {
		Assert.assertTrue(send.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", send);
		log.info("clicked on send button while uploading Quotation.");
	}
	/**
	 * This method will verify Input valid values while upload Quotation. 
	 * @param  progarmType
	 * @param amount
	 * @return void
	 */
	@Step("Input valid values while upload Quotation")
	public static void inputValuesInUploadOption(String progarmType, String amount) {
		dropDownInUploadQuotation.click();
		if (progarmType.equalsIgnoreCase("ES Core")) {
			esCore.click();
		}
		if (progarmType.equalsIgnoreCase("plumbingMechanicAndGas")) {
			plumbingMechanicAndGas.click();
		}
		if (progarmType.equalsIgnoreCase("Evaluation Service Listing")) {
			evaluationServiceListing.click();
			log.info("Enter program Type for Quotation");

		}

		amountTextBox.sendKeys(amount);
		log.info("Enter the amount to pay for Quotation");

		uploadButton.click();
		log.info("Enter upload pdf ");
		String uploadfilePath = System.getProperty("user.dir")+ "\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
		RobotUtils.uploadFile(uploadfilePath);
		log.info("upload pdf from drive ");
		log.info("Given input while uploading Quotation.");
	}


	/**
	 * This method will delete the quotation uploaded by staff. 
	 * @return void
	 * @param void
	 */
	@Step("Verify click on delete quote by Staff")
	public static void deleteQuoteByStaff() {
		SeleniumUtils.executeJavaScript("arguments[0].click();", deleteQuote);
		SeleniumUtils.acceptPopup();
		log.info("Verify Staff is able to delete Quote.");
	}



	/**
	 * This method will verify statuses in Status column.
	 * @return void
	 * @param void
	 */
	@Step("Verify status in Status column")
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
	 * This method will verify status Saved Application in Status column.
	 * @return void
	 * @param void
	 */
	@Step("Verify status in Status column")
	public static void verifyStatus() {
		
		SeleniumUtils.waitForElementToBeVisible(statusSavedApplication);
		Assert.assertTrue(statusSavedApplication.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", statusSavedApplication);
		}
	

	/**
	 * This method will verify whether file is uploaded or not.
	 * @return void
	 * @param void
	 */
	@Step("Verify whether file is uploaded")
	public static void verifyFileUploadedOrNot() {
		SeleniumUtils.waitForElementToBeVisible(fileUploaded);
		Assert.assertTrue(fileUploaded.isDisplayed());
		log.info("File uploaded successfully.");
	}

	/**
	 * This method will verify whether Quotation is uploaded or not.
	 *  @param void 
	 *  @return void
	 * 
	 */
	@Step("Verify whether Quotation is uploaded")
	public static void verifyQuotationUploaded() {
		SeleniumUtils.waitForElementToBeVisible(quotationUploaded);
		Assert.assertTrue(quotationUploaded.isDisplayed());
		log.info("Quotation uploaded successfully");
	}

	/**
	 * 
	 * This Method will verify that the Expiry date is a mandatory 
	 * field & it  is defaulted with a date 30 days ahead from the current date
	 * @param void 
	 * @return void
	 */
	@Step("Check Expiry date is a mandatory field & it is defaulted with a date 30 days ahead from the current date")
	public static void checkExpiryDateDefaultedWithThirtyDaysAhead() {

		String newDate = CommonUtils.getDateAddedThirtyDaysToCurrentDate();
		if(expireDateValue.getAttribute("value").equals(newDate)) {
			log.info("Expiry date is 30 days ahead from the current date");
		}else {
			log.info("Expiry date is not 30 days ahead from the current date");

		}
	}

	/**
	 *
	 * This Method will verify Staff has send the quote before the expiration date.
	 * @param progarmType
	 * @param amount
	 * @param fileCount
	 * @return void
	 */

	@Step("Staff has send the quote before the expiration date.")
	public static void quoteBeforeExpirationDate(String progarmType, String amount) {
		Assert.assertTrue(upload.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", upload);
		log.info("Verify Upload option displayed");
		{
			dropDownInUploadQuotation.click();
			if (progarmType.equalsIgnoreCase("ES Core")) {
				esCore.click();
			}
			if (progarmType.equalsIgnoreCase("plumbingMechanicAndGas")) {
				plumbingMechanicAndGas.click();
			}
			if (progarmType.equalsIgnoreCase("Evaluation Service Listing")) {
				evaluationServiceListing.click();
			}

			amountTextBox.sendKeys(amount);
			log.info("Enter the amount to pay for Quotation");

			uploadButton.click();
			log.info("Enter upload pdf ");
			String uploadfilePath = System.getProperty("user.dir")+ "\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
			RobotUtils.uploadFile(uploadfilePath);
			log.info("upload pdf from drive ");
			log.info("Given input while uploading Quotation.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			expireDateValue.click();
			log.info("Enter expire Date Value");

			previousDate.click();
			log.info("Choose previous Date for Quote ");

			previousDateOfExpiration.click();
			log.info("Choose previous Date for Quote Expiration");


			SeleniumUtils.waitForElementToBeVisible(send);
			Assert.assertTrue(send.isDisplayed());
			send.click();
			log.info("clicked on send button while uploading Quotation.");
		}
	}

	/**
	 * 
	 * This Method will verify expired Quotation Number Entered on Available Quotes.
	 * @param  expiredQuotationNumber
	 * @return void
	 */
	@Step("Verify expired Quotation Number")
	public static void expiredQuotationNumber(String expiredQuotationNumber) {

		expiredQuotation.clear();
		expiredQuotation.sendKeys(expiredQuotationNumber);
		log.info("Enter expired Quotation Number: "+expiredQuotationNumber);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will download quotation.
	 * @param  void
	 * @return void
	 */
     public static void downloadQuote() {
		Assert.assertTrue(quotationDownloaded.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", quotationDownloaded);
		log.info("Verify Staff is able to Click on 'View Quotes' options");
	}
	
	/**
	 * This method will click on view quotes of expired quotation.
	 * @param  void
	 * @return void
	 */
	public static void viewQuotesOptionsForExpiredQuotes() {
		Assert.assertTrue(viewQuotesBoxForExpired.isDisplayed());
		SeleniumUtils.executeJavaScript("arguments[0].click();", viewQuotesBoxForExpired);
		log.info("Verify Staff is able to Click on 'View Quotes' options for expired Quote");
	}
}
