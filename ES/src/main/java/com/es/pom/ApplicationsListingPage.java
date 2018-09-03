package com.es.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;
import com.es.util.SeleniumUtils;

public class ApplicationsListingPage {

	private static Logger log = Logger.getLogger(ApplicationsListingPage.class.getName());

	@FindBy(id = "applicationType")
	static WebElement verifyRegisterfromER;

	@FindBy(id = "applicationType")
	static WebElement verifyRegisterfromPMG;

	@FindBy(id = "applicationType")
	static WebElement verifyRegisterfromESL;

	@FindBy(xpath = "//strong[text()='Pending Review']/ancestor::td/following-sibling::td[1][not(text()='Renewal')]")
	static List<WebElement> pendingReviewExcludeRenewalType;

	@FindBy(xpath = "//strong[text()='Pending Review']/ancestor::tr[@role='row']//a[text()='Edit']")
	static List<WebElement> pendingReviewEditActionButtons;

	@FindBy(xpath = "//a[text()='Edit']")
	static WebElement editApplicationLink;

	@FindBy(xpath = "//*[@id='app-list-dataTable']//tr[./td[.='PMG']][./td[.='Renewal']]/td[.=' Download ']")
	static WebElement downloadOption;

	@FindBy(xpath = "//a[contains(text(),'view')]")
	static WebElement viewOption;

	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	static WebElement editOption;

	@FindBy(xpath = "")
	static WebElement assignProjectNumberOption;

	@FindBy(linkText = "All Applications")
	static WebElement sortingDropdown;
	
	@FindBy(linkText="All Status")
	static WebElement applicationStatusDropdown;
	
	@FindBy(linkText = "New")
	static WebElement newSort;

	@FindBy(linkText = "Renewal")
	static WebElement renewalSort;

	@FindBy(linkText = "Pay")
	static WebElement paymentPageLink;

	@FindBy(xpath = "//th[@tabindex='0']")
	static WebElement elementsToWaitForReload;
	
	//@FindBy(xpath="//a[@id='sbToggle_58028408']")
	//static WebElement applicationStatusDropdown;
	
	@FindBy(xpath="//div[@id='app-list-dataTable_processing']")
	static WebElement processingTableElement;
	
	@FindBy(xpath="//input[@type='search']")
	static WebElement textboxToSearchApplication;
	
	@FindBy(linkText="Pending Signature")
	static WebElement applicationStatusPendingSignature;
	
	@FindBy(linkText="Draft")
	static WebElement applicationStatusDraft;
	
	@FindBy(xpath="//th[@aria-label=' Application ID: activate to sort column ascending']")
	static WebElement applicationIdTableHeading;
	
	@FindBy(linkText="Pending Review")
	static WebElement applicationStatusPendingReview;
	
	@FindBy(xpath="//div[@class='sbHolder']//a[contains(text(),'10')]")
	static WebElement entriesVisibleDropdown;
	
	@FindBy(xpath="//li//a[text()='100']")
	static WebElement entriesVisibleHundred;
	
	@FindBy(xpath="//a[@action='recallApplicationAction']")
	static WebElement recallApplicationLink;
	
	@FindBy(xpath="//strong[text()='Draft']")
	static List<WebElement> draftApplications;
	
	@FindBy(xpath="//td[@tabindex='0']")
	static WebElement applicationId;
	
	@FindBy(linkText = "Delete")
	static WebElement deleteApplicationFromDraft;
	
	@FindBy(xpath="//strong[text()='Pending Review']")
	static WebElement statusPendingReview;
	
	static int numberOfDraftApplications;
	static int numberOfDraftApplicationAfterRecallApplication;
	static String appId;

	@Step("verify Application page for ER Step...")
	public static void verifyApplicationPageForER(){
		Assert.assertTrue(verifyRegisterfromER.isDisplayed());
		log.info("Verify Register from ER displayed");
	}
 
	/**
	 * This method would verify Application page for PMG .
	 * @return void
	 * @param void
	 */
	@Step("verify User is on Application Page for PMG")
	public static void verifyApplicationPageForPMG() {
		Assert.assertTrue(verifyRegisterfromPMG.isDisplayed());
		log.info("Verify Register from PMG displayed");

	}

