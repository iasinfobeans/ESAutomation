package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class YopmailPage {

	private static Logger log = Logger.getLogger(YopmailPage.class.getName());
	private static String otp = null;

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
	static WebElement registrationMailBodyLine1, newAccRegMailBodyLine1, passResetMailBodyLine1, reqProfileUpdateLine1,
			profileUpdatedLine1;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you for your interest')]")
	static WebElement registrationMailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your account details')]")
	static WebElement registrationMailBodyLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),' Your registration request')]")
	static WebElement registrationMailBodyLine4;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you,')]")
	static WebElement registrationMailBodyLine5, newAccRegMailBodyLine4, passResetMailBodyLine5, reqProfileUpdateLine5,
			profileUpdatedLine4;

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

	@FindBy(xpath = "//*[text()='ICC-ES: Request For Profile Update']")
	static WebElement openProfileUpdateReqMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'update the profile has')]")
	static WebElement reqProfileUpdateLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'representative will review the changes')]")
	static WebElement reqProfileUpdateLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'begin to reflect post approval')]")
	static WebElement reqProfileUpdateLine4;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Request For Profile Update by')]")
	static WebElement openProfileUpdatedMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Profile has been updated by')]")
	static WebElement profileUpdatedLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'To review and approve/reject the request, please ')]")
	static WebElement profileUpdatedLine3;

	@Step("Navigate to inbox..")
	public static void navigateToInbox(String email) {
		emailTextBox.sendKeys(email);
		submitEmail.click();
		refreshInbox.click();
		log.info("Navigate to " + email + " inbox");
	}

	@Step("Opening Otp mail..")
	public static void openOTPmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened OTP email");
	}

	@Step("Getting OTP from mail..")
	public static String getOTPfromMail() {
		SeleniumUtils.switchToIframeById("ifmail");
		otp = readOtp.getText();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Got OTP: " + otp);
		return otp;
	}

	@Step("Verifying otp mail body..")
	public static void verifyOTPmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");
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

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified OTP mail body");
	}

	@Step("Opening registraion succesful mail..")
	public static void openRegistrationMail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openRegistrationMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Registration email");
	}

	@Step("Verifying Registration mail body..")
	public static void verifyRegistrationMailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = registrationMailBodyLine1.getText();
		String firstRgistrationLine = registrationMailBodyLine2.getText();
		String secondRgistrationLine = registrationMailBodyLine3.getText();
		String thirdRgistrationLine = registrationMailBodyLine4.getText();
		String forthRgistrationLine = registrationMailBodyLine5.getText();

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

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Registration email body");
	}

	@Step("Opening New account registration mail..")
	public static void openNewAccRegMail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openNewAccRegistrationMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened New account registration mail");
	}

	@Step("Verifying New account registration mail body..")
	public static void verifyNewAccRegMailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

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

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified New account registration body");
	}

	@Step("Opening password reset mail..")
	public static void openPassResetMail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openPassResetMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened password reset mail body");
	}

	@Step("Verifying password reset mail body..")
	public static void verifyPassResetMailBody() {
		SeleniumUtils.switchToIframeById("ifmail");
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

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Password reset mail body");
	}

	@Step("Returning password reset link in string format..")
	public static String getResetLinkFromMail() {
		String resetPassLink = null;
		SeleniumUtils.switchToIframeById("ifmail");
		resetPassLink = passResetLink.getAttribute("href");
		SeleniumUtils.switchToDefaultIframe();
		log.info("Got password reset link: " + resetPassLink);
		return resetPassLink;
	}

	@Step("Opening Profile update request mail..")
	public static void openProfileReqEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openProfileUpdateReqMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Profile update request mail");
	}

	@Step("Verifying Profile update request mail body..")
	public static void verifyReqForProfileUpdateBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = reqProfileUpdateLine1.getText();
		String firstRgistrationLine = reqProfileUpdateLine2.getText();
		String secondRgistrationLine = reqProfileUpdateLine3.getText();
		String thirdRgistrationLine = reqProfileUpdateLine4.getText();
		String forthRgistrationLine = reqProfileUpdateLine5.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(
				firstRgistrationLine.contains("Your request to update the profile has been submitted successfully"),
				true, "Text is not contain in email body");

		Assert.assertEquals(
				secondRgistrationLine
						.contains("An ICC-ES staff representative will review the changes and get in touch with you."),
				true, "Text is not contain in email body");

		Assert.assertEquals(
				thirdRgistrationLine.contains("Your changes will only begin to reflect post approval by ICC-ES team."),
				true, "Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Profile update request mail body");
	}

	@Step("Opening Profile updated mail..")
	public static void openProfileUpdatedEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		openProfileUpdatedMail.click();
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Profile updated mail");
	}

	@Step("Verifying Profile updated mail body..")
	public static void verifyProfileUpdatedEmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = profileUpdatedLine1.getText();
		String firstRgistrationLine = profileUpdatedLine2.getText();
		String secondRgistrationLine = profileUpdatedLine3.getText();
		String forthRgistrationLine = profileUpdatedLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");
		
		Assert.assertEquals(firstRgistrationLine.contains("Profile has been updated by"), true,
				"Text is not contain in email body");
		
		Assert.assertEquals(secondRgistrationLine.contains("To review and approve/reject the request, please "), true,
				"Text is not contain in email body");
		
		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");
		
		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Profile updated mail body");
	}

}