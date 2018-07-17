package com.es.pom;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.es.util.CommonUtils;

import io.qameta.allure.Step;

public class RegisterPage {

	private static Logger log = Logger.getLogger(RegisterPage.class.getName());

	@FindBy(id="emailaddress")
	static WebElement emailTextBox;

	@FindBy(xpath="//input[@id='apply']/parent::div[@class='pop-btn-wp']")
	static WebElement submitButton;

	@FindBy(xpath="//a[contains(text(),'Title')]")
	static WebElement dropDownMenu;

	@FindBy(linkText="Miss")
	static WebElement optionTitle;

	@FindBy(id="firstname")
	static WebElement firstNameTextBox;

	@FindBy(id="lastname")
	static WebElement lastNameTextBox;

	@FindBy(id="companyname")
	static WebElement companyNameTextBox;

	@FindBy(id="phone")
	static WebElement phoneTextBox;

	@FindBy(id="newpassword")
	static WebElement newPasswordTextBox;

	@FindBy(id="confirmpassword")
	static WebElement confirmPasswordTextBox;

	@FindBy(id="proceed")
	static WebElement proceedButton;

	/**
	 * @author Shefali.Garg
	 * @description This method would perform login based on account type
	 * @return void
	 * @param driver
	 */
	@Step("Enter User Details for Registration step...")
	public static void  enterEmailInRegistration(){
		String email= CommonUtils.getRandomYopMailId();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		log.info("Enter new email Address: "+email);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		submitButton.click();
		log.info("Submit your Email Address Button ");
	}

	@Step("Enter User Details for Registration step...")
	public static void enterPersonalInfoInRegistration(String firstName,String lastName,String companyName,String phone,String newPassword,String confirmPassword) {

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

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		proceedButton.click();
		log.info("Submit your Details");

	}     
}



