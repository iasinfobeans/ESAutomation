package com.es.util;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

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

	/**
	 * This method will verify Otp mail body(Contents).
	 * @param email
	 */
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

	/**
	 * This method will verify Registration mail body(Contents).
	 * @param email
	 */
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

	/**
	 * This method will verify New Account Registration mail body(Contents).
	 * @param email
	 */
	public static void verifyNewAccountRegistrationEmailBody(String email) {
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

	/**
	 * This method will verify Password reset mail body(Contents).
	 * @param email
	 */
	public static void verifyPasswordResetEmailBody(String email) {
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

	/**
	 * This method will return Password reset Link.
	 * @param email
	 */
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

	/**
	 * This method will verify Request For Profile Update mail body(Contents).
	 * @param email
	 */
	public static void verifyRequestForProfileUpdate(String email) {
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

	/**
	 * This method will verify Profile Updated mail body(Contents).
	 * @param email
	 */	
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
	
	/**
	 * This method will verify New Account Registration mail body(Contents).
	 * @param email
	 */	
	public static void verifyNewAccountRegistrationBody(String email) {
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
	
	/**
	 * This method will verify New Account Approved by staff mail body(Contents).
	 * @param email
	 */	
	public static void verifyNewAccountApprovedBody(String email) {
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
	
	/**
	 * This method will verify PMG Application mail body(Contents).
	 * @param email
	 */	
	public static void verifyPMGApplicationMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPMGApplEmail();
			YopmailPage.verifyPMGApplEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify ESR Application mail body(Contents).
	 * @param email
	 */	
	public static void verifyESRApplicationMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openESRApplEmail();
			YopmailPage.verifyESRApplEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify Quotation Submit by customer mail body(Contents).
	 * @param email---iasinfobeans@yopmail.com
	 */	
	public static void verifyQuotationSubmitByCustomer(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openQuotationEmail();
			YopmailPage.verifyQuotationBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify Quotation Received By Staff -  mail body(Contents).
	 * @param email -- esportal@yopmail.com
	 */	
	public static void verifyQuotationReceivedByStaff(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openQuotationReqRecEmail();
			YopmailPage.verifyQuotationReqRecBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verified approved or decline profile changes mail body in customer inbox.
	 * @param email -- iasinfobeans@yopmail.com
	 */
	public static void verifyApprovedOrDeclineProfileChanges(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openApprovedOrDeclineProfileChangesEmail();
			YopmailPage.verifyApprovedOrDeclineProfileChangesEmail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verified new quotation available mail in customer inbox.
	 * @param email  -- iasinfobeans@yopmail.com
	 */
	public static void verifyNewQuotationAvailableMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openNewQuotationAvailableMail();
			YopmailPage.verifyNewQuotationAvailableMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify email for received payment in customer inbox.
	 * @param email  -- iasinfobeans@yopmail.com
	 */
	public static void verifyMailReceivedByCustomerForPayment(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPaymentReceivedMail();
			YopmailPage.verifyPaymentReceivedMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify email for received payment in customer inbox.
	 * @param email  -- iasinfobeans@yopmail.com
	 */
	public static void verifyMailReceivedToStaffForPayment(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPaymentReceivedToStaffMail();
			YopmailPage.verifyPaymentReceivedToStaffMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
}
