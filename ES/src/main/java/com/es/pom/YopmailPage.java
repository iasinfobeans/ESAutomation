package com.es.pom;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.setup.Driver;

import io.qameta.allure.Step;

public class YopmailPage {

	private static Logger log = Logger.getLogger(YopmailPage.class.getName());
	private static String otp = null;
	public static WebDriver driver = null;

	@FindBy(id = "login")
	static WebElement emailTextBox;

	@FindBy(className = "sbut")
	static WebElement submitEmail;

	@FindBy(className = "slientext")
	static WebElement refreshInbox;

	@FindBy(xpath = "//*[text()='ICC-ES: One Time Password (OTP)']")
	static WebElement openMail;

	@FindBy(xpath = "//div[@id='mailmillieu']//p/strong")
	static WebElement readOtp;

	@FindBy(xpath = "//*[@id='mailmillieu']//p")
	static WebElement mailBodyLine1;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your one time password is: ')]")
	static WebElement mailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'For security reasons')]")
	static WebElement mailBodyLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you,')]")
	static WebElement mailBodyLine4;

	@FindBy(xpath = "//*[text()='ICC-ES: Account Registration Initiated']")
	static WebElement openRegistrationMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p")
	static WebElement registrationMailBodyLine1, newAccRegMailBodyLine1, passResetMailBodyLine1;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you for your interest')]")
	static WebElement registrationMailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your account details')]")
	static WebElement registrationMailBodyLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),' Your registration request')]")
	static WebElement registrationMailBodyLine4;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you,')]")
	static WebElement registrationMailBodyLine5, newAccRegMailBodyLine4, passResetMailBodyLine5;

	@FindBy(xpath = "//*[text()='ICC-ES: New Account Registration']")
	static WebElement openNewAccRegistrationMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'A new account has been registered')]")
	static WebElement newAccRegMailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Kindly log into the CRM')]")
	static WebElement newAccRegMailBodyLine3;

	@FindBy(xpath = "//*[text()='ICC-ES: Password Reset']")
	static WebElement openPassResetMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Please')]")
	static WebElement passResetMailBodyLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'If you did not make this request')]")
	static WebElement passResetMailBodyLine4;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'request to reset your password')]")
	static WebElement passResetMailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Please')]/a")
	static WebElement passResetLink;

	@Step("Navigate to inbox..")
	public static void navigateToInbox(String email) {
		try {
			driver = Driver.getDriver();
		} catch (IOException e) {
			log.error("Error while initializing webdriver..");
			e.printStackTrace();
		}
		driver.get("http://www.yopmail.com");
		emailTextBox.sendKeys(email);
		submitEmail.click();
		refreshInbox.click();

	}

	@Step("Opening Otp mail..")
	public static void openOTPmail() {
		driver.switchTo().frame("ifinbox");
		openMail.click();
		driver.switchTo().defaultContent();

	}

	@Step("Getting OTP from mail..")
	public static String getOTPfromMail() {
		driver.switchTo().frame("ifmail");
		otp = readOtp.getText();
		driver.switchTo().defaultContent();
		return otp;
	}

	@Step("Verifying otp mail body..")
	public static void verifyOTPmailBody() {
		driver.switchTo().frame("ifmail");

		String hiText = mailBodyLine1.getText();
		String otpFirstLine = mailBodyLine2.getText();
		String otpThirdLine = mailBodyLine3.getText();
		String otpFourthLine = mailBodyLine4.getText();

		Assert.assertEquals(hiText, "Hi,", "Hi is not contain in email body");

		Assert.assertEquals(otpFirstLine.contains("Your one time password is: "), true,
				"Text 'Your one time password is: ' is not contain in email body");

		Assert.assertEquals(otpFirstLine.contains(" and would automatically expire in 5 minutes"), true,
				"Text ' and would automatically expire in 5 minutes' is not contain in email body");

		Assert.assertEquals(otpThirdLine,
				"For security reasons please do not share your one time password with any one.",
				"Text 'For security reasons please do not share your one time password with any one.' is not contain in email body");

		Assert.assertEquals(otpFourthLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(otpFourthLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		driver.switchTo().defaultContent();

	}

	@Step("Opening registraion succesful mail..")
	public static void openRegistrationMail() {
		driver.switchTo().frame("ifinbox");
		openRegistrationMail.click();
		driver.switchTo().defaultContent();

	}

	@Step("Verifying Registration mail body..")
	public static void verifyRegistrationMailBody() {
		driver.switchTo().frame("ifmail");

		String hi = registrationMailBodyLine1.getText();
		String firstRgistrationLine = registrationMailBodyLine2.getText();
		String secondRgistrationLine = registrationMailBodyLine3.getText();
		String thirdRgistrationLine = registrationMailBodyLine4.getText();
		String forthRgistrationLine = registrationMailBodyLine2.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine, "Thank you for your interest in ICC Evaluation Service, LLC.",
				"Text 'Thank you for your interest in ICC Evaluation Service, LLC.' is not contain in email body");

		Assert.assertEquals(secondRgistrationLine,
				"Your account details are being reviewed by a member of our staff and more features would be available on to the portal once your account has been approved.",
				"Text 'Your account details are being reviewed by a member of our staff and more features would be available on to the portal once your account has been approved.' is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine,
				"Note: Your registration request will be reviewed within one business day.",
				"Text 'Note: Your registration request will be reviewed within one business day.' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		driver.switchTo().defaultContent();

	}

	@Step("Opening New account registration mail..")
	public static void openNewAccRegMail() {
		driver.switchTo().frame("ifinbox");
		openNewAccRegistrationMail.click();
		driver.switchTo().defaultContent();
	}

	@Step("Verifying New account registration mail body..")
	public static void verifyNewAccRegMailBody() {
		driver.switchTo().frame("ifmail");

		String hi = newAccRegMailBodyLine1.getText();
		String firstRgistrationLine = newAccRegMailBodyLine2.getText();
		String secondRgistrationLine = newAccRegMailBodyLine3.getText();
		String thirdRgistrationLine = newAccRegMailBodyLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine.contains("A new account has been registered by"), true,
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine,
				"Kindly log into the CRM to view and qualify the lead for approving account registration.",
				"Text is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		driver.switchTo().defaultContent();
	}

	@Step("Opening password reset mail..")
	public static void openPassResetMail() {
		driver.switchTo().frame("ifinbox");
		openPassResetMail.click();
		driver.switchTo().defaultContent();

	}

	@Step("Verifying password reset mail body..")
	public static void verifyPassResetMailBody() {
		driver.switchTo().frame("ifmail");

		String hi = passResetMailBodyLine1.getText();
		String firstRgistrationLine = passResetMailBodyLine2.getText();
		String secondRgistrationLine = passResetMailBodyLine3.getText();
		String thirdRgistrationLine = passResetMailBodyLine4.getText();
		String forthRgistrationLine = passResetMailBodyLine5.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine,
				"We have received a request to reset your password on the ICC-ES Customer Portal.",
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine,
				"Please click here to reset your password, and log into your ICC-ES account.",
				"Text is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine, "If you did not make this request, please ignore this e-mail.",
				"Text 'If you did not make this request, please ignore this e-mail.' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		driver.switchTo().defaultContent();
	}

	@Step("Returning password reset link in string format..")
	public static String getResetLinkFromMail() {
		String resetPassLink = null;
		driver.switchTo().frame("ifmail");
		resetPassLink = passResetLink.getAttribute("href");
		driver.switchTo().defaultContent();
		return resetPassLink;
	}

}