package com.es.util;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.es.pom.YopmailPage;

/**
 * This class contains yopmail related method.
 * @author Tushar
 *
 */
public class Yopmail {
	public static String yopmailUrl = "http://www.yopmail.com";
	private static Logger log = Logger.getLogger(Yopmail.class.getName());

	/**
	 * This Method will return Otp required for registration.
	 * 
	 * @param email
	 * @return String - otp
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
	 * @return void
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
	 * @return void
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
	 * @return void
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
	 * @return void
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
	 * @return String - password link
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
	 * @return void
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
	 * @return void
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
	 * @return void
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
	 * This method will verify New Account Approved by staff mail
	 * body(Contents).
	 * @param email
	 * @return void
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
	 * 
	 * @param email
	 *            (For test case no 33)
	 * @return void
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
	 * @return void
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
	 *@param email---iasinfobeans@yopmail.com
	 *@return void
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
	 * This method will verify Quotation Received By Staff - mail
	 * body(Contents).
	 * 
	 * @param email
	 *            -- esportal@yopmail.com
	 * @return void
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
	 * This method will verified approved or decline profile changes mail body
	 * in customer inbox.
	 * @param email
	 *            -- iasinfobeans@yopmail.com
	 *            @return void
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
	 * 
	 * @param email
	 *            -- iasinfobeans@yopmail.com
	 *            @return void
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
	 * 
	 * @param email
	 *            -- iasinfobeans@yopmail.com
	 *            @return void
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
	 * This method will verify email for received payment in Staff inbox.
	 * 
	 * @param email
	 *            -- esportal@yopmail.com
	 *            @return void
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

	/**
	 * This method will verify new renewal file mail body in Staff inbox.
	 * 
	 * @param email
	 *            -- esportal@yopmail.com
	 *            @return void
	 */
	public static void verifyNewRenewalFile(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openNewRenewalFileMail();
			YopmailPage.verifyNewRenewalFileMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify payment for invoice mail body in cutomer inbox.
	 * 
	 * @param email
	 *            -- iasinfobeans@yopmail.com
	 *            @return void
	 */
	public static void verifyPaymentForInvoiceMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPaymentForInvoiceMail();
			YopmailPage.verifyPaymentForInvoiceMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify payment received for invoice mail body in Staff
	 * inbox.
	 * 
	 * @param email
	 *            -- esportal@yopmail.com
	 *             @return void
	 */
	public static void verifyPaymentForInvoiceReceivedMail(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPaymentForInvoiceReceivedMail();
			YopmailPage.verifyPaymentForInvoiceReceivedMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify PMG Application Submit By Non-Approved User in
	 * customer inbox.
	 * 
	 * @param email
	 *            -- ecinfobeans@yopmail.com (For Test case no 21)
	 *             @return void
	 */
	public static void verifyPMGApplicationSubmitByNonApprovedUser(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPMGApplicationSubmitByNonApprovedUserMail();
			YopmailPage.verifyPMGApplicationSubmitByNonApprovedUserMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify SOW uploaded mail in customer inbox and move to
	 * the SOW page.
	 * 
	 * @param email
	 *            -- iasinfobeans@yopmail.com
	 *             @return void
	 */
	public static void verifySOWUploadeMailToTechnicalRepresentative(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openSOWUploadeMailInCustomerInbox();
			YopmailPage.verifySOWUploadeMailBodyInCustomerInbox();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify SOW uploaded mail in customer inbox and move to
	 * the SOW page.
	 * 
	 * @param email
	 *            -- rachelzane@yopmail.com
	 *             @return void
	 */
	public static void verifySOWUploadedMailToAuthorizedSignatory(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openSOWUploadeMailInCustomerInbox();
			YopmailPage.verifySOWUploadeMailBodyInCustomerInbox();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify SOW file removed mail.
	 * 
	 * @param email
	 *            -- rachelzane@yopmail.com
	 *             @return void
	 */
	public static void verifySOWFileRemoveMailToAuthorizedSignatory(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openSOWFileRemovedMail();
			YopmailPage.verifySOWFileRemovedMailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify PMG application submitted by Non-approved user..
	 * 
	 * @param email
	 *            -- ecinfobeans@yopmail.com (For Test case no 23)
	 *             @return void
	 */
	public static void verifyPMGApplicationSubmittedByNonApprovedUser(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPMGApplicationSubmitByNonApprovedUserMail();
			YopmailPage.verifyPMGApplicationSubmittedByNonApprovedUserMail();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify PMG Application mail body in staff
	 * mail(Contents).
	 * 
	 * @param email
	 *            (For test case no 31)
	 *             @return void
	 */
	public static void verifyPMGApplicationMailInStaffInbox(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPMGApplicationEmail();
			YopmailPage.verifyPMGApplicationEmailBody();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will verify PMG Application mail body in customer
	 * mail(Contents).
	 * 
	 * @param email
	 *            (For test case no 31)
	 *             @return void
	 */
	public static void verifyPMGApplicationMailInCustomerInbox(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openPMGApplicationEmailInCustomerInbox();
			YopmailPage.verifyPMGApplicationEmailBodyInCustomerInbox();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify Delivered signing mail link.
	 * @param email
	 * (For test case no 101)-- lrrepresentative@yopmail.com
	 *             @return void
	 */
	public static void verifyDeliveredSigningMailLinks(String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(yopmailUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String yopmailWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(yopmailWindowHandle);
		try {
			YopmailPage.navigateToInbox(email);
			YopmailPage.openverifyDeliveredSigningMailLinks();
			YopmailPage.verifyverifyDeliveredSigningMailLinks();
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(yopmailWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
}
