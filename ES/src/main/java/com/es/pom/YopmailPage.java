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
			profileUpdatedLine1, newAccRegMailLine1, newAccRegApprovedLine1, pmgMailLine1, esrMailLine1, quatMailLine1,
			quatReqRecMailLine1, approvedOrDeclineProfileChange1;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you for your interest')]")
	static WebElement registrationMailBodyLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your account details')]")
	static WebElement registrationMailBodyLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),' Your registration request')]")
	static WebElement registrationMailBodyLine4;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Thank you,')]")
	static WebElement registrationMailBodyLine5, newAccRegMailBodyLine4, passResetMailBodyLine5, reqProfileUpdateLine5,
			profileUpdatedLine4, newAccRegMailLine4, newAccRegApprovedLine4, pmgMailLine5, esrMailLine5, quatMailLine4,
			quatReqRecMailLine4, approvedOrDeclineProfileChange5;

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

	@FindBy(xpath = "//*[text()='ICC-ES: New Account Registration']")
	static WebElement openNewAccRegMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Profile has been updated by')]")
	static WebElement newAccRegMailLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'To review and approve/reject the request, please ')]")
	static WebElement newAccRegMailLine3;

	@FindBy(xpath = "//*[text()='ICC-ES: Account Registration Approved']")
	static WebElement openNewAccApprovedMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Profile has been updated by')]")
	static WebElement newAccRegApprovedLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'To review and approve/reject the request, please ')]")
	static WebElement newAccRegApprovedLine3;

	@FindBy(xpath = "//a[@class='igif next']']")
	static WebElement searchOnNextPage;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Application PMG')]")
	static WebElement openPMGApplMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your PMG application has been submitted')]")
	static WebElement pmgMailLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'The application ID for the same is')]")
	static WebElement pmgMailLine3, esrMailLine3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Once all the signatures have been received,')]")
	static WebElement pmgMailLine4, esrMailLine4;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Application ESR')]")
	static WebElement openESRApplMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your ESR application has been submitted successfully')]")
	static WebElement esrMailLine2;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Quotation Request QOT')]")
	static WebElement openQuatReqSubMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your quotation request')]")
	static WebElement quatMailLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'An ICC-ES staff representative is reviewing your request')]")
	static WebElement quatMailLine3;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Quotation Raised By')]")
	static WebElement openQuatReqRecMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'A new quotation request QOT')]")
	static WebElement quatReqRecMailLine2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'To view details please ')]")
	static WebElement quatReqRecMailLine3;

	@FindBy(xpath = "//*[contains(text(),'ICC-ES: Your Request For Profile Update has been')]")
	static WebElement openApprovedOrDeclinedProfChangesMail;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'Your request to update profile information has been')]")
	static WebElement approvedOrDeclineProfileChange2;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'To review your profile, please ')]")
	static WebElement approvedOrDeclineProfileChange3;

	@FindBy(xpath = "//*[@id='mailmillieu']//p[contains(text(),'In case you have any questions, please get in touch with the ')]")
	static WebElement approvedOrDeclineProfileChange4;

	@Step("Navigate to inbox..")
	public static void navigateToInbox(String email) {
		emailTextBox.clear();
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

	@Step("Opening New Account Registration mail..")
	public static void openNewAccRegEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openNewAccRegMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openNewAccRegMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened New Account Registration mail");
	}

	@Step("Verifying New Account Registration mail body..")
	public static void verifyNewAccRegEmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = newAccRegMailLine1.getText();
		String firstRgistrationLine = newAccRegMailLine2.getText();
		String secondRgistrationLine = newAccRegMailLine3.getText();
		String forthRgistrationLine = newAccRegMailLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(
				firstRgistrationLine.contains("Your account has been approved by ICC Evaluation Service, LLC"), true,
				"Text is not contain in email body");

		Assert.assertEquals(
				secondRgistrationLine.contains("More features have been added to your account on the portal."), true,
				"Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified New Account Registration mail body");
	}

	@Step("Opening New Account Approved mail..")
	public static void openNewAccApprovedEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openNewAccApprovedMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openNewAccApprovedMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened New Account Approved mail");
	}

	@Step("Verifying New Account Approved mail body..")
	public static void verifyNewAccApprovedEmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = newAccRegApprovedLine1.getText();
		String firstRgistrationLine = newAccRegApprovedLine2.getText();
		String secondRgistrationLine = newAccRegApprovedLine3.getText();
		String forthRgistrationLine = newAccRegApprovedLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(
				firstRgistrationLine.contains("Your account has been approved by ICC Evaluation Service, LLC"), true,
				"Text is not contain in email body");

		Assert.assertEquals(
				secondRgistrationLine.contains("More features have been added to your account on the portal."), true,
				"Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified New Account Registration mail body");
	}

	@Step("Opening PMG Application mail..")
	public static void openPMGApplEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openPMGApplMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openPMGApplMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened PMG Application mail");
	}

	@Step("Verifying PMG Application mail body..")
	public static void verifyPMGApplEmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = pmgMailLine1.getText();
		String firstRgistrationLine = pmgMailLine2.getText();
		String secondRgistrationLine = pmgMailLine3.getText();
		String thirdRgistrationLine = pmgMailLine4.getText();
		String forthRgistrationLine = pmgMailLine5.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine.contains("Your PMG application has been submitted"), true,
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine.contains("The application ID for the same is"), true,
				"Text is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine.contains("Once all the signatures have been received,"), true,
				"Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified PMG Application mail body");
	}

	@Step("Opening ESR Application mail..")
	public static void openESRApplEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openESRApplMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openESRApplMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened ESR Application mail");
	}

	@Step("Verifying ESR Application mail body..")
	public static void verifyESRApplEmailBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = esrMailLine1.getText();
		String firstRgistrationLine = esrMailLine2.getText();
		String secondRgistrationLine = esrMailLine3.getText();
		String thirdRgistrationLine = esrMailLine4.getText();
		String forthRgistrationLine = esrMailLine5.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine.contains("Your ESR application has been submitted successfully"), true,
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine.contains("The application ID for the same is"), true,
				"Text is not contain in email body");

		Assert.assertEquals(thirdRgistrationLine.contains("Once all the signatures have been received,"), true,
				"Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified ESR Application mail body");
	}

	@Step("Opening Quatation Request Submit mail..")
	public static void openQuotationEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openQuatReqSubMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openQuatReqSubMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Quatation Request Submit mail");
	}

	@Step("Verifying Quatation Request Submit mail body..")
	public static void verifyQuotationBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = quatMailLine1.getText();
		String firstRgistrationLine = quatMailLine2.getText();
		String secondRgistrationLine = quatMailLine3.getText();
		String forthRgistrationLine = quatMailLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine.contains("Your quotation request"), true,
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine.contains("An ICC-ES staff representative is reviewing your request"),
				true, "Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Quatation Request Submit mail body");
	}

	@Step("Opening Quatation Request Received mail..")
	public static void openQuotationReqRecEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openQuatReqRecMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openQuatReqRecMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Quatation Request Received mail");
	}

	@Step("Verifying Quatation Request Received mail body..")
	public static void verifyQuotationReqRecBody() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = quatReqRecMailLine1.getText();
		String firstRgistrationLine = quatReqRecMailLine2.getText();
		String secondRgistrationLine = quatReqRecMailLine3.getText();
		String forthRgistrationLine = quatReqRecMailLine4.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");

		Assert.assertEquals(firstRgistrationLine.contains("A new quotation request QOT"), true,
				"Text is not contain in email body");

		Assert.assertEquals(secondRgistrationLine.contains("To view details please "), true,
				"Text is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");

		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Quatation Request Received mail body");
	}

	@Step("Opening Approved Or Decline Profile Changes mail..")
	public static void openApprovedOrDeclineProfileChangesEmail() {
		SeleniumUtils.switchToIframeById("ifinbox");
		try {
			openApprovedOrDeclinedProfChangesMail.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Seraching email Subject on second page.");
			searchOnNextPage.click();
			openApprovedOrDeclinedProfChangesMail.click();
		}
		SeleniumUtils.switchToDefaultIframe();
		log.info("Opened Approved Or Decline Profile Changes mail");
	}

	@Step("Verifying Approved Or Decline Profile Changes mail body..")
	public static void verifyApprovedOrDeclineProfileChangesEmail() {
		SeleniumUtils.switchToIframeById("ifmail");

		String hi = approvedOrDeclineProfileChange1.getText();
		String firstRgistrationLine = approvedOrDeclineProfileChange2.getText();
		String secondRgistrationLine = approvedOrDeclineProfileChange3.getText();
		String thirdRgistrationLine = approvedOrDeclineProfileChange4.getText();
		String forthRgistrationLine = approvedOrDeclineProfileChange5.getText();

		Assert.assertEquals(hi.contains("Hi"), true, "Hi is not contain in email body");
		
		Assert.assertEquals(firstRgistrationLine.contains("Your request to update profile information has been"), true,
				"Text is not contain in email body");
		
		Assert.assertEquals(secondRgistrationLine.contains("To review your profile, please "), true,
				"Text is not contain in email body");
		
		Assert.assertEquals(
				thirdRgistrationLine.contains("In case you have any questions, please get in touch with the "), true,
				"Text is not contain in email body");
		
		Assert.assertEquals(forthRgistrationLine.contains("Thank you,"), true,
				"Text 'Thank you,' is not contain in email body");
		
		Assert.assertEquals(forthRgistrationLine.contains("ICC Evaluation Service, LLC"), true,
				"Text 'ICC Evaluation Service, LLC' is not contain in email body");

		SeleniumUtils.switchToDefaultIframe();
		log.info("Verified Approved Or Decline Profile Changes mail body");
	}

}