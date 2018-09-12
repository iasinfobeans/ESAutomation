package com.es.util;

import java.util.Iterator;
import java.util.Set;

import com.es.pom.CRMPage;

/**
 * This method contains CRM related methods. 
 * @author Tushar
 *
 */
public class CRM {

	public static String crmPortalUrl = "https://esuat.iccsafe.org/";

	/**
	 * This method will Login into CRM .
	 * @param username,Password
	 * @return void
	 */
	public static void crmLogin(String username, String Password) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			CRMPage.login(username, Password);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}

	/**
	 * This method will Qualify Lead in CRM.
	 * 
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @return void
	 */
	public static void qualifyLeadInCRM(String username, String password, String name, String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			CRMPage.login(username, password);
			CRMPage.qualifyLeadInCRMPage(name, email);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will disqualify lead of given email and name.
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @return void
	 */
	public static void disQualifyLeadInCRM(String username, String password, String name, String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			CRMPage.login(username, password);
			CRMPage.disQualifyLeadInCRMPage(name, email);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	/**
	 * This method will verify report contact details for given report number.
	 * @param reportNumber - For this report number report contact will be verify.
	 * @param username - username for crm login.
	 * @param password - password for crm login
	 * 
	 */
	public static void verifyReportContactDetails(String username, String password,String reportNumber) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			CRMPage.login(username, password);
			CRMPage.verifyReportContacts(reportNumber);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
}