	@Step("verify Application page for ESL Step")
	public static void verifyApplicationPageForESL() {
		Assert.assertTrue(verifyRegisterfromESL.isDisplayed());
		log.info("Verify Register from ESL displayed");
	}

	/**
	 * This Method will verify that "Edit" Option is present
	 * in applications of status "Pending Review"
	 * 
	 * @param void 
	 * @return void
	 */
	@Step("Verify Edit option is present in pending review")
	public static void checkEditOptionInPendingReviewApp() {
		log.info("On application page verifying edit option for pending review");
		if(pendingReviewExcludeRenewalType.size()==pendingReviewEditActionButtons.size()) {
			log.info("All Edit Action Buttons are found for Pending Review Status");
		}else {
			log.info("All Edit Action Buttons are not found for Pending Review Status");
		}
	}

	/**
	 * This Method will verify that "Edit" Option is present
	 * in applications of status "Pending Review"
	 * 
	 * @param void 
	 * @return void
	 */
	@Step("Verify Edit option is present in pending review")
	public static void checkEditOptionForAGivenApplication(String appId) {
		textboxToSearchApplication.clear();
		textboxToSearchApplication.sendKeys(appId);
		SeleniumUtils.waitForElementToContainsAttributeValue(processingTableElement, "style", "display: none;" );
		Assert.assertTrue(editApplicationLink.isDisplayed());
		log.info("Staff can review the Appliction");
		editApplicationLink.click();
		log.info("Clicked on edit");
	}
	
	/**
	 * This Method will navigate you to the Edit Application
	 * Page.
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigated to Edit Application Page")
	public static void navigateToEditApplicationPage(String appId) {
		SeleniumUtils.waitForElementToBeClickable(applicationStatusDropdown);
		Assert.assertTrue(applicationStatusDropdown.isDisplayed());
		applicationStatusDropdown.click();
		log.info("dropdown for application status");
		applicationStatusPendingReview.click();
		entriesVisibleDropdown.click();
		log.info("entreies dropdown visible");
		SeleniumUtils.waitForElementToBeVisible(entriesVisibleHundred);
		entriesVisibleHundred.click();
		log.info("100 entries selected");
		textboxToSearchApplication.clear();
		textboxToSearchApplication.sendKeys(appId);
		SeleniumUtils.waitForElementToContainsAttributeValue(processingTableElement, "style", "display: none;" );
		editApplicationLink.click();
		log.info("navigated to edit application page");
		}

	/**
	 * This method will verify that On newly created applications,
	 * user should not be able to perform predefined operations like edit/view/delete/recall.
	 * @return void
	 * @param void
	 */
	@Step("Verify on newly created applications,user unable to perform predefined operations")
	public static void verifyUserUnablePerformPredefinedOperations()
	{
		SeleniumUtils.waitForElementToBeClickable(downloadOption);
		Assert.assertTrue(downloadOption.isDisplayed());
		log.info("Download Option is displayed");
	}

	/**
	 *This method will verify that the Customer is able to download Renewal Application document from application listing.
	 * @return void
	 * @param void
	 */
	@Step("Verify download Renewal Application document from application listing")
	public static void downloadRenewalApplicationDocument() {
		SeleniumUtils.waitForElementToBeClickable(downloadOption);
		Assert.assertTrue(downloadOption.isDisplayed());
		log.info("Download Option is displayed");
		downloadOption.click();
		log.info("Renewal Application Document is Downloaded ");
	}
	
