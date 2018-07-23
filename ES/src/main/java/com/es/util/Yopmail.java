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
	 * 
	 * @param otp
	 * @return
	 */
	public static String getOTP(String email) {
		String otp = null;
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openOTPmail();
			otp = YopmailPage.getOTPfromMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
		return otp;
	}

	public static void verifyOTPEmailBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openOTPmail();
			YopmailPage.verifyOTPmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static void verifyRegistrationEmailBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openRegistrationMail();
			YopmailPage.verifyRegistrationMailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static void verifyNewAccRegEmailBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openNewAccRegMail();
			YopmailPage.verifyNewAccRegMailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static void verifyPassResetEmailBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPassResetMail();
			YopmailPage.verifyPassResetMailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static String getPasswordResetLink(String email) {
		String passResetLink = null;
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPassResetMail();
			passResetLink = YopmailPage.getResetLinkFromMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
		return passResetLink;
	}

	public static void verifyReqForProfileUpdate(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openProfileReqEmail();
			YopmailPage.verifyReqForProfileUpdateBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	public static void verifyProfileUpdatedMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openProfileUpdatedEmail();
			YopmailPage.verifyProfileUpdatedEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static void verifyNewAccRegBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openNewAccRegEmail();
			YopmailPage.verifyNewAccRegEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static void verifyNewApprovedBody(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openNewAccApprovedEmail();
			YopmailPage.verifyNewAccApprovedEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
}
