package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;
public class PMGApplicationSubmission extends Setup {

	@Test(groups = {"smoke"})
	@Description("Verify that the customer is able to submit the pmg application")
	public static void verifyPmgApplicationFormSubmit() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			DashboardPage.verifyDashboardPage();
			DashboardPage.navigateToPMGApplicationProgramUnapprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPmgApplicationFormSubmit");
			e.getStackTrace();
			throw e;
		}
	}
}
