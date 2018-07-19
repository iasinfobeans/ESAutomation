package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;


public class CRMPage {
	
	private static Logger log = Logger.getLogger(CRMPage.class.getName());
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_UsernameTextBox']")
	static WebElement userNameTextbox;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_PasswordTextBox']")
	static WebElement passwordTextbox;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_SubmitButton']")
	static WebElement crmLoginButton;
	
	@Step("Signing in CRM..")
	public static void login(String username, String password) {
		userNameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		crmLoginButton.click();
		log.info("Logged in successfully in CRM.");
	}

}
