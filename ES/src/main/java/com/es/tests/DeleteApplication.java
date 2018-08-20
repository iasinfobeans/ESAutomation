package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ApplicationPage;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class DeleteApplication extends Setup {

	@Test(groups = {"smoke","DeleteApplication"})
	@Description("Verify the Delete Application functionality for Unapproved user.")
	public static void verifyApplicationDelete_UnapprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationSave();
			DashboardPage.navigateToApplicationListingPageWhenLoggedIn();
			ApplicationPage.deleteApplication();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyApplicationDelete_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","DeleteApplication"})
	@Description("Verify the Delete Application functionality for Aapproved user.")
	public static void verifyApplicationDelete_AprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationSave();
			DashboardPage.navigateToApplicationListingPageWhenLoggedIn();
			ApplicationPage.deleteApplication();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyApplicationDelete_AprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	
}