	/**
	 * This Method will navigate you to the payment page from application listing page.
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to Payment page")
	public static void navigateToPaymentPage(){
		SeleniumUtils.waitForElementToBeVisible(applicationIdTableHeading);
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeClickable(applicationIdTableHeading);
		sortingDropdown.click();
		log.info("Sorting dropdown selected");
		newSort.click();
		log.info("new sort");
		Assert.assertTrue(paymentPageLink.isDisplayed());
		SeleniumUtils.waitForElementToBeClickable(paymentPageLink);
		paymentPageLink.click();
		log.info("Payment page");
	}
	
	/**
	 * This Method will verify that Application has moved to Draft
	 * 
	 * @param appId
	 * @return void
	 */
	@Step("Verify Application moved to Draft")
	public static void verifyApplicationMovedToDraft(String appId){
		SeleniumUtils.waitForElementToBeVisible(applicationIdTableHeading);
		SeleniumUtils.refreshPage();
		SeleniumUtils.waitForElementToBeClickable(applicationIdTableHeading);
		Assert.assertTrue(applicationStatusDropdown.isDisplayed());
		applicationStatusDropdown.click();
		log.info("Dropdown to select an application status");
		SeleniumUtils.waitForElementToBeVisible(applicationStatusDraft);
		applicationStatusDraft.click();
		log.info("Drafts visible");
		textboxToSearchApplication.sendKeys(appId);
		log.info("Application moved to drafts found");
		Assert.assertTrue(editApplicationLink.isDisplayed());
		log.info("Edit Option available");
		Assert.assertTrue(deleteApplicationFromDraft.isDisplayed());
		log.info("Delete Option available");
	}
	
	/**
	 * This Method will select the application and see if its status is Pending Review
	 * 
	 * @param appId
	 * @return void
	 */
	public static void checkStatus(String appId)
	{
		textboxToSearchApplication.clear();
		textboxToSearchApplication.sendKeys(appId);
		Assert.assertTrue(statusPendingReview.isDisplayed());
		log.info("The application Status is Pending review");
	}	
	
	/**
	 * This Method will click on recall application option and the 
	 * application will move to draft.
	 * 
	 * @param void
	 * @return appId
	 */
	@Step("Click on recall application")
	public static String clickOnRecallApplication(){
		Assert.assertTrue(applicationStatusDropdown.isDisplayed());
		applicationStatusDropdown.click();
		log.info("Dropdown to select an application status");
		applicationStatusPendingSignature.click();
		log.info("Clicked on pending signature status");
		appId = applicationId.getText();
		SeleniumUtils.waitForElementToBeVisible(recallApplicationLink);
		recallApplicationLink.click();
		log.info("Clicked on Recall application");
		SeleniumUtils.acceptPopup();
		log.info("Popup accepted");
		return appId;
	}
	
	/**
	 * This Method will return the application id of first application 
	 * appearing in the application listings
	 * @param void
	 * @return application Id
	 */
	public static String getFirstApplicationId()
	{
		Assert.assertTrue(applicationId.isDisplayed());
		log.info("Applications are being displayed");
		appId = applicationId.getText();
		log.info("Application id of first application is extracted");
		return appId;
	}
	
	/**
	 * This Method will redirect you to searched application
	 * 
	 * @param void
	 * @return appId
	 */
	@Step("Redirect to created application")
	public static void selectApplication(String appId){
		//SeleniumUtils.refreshPage();
		//SeleniumUtils.waitForElementToBeVisible(textboxToSearchApplication);
		Assert.assertTrue(textboxToSearchApplication.isDisplayed());
		textboxToSearchApplication.clear();
		log.info("textbox cleared to search for the submitted application");
		textboxToSearchApplication.sendKeys(appId);
		log.info("Application searched");
	}
	
	/**
	 * This Method will sort applications based to their status "pending signature"
	 * and select the first to click on its edit link
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Click on Edit Application")
	public static void clickOnEditApplication(String appId){
		Assert.assertTrue(applicationStatusDropdown.isDisplayed());
		applicationStatusDropdown.click();
		log.info("Dropdown to select an application status");
		applicationStatusPendingSignature.click();
		log.info("Clicked on pending signature status");
		textboxToSearchApplication.sendKeys(appId);
		log.info("Application moved to drafts found");
		Assert.assertTrue(editApplicationLink.isDisplayed());
		editApplicationLink.click();
	}
	/**
	 * This Method will verify after click on "Recall Application"
	 *the application has moved to drafts 
	 * @param void
	 * @return void
	 */
	@Step("Click on recall application")
	public static void verifyRecallApplication(){
		numberOfDraftApplicationAfterRecallApplication=numberOfDraftApplications+1;
		Assert.assertEquals(draftApplications.size(), numberOfDraftApplicationAfterRecallApplication,"Verified that application has moved to drafts");
	}
}
