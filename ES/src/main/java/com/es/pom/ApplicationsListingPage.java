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

	@FindBy(linkText = "Edit")
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

	@FindBy(linkText = "New")
	static WebElement newSort;
	//
	@FindBy(linkText = "Renewal")
	static WebElement renewalSort;

	@FindBy(linkText = "Pay")
	static WebElement paymentPageLink;

	@FindBy(xpath = "//th[@tabindex='0']")
	static WebElement elementsToWaitForReload;

	@FindBy(xpath = "//a[@id='sbToggle_58028408']")
	static WebElement applicationStatusDropdown;

	@FindBy(linkText = "Pending Signature")
	static WebElement applicationStatusPendingSignature;

	@Step("verify Application page for ER Step...")
	public static void verifyApplicationPageForER() {
		Assert.assertTrue(verifyRegisterfromER.isDisplayed());
		log.info("Verify Register from ER displayed");
	}

	@Step("verify Application page for PGM Step...")
	public static void verifyApplicationPageForPMG() {
		Assert.assertTrue(verifyRegisterfromPMG.isDisplayed());
		log.info("Verify Register from PMG displayed");

	}

	@Step("verify Application page for ESL Step...")
	public static void verifyApplicationPageForESL() {
		Assert.assertTrue(verifyRegisterfromESL.isDisplayed());
		log.info("Verify Register from ESL displayed");
	}

	@Step("Checking if Edit option is present in pending review")
	public static void checkEditOptionInPendingReviewApp() {
		log.info("On application page verifying edit option for pending review");
		if (pendingReviewExcludeRenewalType.size() == pendingReviewEditActionButtons.size()) {
			log.info("All Edit Action Buttons are found for Pending Review Status");
		} else {
			log.info("All Edit Action Buttons are not found for Pending Review Status");
		}
	}

	@Step("Getting navigated to Edit Application Page")
	public static void navigateToEditApplicationPage() {
		editApplicationLink.click();
		log.info("navigated to edit application page");
	}

	@Step("On newly created applications, user should not be able to perform predefined operations like edit/view/delete/recall....")
	public static void verifyUserUnablePerformPredefinedOperations() {
		SeleniumUtils.waitForElementToBeClickable(downloadOption);
		Assert.assertTrue(downloadOption.isDisplayed());
		log.info("Download Option is displayed");
	}

	@Step("")
	public static void customerDownloadRenewalApplicationDocument() {
		SeleniumUtils.waitForElementToBeClickable(downloadOption);
		downloadOption.click();
		log.info("Renewal Application Document is Downloaded ");
	}

	@Step("Navigate to Payment page")
	public static void navigateToPaymentPage() {
		SeleniumUtils.waitForElementToBeVisible(elementsToWaitForReload);
		SeleniumUtils.refreshPage();
		sortingDropdown.click();
		log.info("Sorting dropdown selected");
		SeleniumUtils.waitForElementToBeVisible(elementsToWaitForReload);
		newSort.click();
		log.info("new sort");
		paymentPageLink.click();
		log.info("Payment page");
	}

	@Step("Click on recall application...")
	public static void clickOnRecallApplication() {
		applicationStatusDropdown.click();
		log.info("Dropdown to select an application status");
		applicationStatusPendingSignature.click();
		log.info("Clicked on pending signature status");
		SeleniumUtils.acceptPopup();
		log.info("Popup accepted");
	}
}
