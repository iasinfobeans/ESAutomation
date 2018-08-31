package com.es.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import com.es.setup.Setup;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;

import io.qameta.allure.Description;

public class RecallApplication extends Setup{
	@Test(groups = {"smoke","RecallApplication"})
	@Description("Verify the recall application functionality")
	public static void verifyRecallApplicationOption() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.navigateToApplicationListingPage();
			String applicationNumber= ApplicationsListingPage.clickOnRecallApplication();
			ApplicationsListingPage.verifyApplicationMovedToDraft(applicationNumber);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRecallApplicationOption");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","RecallApplication"})
	@Description("Verify that the delivered signing mail links becomes invalid after recall.")
	public static void verifyRecallOptionInvalidatesSigningMailLink() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.navigateToApplicationListingPage();
			String applicationNumber= ApplicationsListingPage.clickOnRecallApplication();
			ApplicationsListingPage.verifyApplicationMovedToDraft(applicationNumber);
			Yopmail.verifyDeliveredSigningMailLinks(Prop.getTestData("legalRepresentativeMail"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRecallOptionInvalidatesSigningMailLink");
			e.getStackTrace();
			throw e;
		}
	}
}