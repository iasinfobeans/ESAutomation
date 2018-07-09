package com.es.util;

import java.nio.file.Paths;

import org.apache.log4j.Logger;

import com.es.pom.YopmailPage;

public class Yopmail {

	private static Logger log = Logger.getLogger(Yopmail.class.getName());
	private static String testDataPropertiesFilePath = Paths
			.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties")
			.toString();

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
		YopmailPage.openRegistrationMail(); //impmeted this
		YopmailPage.verifyRegistrationMailBody(); //implement thiss ok?ok
	}

}
