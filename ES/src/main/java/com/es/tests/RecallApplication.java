package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class RecallApplication {
	@Test(groups = {"smoke","RecallApplication"})
	@Description("Verify the recall application functionality")
	public static void verifyRecallApplicationOption() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.navigateToApplicationListingPage();
			ApplicationsListingPage.clickOnRecallApplication();
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
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.navigateToApplicationListingPage();
			ApplicationsListingPage.clickOnRecallApplication();
			//Yopmail method
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRecallOptionInvalidatesSigningMailLink");
			e.getStackTrace();
			throw e;
		}
	}
}