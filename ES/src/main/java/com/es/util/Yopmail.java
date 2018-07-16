package com.es.util;
import com.es.pom.YopmailPage;

public class Yopmail {


	/**
	 * This Method will return Otp required for registration.
	 * @param otp
	 * @return
	 */
	public static String getOTP(String email) {
		String otp = null;
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		otp = YopmailPage.getOTPfromMail();
		return otp;
	}

	public static void verifyOTPEmailBody(String email) {
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		YopmailPage.verifyOTPmailBody();
	}
	
	public static void verifyRegistrationEmailBody(String email) {
		YopmailPage.navigateToInbox(email);
		YopmailPage.openRegistrationMail(); 
		YopmailPage.verifyRegistrationMailBody();
	}

	public static void verifyNewAccRegEmailBody(String email) {
		YopmailPage.navigateToInbox(email);
		YopmailPage.openNewAccRegMail(); 
		YopmailPage.verifyNewAccRegMailBody();
	}
	
	public static void verifyPassResetEmailBody(String email) {
		YopmailPage.navigateToInbox(email);
		YopmailPage.openPassResetMail(); 
		YopmailPage.verifyPassResetMailBody();
	}
	
	public static String getPasswordResetLink(String email) {
		String passResetLink = null;
		YopmailPage.navigateToInbox(email);
		YopmailPage.openPassResetMail(); 
		passResetLink = YopmailPage.getResetLinkFromMail();
		return passResetLink;
	}
}
