package com.es.pom;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class  ApplicationsListingPage {

	private static Logger log = Logger.getLogger(ApplicationsListingPage.class.getName());

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromER;

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromPMG;

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromESL;

	@FindBy(xpath="//strong[text()='Pending Review']/ancestor::td/following-sibling::td[1][not(text()='Renewal')]")
	static List<WebElement> pendingReviewExcludeRenewalType;

	@FindBy(xpath="//strong[text()='Pending Review']/ancestor::tr[@role='row']//a[text()='Edit']")
	static List<WebElement> pendingReviewEditActionButtons;

	@FindBy(linkText="Edit")
	static WebElement editApplicationLink;

	@Step("verify Application page for ER Step...")
	public static void verifyApplicationPageForER(){
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
		if(pendingReviewExcludeRenewalType.size()==pendingReviewEditActionButtons.size()) {
			log.info("All Edit Action Buttons are found for Pending Review Status");
		}else {
			log.info("All Edit Action Buttons are not found for Pending Review Status");
		}
	}

	@Step("Getting navigated to Edit Application Page")
	public static void navigateToEditApplicationPage() {
		editApplicationLink.click();
		log.info("navigated to edit application page");
		}

}


