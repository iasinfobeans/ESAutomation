package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.es.util.CommonUtils;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;

import io.qameta.allure.Step;

public class RegisterPage {

	private static Logger log = Logger.getLogger(RegisterPage.class.getName());
	private static String email = null;

	@FindBy(id = "emailaddress")
	static WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='apply']/parent::div[@class='pop-btn-wp']")
	static WebElement submitButton;

	@FindBy(xpath = "//a[contains(text(),'Title')]")
	static WebElement dropDownMenu;

	@FindBy(linkText = "Miss")
	static WebElement optionTitle;

	@FindBy(id = "firstname")
	static WebElement firstNameTextBox;

	@FindBy(id = "lastname")
	static WebElement lastNameTextBox;

	@FindBy(id = "companyname")
	static WebElement companyNameTextBox;

	@FindBy(id = "phone")
	static WebElement phoneTextBox;

	@FindBy(id = "newpassword")
	static WebElement newPasswordTextBox;

	@FindBy(id = "confirmpassword")
	static WebElement confirmPasswordTextBox;

	@FindBy(id = "onetimepassword")
	static WebElement oneTimePassword;

	@FindBy(id = "proceed")
	static WebElement proceedButton;

	@Step("Enter User Details for Registration step...")
	public static String enterEmailInRegistration() {
		email = CommonUtils.getRandomYopMailId();
		SeleniumUtils.waitForElementToBeVisible(emailTextBox);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		log.info("Enter new email Address: " + email);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		submitButton.click();
		log.info("Submit your Email Address Button ");
		return email;
	}

	@Step("Enter User Details for Registration step...")
	public static void enterPersonalInfoInRegistration(String firstName, String lastName, String companyName,
			String phone, String newPassword, String confirmPassword) {

		dropDownMenu.isEnabled();
		dropDownMenu.click();
		log.info("Enter your Title");

		optionTitle.click();
		log.info("Enter your Title Option");

		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);
		log.info("Enter your firstname");

		lastNameTextBox.clear();
		lastNameTextBox.sendKeys(lastName);
		log.info("Enter your lastname");

		companyNameTextBox.clear();
		companyNameTextBox.sendKeys(companyName);
		log.info("Enter your companyname");

		phoneTextBox.clear();
		phoneTextBox.sendKeys(phone);
		log.info("Enter your Phone Number");

		newPasswordTextBox.clear();
		newPasswordTextBox.sendKeys(newPassword);
		log.info("Enter your New Password");

		confirmPasswordTextBox.clear();
		confirmPasswordTextBox.sendKeys(confirmPassword);
		log.info("Enter your Confirm Password");

		oneTimePassword.sendKeys(Yopmail.getOTP(email));

		proceedButton.click();
		log.info("Submit your Details");

	}
}
