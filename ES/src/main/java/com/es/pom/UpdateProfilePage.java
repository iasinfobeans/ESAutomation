package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.Prop;

import io.qameta.allure.Step;

public class UpdateProfilePage {
	private static Logger log = Logger.getLogger(UpdateProfilePage.class.getName());

	@FindBy(id="city")
	static WebElement textboxToEnterCity;

	@FindBy(id="updateProfile")
	static WebElement updateProfileButton;

	@FindBy(id="jobtitle")
	static WebElement jobtitleTextbox;

	@FindBy(id="street")
	static WebElement mailingAddressTextbox;

	@FindBy(linkText="Select State")
	static WebElement stateTextbox;

	@FindBy(linkText="Alabama")
	static WebElement stateSelection;

	@FindBy(linkText="Select Country")
	static WebElement countryTextbox;

	@FindBy(id="zipcode")
	static WebElement zipcodeTextbox;

	@FindBy(linkText="Afghanistan")
	static WebElement countrySelection;

	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static WebElement successfullUpdateMessage;

	@FindBy(id="profile_emailaddress")
	static WebElement emailTextbox;

	@FindBy(id="company_name")
	static WebElement companyTextbox;

	@Step("Updating a customer account steps...")
	public static void updateProfile()
	{
		jobtitleTextbox.sendKeys(Prop.getTestData("jobtitle"));
		log.info("job tile entered");
		mailingAddressTextbox.sendKeys(Prop.getTestData("MailingAddress"));
		log.info("Mailing Address entered");
		textboxToEnterCity.sendKeys(Prop.getTestData("city"));
		log.info("city entered");
		stateTextbox.click();
		log.info("selecting state");
		stateSelection.click();
		log.info("state selected");
		zipcodeTextbox.sendKeys("452001");
		log.info("Zipcode entered");
		countryTextbox.click();
		log.info("selecting country");
		countrySelection.click();
		log.info("country selected");
		updateProfileButton.click();
		log.info("updated profile");
		successfullUpdateMessage.isDisplayed();
		log.info( successfullUpdateMessage.getText());
	}

	@Step("Restrictions on updating profile verification steps...")
	public static void updateRestriction()
	{
		String readonly = emailTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonly);
		log.info("Verified that email text box is non editable");
		String readonlyCompany= companyTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonlyCompany);
		log.info("Verified that company text box is non editable");
	}

}
