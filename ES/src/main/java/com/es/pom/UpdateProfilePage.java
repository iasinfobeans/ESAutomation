package com.es.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class UpdateProfilePage {
	private static Logger log = Logger.getLogger(UpdateProfilePage.class.getName());

	@FindBy(id = "city")
	static WebElement textboxToEnterCity;

	@FindBy(id = "updateProfile")
	static WebElement updateProfileButton;

	@FindBy(id = "jobtitle")
	static WebElement jobtitleTextbox;

	@FindBy(id = "street")
	static WebElement mailingAddressTextbox;

	@FindBy(xpath = "//div[@tabindex='11']")
	static WebElement stateTextbox;

	@FindBy(xpath = "//label[contains(text(),'State')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> stateList;

	@FindBy(xpath = "//div[@tabindex='13']")
	static WebElement countryDropdown;

	@FindBy(xpath = "//label[contains(text(),'Country')]/../div[@class='sbHolder']/ul/li/a")
	static List<WebElement> countryList;

	@FindBy(id = "zipcode")
	static WebElement zipcodeTextbox;

	@FindBy(xpath = "//span[@class='message success alert']//ul//li")
	static WebElement successfullUpdateMessage;

	@FindBy(id = "profile_emailaddress")
	static WebElement emailTextbox;

	@FindBy(id = "company_name")
	static WebElement companyTextbox;

	@FindBy(xpath = "//input[@value='Developer']")
	static WebElement jobTitleVerifyElement;

	@FindBy(xpath = "//input[@value='developer@yopmail.com']")
	static WebElement mailingAddressVerifyElement;

	@FindBy(xpath = "//input[@value='Pune']")
	static WebElement cityVerifyElement;

	@Step("Updating a customer account steps...")
	public static void updateProfile() {
		jobtitleTextbox.clear();
		jobtitleTextbox.sendKeys(Prop.getTestData("jobtitle"));
		log.info("job tile entered");
		mailingAddressTextbox.clear();
		mailingAddressTextbox.sendKeys(Prop.getTestData("MailingAddress"));
		log.info("Mailing Address entered");
		textboxToEnterCity.clear();
		textboxToEnterCity.sendKeys(Prop.getTestData("city"));
		log.info("city entered");
		stateTextbox.click();
		log.info("selecting state");
		SeleniumUtils.waitForElementToBeVisible(stateList.get(1));
		stateList.get(1).click();
		log.info("state selected");
		zipcodeTextbox.clear();
		zipcodeTextbox.sendKeys("452001");
		log.info("Zipcode entered");
		countryDropdown.click();
		log.info("selecting country");
		SeleniumUtils.waitForElementToBeVisible(countryList.get(1));
		countryList.get(1).click();
		log.info("country selected");
		updateProfileButton.click();
		log.info("updated profile");
		successfullUpdateMessage.isDisplayed();
		log.info(successfullUpdateMessage.getText());
	}

	@Step("Updating a profile again...")
	public static void updateProfileAgain() {
		jobtitleTextbox.clear();
		jobtitleTextbox.sendKeys(Prop.getTestData("jobtitle2"));
		log.info("job tile entered");
		mailingAddressTextbox.clear();
		mailingAddressTextbox.sendKeys(Prop.getTestData("MailingAddress2"));
		log.info("Mailing Address entered");
		textboxToEnterCity.clear();
		textboxToEnterCity.sendKeys(Prop.getTestData("city2"));
		log.info("city entered");
		stateTextbox.click();
		log.info("selecting state");
		SeleniumUtils.waitForElementToBeVisible(stateList.get(1));
		stateList.get(1).click();
		log.info("state selected");
		zipcodeTextbox.clear();
		zipcodeTextbox.sendKeys("452001");
		log.info("Zipcode entered");
		countryDropdown.click();
		log.info("selecting country");
		SeleniumUtils.waitForElementToBeVisible(countryList.get(1));
		countryList.get(1).click();
		log.info("country selected");
		updateProfileButton.click();
		log.info("updated profile");
		successfullUpdateMessage.isDisplayed();
		log.info(successfullUpdateMessage.getText());
	}

	@Step("Restrictions on updating profile verification steps...")
	public static void updateRestriction() {
		String readonly = emailTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonly);
		log.info("Verified that email text box is non editable");
		String readonlyCompany = companyTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonlyCompany);
		log.info("Verified that company text box is non editable");
	}

	@Step("Verify if only the recent changes are visible...")
	public static void verifyChanges() {
		if (jobTitleVerifyElement.getAttribute("value").equals(Prop.getTestData("jobtitle2"))) {
			log.info("Recent Change is only getting displayed in job title");
		} else {
			log.info("Recent Change not getting displayed in job title");
		}
		if (mailingAddressVerifyElement.getAttribute("value").equals(Prop.getTestData("MailingAddress2"))) {
			log.info("Recent Change is only getting displayed in Mailing textbox");
		} else {
			log.info("Recent Change not getting displayed in Mailing textbox");
		}
		if (cityVerifyElement.getAttribute("value").equals(Prop.getTestData("city2"))) {
			log.info("Recent Change is only getting displayed in City textbox");
		} else {
			log.info("Recent Change not getting displayed in City textbox");
		}
	}
}
