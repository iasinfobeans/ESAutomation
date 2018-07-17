package com.es.util;
import com.es.pom.YopmailPage;

public class Yopmail {


	/**
	 * This Method will return Otp required for registration.
	 * @param otp
	 * @return
	 */
	public static String getOTP(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		String otp = null;
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		otp = YopmailPage.getOTPfromMail();
		SeleniumUtils.openUrl(currentUrl);
		return otp;
	}

	public static void verifyOTPEmailBody(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		YopmailPage.verifyOTPmailBody();
		SeleniumUtils.openUrl(currentUrl);
	}
	
	public static void verifyRegistrationEmailBody(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		YopmailPage.navigateToInbox(email);
		YopmailPage.openRegistrationMail(); 
		YopmailPage.verifyRegistrationMailBody();
		SeleniumUtils.openUrl(currentUrl);
	}

	public static void verifyNewAccRegEmailBody(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		YopmailPage.navigateToInbox(email);
		YopmailPage.openNewAccRegMail(); 
		YopmailPage.verifyNewAccRegMailBody();
		SeleniumUtils.openUrl(currentUrl);
	}
	
	public static void verifyPassResetEmailBody(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		YopmailPage.navigateToInbox(email);
		YopmailPage.openPassResetMail(); 
		YopmailPage.verifyPassResetMailBody();
		SeleniumUtils.openUrl(currentUrl);
	}
	
	public static String getPasswordResetLink(String email) {
		String currentUrl = SeleniumUtils.getCurrentUrl();
		String passResetLink = null;
		YopmailPage.navigateToInbox(email);
		YopmailPage.openPassResetMail(); 
		passResetLink = YopmailPage.getResetLinkFromMail();
		SeleniumUtils.openUrl(currentUrl);
		return passResetLink;
	}
}
