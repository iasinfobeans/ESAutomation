package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PMGApplicationFormPage {

	private static Logger log = Logger.getLogger(PMGApplicationFormPage.class.getName());

	@FindBy(id="appcompanyname")
	static WebElement companyNameTextbox;

	@FindBy(id="mailingaddress")
	static WebElement applicantEmailTextbox;

	@FindBy(id="city")
	static  WebElement cityTextbox;

	@FindBy(id="state")
	static  WebElement stateTextbox;

	@FindBy(id="zip")
	static  WebElement zipTextbox;

	@FindBy(id="country")
	static  WebElement countryTextbox;

	@FindBy(id="emailaddress")
	static  WebElement emailTextbox;

	@FindBy(id="product_descriptions")
	static  WebElement productDescriptionTextbox;

	@FindBy(id="product_name")
	static  WebElement productNameModelTextbox;

	@FindBy(id="product_check")
	static  WebElement productTypeCheckbox;

	@FindBy(id="english_language_yes")
	static  WebElement englishLanguageCheckbox;

	@FindBy(id="tech_rep_name")
	static  WebElement technicalRepresentativeTextbox;

	@FindBy(id="tech_rep_title")
	static  WebElement trTitleTextbox;

	@FindBy(id="legal_rep_name_title")
	static  WebElement legalRepresentativeTextbox;
	
	@FindBy(id="legal_rep_title")
	static  WebElement lrTitleTextbox;
	
	@FindBy(id="legal_rep_phone")
	static  WebElement lrPhoneTextbox;
	
	@FindBy(id="legal_rep_email")
	static  WebElement lrEmailTextbox;
	
	@FindBy(id="tech_rep_phone")
	static  WebElement trPhoneTextbox;

	@FindBy(id="tech_rep_email")
	static  WebElement trEmailTextbox;

	@FindBy(id="hazard_situation_yes")
	static  WebElement hazardSituationCheckbox;

	@FindBy(id="app_sidebar_submit")
	static  WebElement submitButton;

	@FindBy(xpath="//h1[text()='Disclaimer']")
	static  WebElement disclaimerPopupTitle;
	
	@FindBy(xpath="//div[@id='submit_popup']//ul[@class='radio-frm agreement-checkbox']")
	static  WebElement agreementCheckbox;

	@FindBy(id="continue_to_submit")
	static  WebElement continueAndSubmitButton;
	
	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static  WebElement successMessage;

	@Step("PMG Listing application form...")
	public static void PmgApplicationFormFill(){
		companyNameTextbox.sendKeys(Prop.getTestData("companyName"));
		log.info("Entered company name");
		applicantEmailTextbox.sendKeys(Prop.getTestData("applicantEmail"));
		log.info("Entered applicant email");
		cityTextbox.sendKeys(Prop.getTestData("pmgCity"));
		log.info("Entered city");
		stateTextbox.sendKeys(Prop.getTestData("pmgState"));
		log.info("Entered state");
		zipTextbox.sendKeys(Prop.getTestData("pmgZip"));
		log.info("Entered Zip");
		countryTextbox.sendKeys(Prop.getTestData("pmgcountry"));
		log.info("Entered country");
		emailTextbox.sendKeys(Prop.getTestData("pmgMail"));
		log.info("Entered Zip");
		productDescriptionTextbox.sendKeys("PMG listing test product");
		log.info("Entered country");
		productDescriptionTextbox.sendKeys("PMG listing test product");
		log.info("Entered product description");
		productNameModelTextbox.sendKeys("Product is of test type");
		log.info("Entered in product name and model textbox");
		productTypeCheckbox.click();
		log.info("check Box ");
		technicalRepresentativeTextbox.sendKeys(Prop.getTestData("TechnicalRepresentative"));
		log.info("Entered technical representative");
		trTitleTextbox.sendKeys(Prop.getTestData("trTitle"));
		log.info("Entered technical representative title ");
		trPhoneTextbox.sendKeys(Prop.getTestData("trContactnumber"));
		log.info("Entered technical representative phone");
		trEmailTextbox.sendKeys(Prop.getTestData("trEmail"));
		log.info("Entered technical representative email");
		legalRepresentativeTextbox.sendKeys(Prop.getTestData("legalRepresentative"));
		log.info("Entered legal representative name");
		lrTitleTextbox.sendKeys(Prop.getTestData("legalRepresentativeTitle"));
		log.info("Entered legal representative title");
		lrPhoneTextbox.sendKeys(Prop.getTestData("legalRepresentativePhone"));
		log.info("Entered legal representative phone");
		lrEmailTextbox.sendKeys(Prop.getTestData("legalRepresentativeMail"));
		log.info("Entered legal representative mail");
		englishLanguageCheckbox.click();
		log.info("check Box ");
		hazardSituationCheckbox.click();
		log.info("check Box ");
	}

	@Step("PMG Listing application form submit actions...")
	public static void PmgApplicationFormSubmit(){
		submitButton.click();
		log.info("clicked on submit");
		SeleniumUtils.waitForElementToBeClickable(disclaimerPopupTitle);
		log.info("Disclaimer Popup is displayed");
		agreementCheckbox.click();
		log.info("clicked on checkbox");
		continueAndSubmitButton.click();
		log.info("continue and submit");
		successMessage.isDisplayed();
		log.info(successMessage.getText());
	}

}


