package com.es.util;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.es.pom.YopmailPage;

public class Yopmail {
	public static String yopmailUrl = "http://www.yopmail.com";
	private static Logger log = Logger.getLogger(Yopmail.class.getName());
	/**
	 * This Method will return Otp required for registration.
	 * @param otp
	 * @return
	 */
	public static String getOTP(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		String otp = null;
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		otp = YopmailPage.getOTPfromMail();
		SeleniumUtils.switchToWindow(esWindowHandle);
		return otp;
	}

	public static void verifyOTPEmailBody(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		YopmailPage.navigateToInbox(email);
		YopmailPage.openOTPmail();
		YopmailPage.verifyOTPmailBody();
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static void verifyRegistrationEmailBody(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		YopmailPage.navigateToInbox(email);
		YopmailPage.openRegistrationMail(); 
		YopmailPage.verifyRegistrationMailBody();
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static void verifyNewAccRegEmailBody(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		YopmailPage.navigateToInbox(email);
		YopmailPage.openNewAccRegMail(); 
		YopmailPage.verifyNewAccRegMailBody();
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static void verifyPassResetEmailBody(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		YopmailPage.navigateToInbox(email);
		YopmailPage.openPassResetMail(); 
		YopmailPage.verifyPassResetMailBody();
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static String getPasswordResetLink(String email) {
		String esWindowHandle = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		String passResetLink = null;
		YopmailPage.navigateToInbox(email);
		/*try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		YopmailPage.openPassResetMail(); 
		passResetLink = YopmailPage.getResetLinkFromMail();
		SeleniumUtils.switchToWindow(esWindowHandle);
		return passResetLink;
	}
}
