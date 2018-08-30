package com.es.util;

import org.apache.log4j.Logger;

import com.es.pom.AdminPage;
import com.es.pom.SignInPage;

/**
 * This class will used to perform tasks which are related to admin login in ES portal.
 * @author Tushar
 *
 */
public class AdminLogin {
	
	private static Logger log = Logger.getLogger(AdminLogin.class.getName());
	
	
	/**
	 * This method will Run Quote Expiry Notification job to send Quote Expiry notification to customer.
	 */
	public static void runJobForQuoteExpiry() {
		SignInPage.login(Prop.getTestData("adminUser"), Prop.getTestData("adminPassword"), "Customer");
		AdminPage.runQuoteExpiryJob();
	}
}
