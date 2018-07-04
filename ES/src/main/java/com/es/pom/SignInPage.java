package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.es.setup.Driver;

import io.qameta.allure.Step;

public class SignInPage {
	
	private static Logger log = Logger.getLogger(Driver.class.getName());
	
	@FindBy(id="user_login")
	static WebElement usernameplaceholder;
	
	@FindBy(id="user_pass")
	static WebElement userpassword;
	
	@FindBy(id="customer")
	static WebElement customerRadioButton;
	
	@FindBy(id="assessor")
	static WebElement assessorRadioButton;

	@FindBy(id="staff")
	static WebElement staffRadioButton;
	
	@FindBy(id="wp-submit")
	static WebElement loginButton;
	
	@FindBy(xpath="//h1[@class='entry-title post-title']")
	static WebElement dashboardElement;
	
	@FindBy(linkText="Get a Quote")
	static WebElement getQuoteLink;
	
	 @FindBy(id="salutation")
	  static WebElement userSalutation;
	     
	  @FindBy(id="firstname")
	  static WebElement firstnameOfApplicant;
	  
	  @FindBy(id="lastname")
	  static WebElement lastnameOfApplicant;
	  
	  @FindBy(id="emailaddress1")
	  static WebElement email1OfApplicant;
	  
	  @FindBy(id="telephone1")
	  static WebElement teleNumberofApplicant_1;
	  
	  //@FindBy(id="telephone1")
	  //static WebElement teleNumberofApplicant_1;
	  
	  @FindBy(id="jobtitle")
	  static WebElement jobTitle;
	  
	  @FindBy(id="companyname")
	  static WebElement companyName;
	  
	  @FindBy(id="address1_line1")
	  static WebElement address_1;
	  
	  @FindBy(id="address1_city")
	  static WebElement address_city_1;
	  
	  @FindBy(id="address1_postalcode")
	  static WebElement postalCode_1;
	  
	  @FindBy(id="address1_stateorprovince")
	  static WebElement stateOrProvince_1;
	  
	  @FindBy(id="address1_country")
	  static WebElement country_1;
	  
	  @FindBy(id="leadsourcecode")
	  static WebElement leadSource;
	  
	  @FindBy(id="websiteurl")
	  static WebElement websiteUrl;
	  
	  @FindBy(id="accr_program")
	  static WebElement accrediationProgram;
	  
	  @FindBy(id="cmp_file")
	  static WebElement businessLicenseDoc;
	  
	  @FindBy(id="file_upload")
	  static WebElement fileUpload;
	  
	  @FindBy(id="insert")
	  static WebElement submitRequestButton;
	  
	/**
 	 * @author Shefali.Garg
 	 * @description This method would perform login based on account type
 	 * @return void
 	 * @param driver
 	 */
	@Step("Enter sign in details and sign in to account step...")
	public static void login(String username, String password, String accountType)
	{
		System.out.println("user-"+username+"place--"+usernameplaceholder.getAttribute("id"));
		usernameplaceholder.sendKeys(username);
		log.info("entered username");
		userpassword.sendKeys(password);
		log.info("entered password");
		
		switch(accountType) 
		{
		case "Customer":
			log.info("selecting customer account");
			customerRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			dashboardElement.isDisplayed();
			break;
		case "Accessor":
			log.info("selecting assessors account");
			assessorRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			getQuoteLink.isDisplayed();
			break;
		case "Staff":
			log.info("selecting a staff account");
			staffRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			getQuoteLink.isDisplayed();
			break;
		default: 
			log.info("Please enter user type");
		}
	}
}
		
	 
	