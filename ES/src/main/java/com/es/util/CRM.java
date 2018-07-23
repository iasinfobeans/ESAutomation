package com.es.util;

import java.util.Iterator;
import java.util.Set;

import com.es.pom.CRMPage;

public class CRM {

	public static String crmPortalUrl = "https://esuat.iccsafe.org/";
	
	public static void crmLogin(String username, String Password) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			CRMPage.login(username,Password);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
	
	public static void qualifyLeadInCRM(String name,String email) {
		Set<String> windowHandles = SeleniumUtils.openUrlInNewWindow(crmPortalUrl);
		Iterator<String> itr = windowHandles.iterator();
		String esWindowHandle = itr.next();
		String crmWindowHandle = itr.next();
		SeleniumUtils.switchToWindow(crmWindowHandle);
		try {
			//CRMPage.login(username,Password);
			CRMPage.qaulifyLeadInCRMPage(name,email);
		} catch (Exception e) {
			throw e;
		} finally {
			SeleniumUtils.switchToWindowAndClose(crmWindowHandle);
		}
		SeleniumUtils.switchToWindow(esWindowHandle);
	}
}
