package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class PMGApplicationSubmission extends Setup {

	@Test(groups = { "smoke", "PMGApplicationSubmission" })
	@Description("Verify that the customer is able to submit the pmg application")
	public static void verifyPmgApplicationFormSubmit_UnapprovedUser() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("unApprovedUser"), Prop.getTestData("unApprovedUserPassword"),
					"Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyPmgApplicationFormSubmit_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "PMGApplicationSubmission" })
	@Description("Verify the PMG Application submiited email received by the customer.")
	public static void verifyEmailRecievedForPMGApplication_UnapprovedUser() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("unApprovedUser"), Prop.getTestData("unApprovedUserPassword"),
					"Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			Yopmail.verifyPMGApplicationSubmitByNonApprovedUser(Prop.getTestData("unApprovedUser"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "PMGApplicationSubmission" })
	@Description("Verify that the approved customer is able to submit the pmg application")
	public static void verifyPmgApplicationFormSubmit_ApprovedUser() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyPmgApplicationFormSubmit_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "PMGApplicationSubmission" })
	@Description("Verify the PMG Application submiited email received by the Approved User.")
	public static void verifyEmailRecievedForPMGApplication_ApprovedUser() throws IOException, InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("unApprovedUser"), Prop.getTestData("unApprovedUserPassword"),
					"Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			Yopmail.verifyPMGApplicationMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
}
