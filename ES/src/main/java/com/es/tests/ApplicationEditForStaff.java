package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ApplicationPage;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class ApplicationEditForStaff extends Setup {

	@Test(groups = { "smoke", "ApplicationEditForStaff" })
	@Description("Verify that the staff has an option to edit the Applications that are in 'Pending Review' status")
	public static void verifyEditOptionForPendingReview() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.navigateToApplicationListingPage();
			ApplicationsListingPage.checkEditOptionInPendingReviewApp();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEditOptionForPendingReview");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "ApplicationEditForStaff" })
	@Description("Verify that the staff is able to edit all the sections except for the signatory information")
	public static void verifyEditOptionForSignatoryInformation() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.navigateToApplicationListingPage();
			String appId = ApplicationsListingPage.getFirstApplicationId();
			ApplicationsListingPage.navigateToEditApplicationPage(appId);
			ApplicationPage.verifySignatoryInfoIsNotEditable();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEditOptionForSignatoryInformation");
			e.getStackTrace();
			throw e;
		}
	}
}
