package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class SignInPage {

	private static Logger log = Logger.getLogger(SignInPage.class.getName());

	@FindBy(id="user-login")
	static WebElement usernameplaceholder;

	@FindBy(id="user_password")
	static WebElement userpassword;

	@FindBy(id="customer")
	static WebElement customerRadioButton;

	@FindBy(id="staff")
	static WebElement staffRadioButton;

	@FindBy(id="lwa_wp-submit")
	static WebElement loginButton;

	@FindBy(xpath="//h1[@class='entry-title post-title']")
	static WebElement dashboardElement;

	@FindBy(xpath="//a[@title='Forgot Password']")    			    
	static WebElement forgotPasswordLink;

	@FindBy(linkText="Register")
	static WebElement registrationLink;


	@FindBy(linkText="Register")
	static WebElement newUserLink;

	@FindBy(xpath="//div[contains(@class,'col-md')]/a[contains(@href,'esr')]")
	static WebElement applyERLink;

	@FindBy(xpath="//div[contains(@class,'col-md')]/a[contains(@href,'pmg')]")
	static WebElement applyPMGLink;

	@FindBy(xpath="//div[contains(@class,'col-md')]/a[contains(@href,'esl')]")
	static WebElement applyBuldingProgramLink;

	/**
	 * @author Shefali.Garg
	 * @description This method would perform login based on account type
	 * @return void
	 * @param driver
	 */

	@Step("Perform login based on account type")
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
			break;
		case "Staff":
			log.info("selecting a staff account");
			staffRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			break;
		default: 
			log.info("Please enter user type");
		}
	}

	@Step("Navigate to forgot password...")
	public static void navigateToForgotPassword()
	{
		forgotPasswordLink.click();
		log.info("navigated to forgot password page");

	}

	@Step("Register new User from Normal Register steps...")
	public static void navigateToNormalRegistration() {
		newUserLink.click();
		log.info("Register new User from Simple Register");
	}

	@Step("Register new User from Evaluation Reports steps...")
	public static void navigateToER() {
		applyERLink.click();
		log.info("Register new User from Evaluation Reports");
	}

	@Step("Register new User from PMG Listing Program")
	public static void navigateToPMG() {
		applyPMGLink.click();
		log.info("Register new User from PMG Listing Program");

	}

	@Step("Register new User from Building Products Listing Program steps...")
	public static void navigateToESL() {
		applyBuldingProgramLink.click();
		log.info("Register new User from Building Products Listing Program");

	}
}


