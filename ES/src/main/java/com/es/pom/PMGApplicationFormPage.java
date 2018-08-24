package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class PMGApplicationFormPage {

	private static Logger log = Logger.getLogger(PMGApplicationFormPage.class.getName());

	@FindBy(id = "appcompanyname")
	static WebElement companyNameTextbox;

	@FindBy(id = "mailingaddress")
	static WebElement applicantEmailTextbox;

	@FindBy(id = "city")
	static WebElement cityTextbox;

	@FindBy(id = "state")
	static WebElement stateTextbox;

	@FindBy(id = "zip")
	static WebElement zipTextbox;

	@FindBy(id = "country")
	static WebElement countryTextbox;

	@FindBy(id = "emailaddress")
	static WebElement emailTextbox;

	@FindBy(id = "product_descriptions")
	static WebElement productDescriptionTextbox;

	@FindBy(id = "product_name")
	static WebElement productNameModelTextbox;

	@FindBy(id = "product_check")
	static WebElement productTypeCheckbox;

	@FindBy(id = "english_language_yes")
	static WebElement englishLanguageCheckbox;
	
	@FindBy(id = "learning_center_no")
	static WebElement learning_center_NoCheckbox;
	
	@FindBy(id = "tech_rep_name")
	static WebElement technicalRepresentativeTextbox;

	@FindBy(id = "tech_rep_title")
	static WebElement trTitleTextbox;

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
	static  WebElement agreementPopupCheckbox;

	@FindBy(id="continue_to_submit")
	static  WebElement continueAndSubmitButton;
	
	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static  WebElement successMessage;

	@FindBy(id="app_sidebar_save")
	static  WebElement saveButton;
	
	@FindBy(xpath="//input[@name='agreement[agreement_template][checkbox_signer_label]']")
	static  WebElement agreementCheckBox;
	
	@FindBy(xpath="//div[text()='Please check this box to sign the application']")
	static WebElement errorMessage;
	
	@FindBy(id="educate_building_professionals_no")
	static  WebElement educateBuildingProfessionalsYesCheckBox;
	
	@FindBy(xpath="//strong[@class='agreement_bullets']")
	static WebElement agreementBullets;

	/**
	 * This Method will fill the form for PMG application
	 * 
	 * @param void
	 * @return void
	 */
	@Step("PMG Listing application form fill")
	public static void PmgApplicationFormFill(String legalRepresentativeMail){
		SeleniumUtils.waitForElementToBeVisible(companyNameTextbox);
		Assert.assertTrue(companyNameTextbox.isDisplayed());
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
		//productDescriptionTextbox.sendKeys("PMG listing test product");
		//log.info("Entered country");
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
		lrEmailTextbox.clear();
		lrEmailTextbox.sendKeys(legalRepresentativeMail);
		log.info("Entered legal representative mail");
		hazardSituationCheckbox.click();
		log.info("hazard sittuation check Box ");
		learning_center_NoCheckbox.click();
		log.info("Learning center checkbox ");
		educateBuildingProfessionalsYesCheckBox.click();
		log.info("Educate building professionals check Box ");
	}


	/**
	 * This Method will verify that unapproved user can sign application as authorized signatory
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify that a non approved user is able to sign the application")
	public static void SignAsAuthorizedSignatory(){
		SeleniumUtils.scrollToBottom();
		//SeleniumUtils.waitForElementToBeClickable(agreementCheckBox);
		Assert.assertTrue(agreementBullets.isDisplayed());
		agreementCheckBox.click();
		log.info("Signed the application as authorized signatory");
	}
	

	/**
	 * This Method will submit PMG application after it has been completed
	 * 
	 * @param void
	 * @return void
	 */
	@Step("PMG Listing application form submit action")
	public static void PmgApplicationFormSubmit(){
		Assert.assertTrue(submitButton.isDisplayed());
		submitButton.click();
		log.info("clicked on submit");
		SeleniumUtils.waitForElementToBeClickable(disclaimerPopupTitle);
		log.info("Disclaimer Popup is displayed");
		agreementPopupCheckbox.click();
		log.info("clicked on checkbox");
		continueAndSubmitButton.click();
		log.info("continue and submit");
	}

	@Step("PMG application Submitted sucess message...")
	public static void clickSubmitPMGApplication(){
		Assert.assertTrue(submitButton.isDisplayed());
		submitButton.click();
		log.info("clicked on submit");
	}
	
	/**
	 * This Method will verify that PMG Application has been successfully submitted
	 * 
	 * @param void
	 * @return void
	 */
	@Step("PMG application Submit sucess message")
	public static void verifySuccessMessage(){
		Assert.assertTrue(successMessage.isDisplayed());
		log.info(successMessage.getText());
	}
	

	/**
	 * This Method will save PMG application and verify that 
	 * its is successfully saved to drafts
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Save PMG application")
	public static void PmgApplicationSave(){
		saveButton.click();
		log.info("clicked on save button");
		Assert.assertTrue(successMessage.isDisplayed());
		successMessage.isDisplayed();
		log.info(successMessage.getText());
	}
	

	/**
	 * This Method will Verify that PMG application
	 *  cant be submitted if the user is authorized
	 *  signatory and he has not signed the application
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Verify application cant be saved without signing if submitter is the authorized signatory")
	public static void checkIfApplicationNotSubmitted(){
		Assert.assertTrue(saveButton.isDisplayed());
		log.info("Application not submitted. User is on the smae page");
	}
}
