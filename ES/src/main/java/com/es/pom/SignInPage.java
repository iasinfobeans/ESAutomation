package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;

public class SignInPage {

	private static Logger log = Logger.getLogger(SignInPage.class.getName());

	@FindBy(id = "user-login")
	static WebElement usernameplaceholder;

	@FindBy(id = "user_password")
	static WebElement userpassword;

	@FindBy(id = "customer")
	static WebElement customerRadioButton;

	@FindBy(id = "staff")
	static WebElement staffRadioButton;

	@FindBy(id = "lwa_wp-submit")
	static WebElement loginButton;

	@FindBy(xpath = "//h1[@class='entry-title post-title']")
	static WebElement dashboardElement;

	@FindBy(xpath = "//a[@title='Forgot Password']")
	static WebElement forgotPasswordLink;

	@FindBy(linkText = "Register")
	static WebElement registrationLink;

	@FindBy(linkText = "Register")
	static WebElement newUserLink;

	@FindBy(xpath = "//div[contains(@class,'col-md')]/a[contains(@href,'esr')]")
	static WebElement applyERLink;

	@FindBy(xpath = "//div[contains(@class,'col-md')]/a[contains(@href,'pmg')]")
	static WebElement applyPMGLink;

	@FindBy(xpath = "//div[contains(@class,'col-md')]/a[contains(@href,'esl')]")
	static WebElement applyBuldingProgramLink;

	/**
	 * This Method will enable you to login to your account as
	 * Staff/Customer.
	 * 
	 * @param username
	 * @param password
	 * @param accountType
	 * @return void
	 */
	@Step("Login")
	public static void login(String username, String password, String accountType){
		System.out.println("user-"+username+"place--"+usernameplaceholder.getAttribute("id"));
		Assert.assertTrue(usernameplaceholder.isDisplayed());
		usernameplaceholder.sendKeys(username);
		log.info("entered username");
		userpassword.sendKeys(password);
		log.info("entered password");

		switch (accountType) {
		case "Customer":
			log.info("selecting customer account");
			customerRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			log.info("Logged in as Customer");
			break;
		case "Staff":
			log.info("selecting a staff account");
			staffRadioButton.click();
			log.info("Selected the user type");
			loginButton.click();
			log.info("Logged in as Staff");
			break;
		default:
			log.info("Please enter user type");
		}
	}


	/**
	 * This Method will navigate to forgot password page
	 * 
	 * @param void
	 * @return void
	 */
	@Step("Navigate to forgot password page")
	public static void navigateToForgotPassword()
	{
		Assert.assertTrue(forgotPasswordLink.isDisplayed());
		forgotPasswordLink.click();
		log.info("navigated to forgot password page");

	}
	
	/**
	 * This method user is able to initiate the registration process by clicking on the register link present on the home page.
	 * @return void
	 * @param void
	 * 
	 */
	@Step("Register new User from Normal Register")
	public static void navigateToRegistration() {
		Assert.assertTrue(newUserLink.isDisplayed());
		log.info("New User Link is displayed");
		newUserLink.click();
		log.info("Register new User from Simple Register");
	}

	@Step("Register new User from Normal Register steps")
	public static void navigateToNormalRegistration() {
		newUserLink.click();
		log.info("Register new User from Simple Register");
	}

	/**
	 * This method would perform Registration of new User from Evaluation Reports.
	 * @return void
	 * @param void
	 * 
	 */
	@Step("Register new User from Evaluation Reports steps")
	public static void navigateToER() {
		Assert.assertTrue(applyERLink.isDisplayed());
		log.info("New User Link is displayed from Evaluation Reports");
		
		applyERLink.click();
		log.info("Register new User from Evaluation Reports");
	}


	/**
	 * This method would perform Registration of new User from PMG Listing Program.
	 * @return void
	 * @param void
	 * 
	 */
	@Step("Register new User from PMG Listing Program")
	public static void navigateToPMG() {
		
		Assert.assertTrue(applyPMGLink.isDisplayed());
		log.info("New User Link is displayed from PMG Listing Program");
		
		applyPMGLink.click();
		log.info("Register new User from PMG Listing Program");

	}

	/**
	 * This method would perform Registration of new User from Building Products Listing Program.
	 * @return void
	 * @param void
	 * 
	 */
	@Step("Register new User from Building Products Listing Program steps...")
	public static void navigateToESL() {
		
		Assert.assertTrue(applyBuldingProgramLink.isDisplayed());
		log.info("New User Link is displayed from Building Products Listing Program");
		
		applyBuldingProgramLink.click();
		log.info("Register new User from Building Products Listing Program");

	}
}
