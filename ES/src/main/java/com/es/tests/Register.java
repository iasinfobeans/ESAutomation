package com.es.tests;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.es.pom.ApplicationPage;
import com.es.pom.DashboardPage;
import com.es.pom.OverlayPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import io.qameta.allure.Description;


public class Register {


	@BeforeMethod(alwaysRun = true)
	public void testSetup() throws IOException {

		Setup.testSetup();
	}

	@Test(priority = 1, groups = { "smoke" })
	@Description("Verify that user is able to Register on Portal")
	public void verifyRegistration() throws InterruptedException {
		SignInPage.navigateToNormalRegistration() ;
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("comfirmPassword"));
		OverlayPage.skipoverlayPage();
		DashboardPage.verifyDashboardPage();
	}

	@Test(priority = 2, groups = { "smoke" })
	@Description("Verify that user is able to Register on Portal from ER")
	public void verifyRegistrationFromER() throws InterruptedException {
		SignInPage.navigateToER();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("comfirmPassword"));
		OverlayPage.skipoverlayPage();
		DashboardPage.verifyDashboardPageforER();
		ApplicationPage.verifyApplicationPageForER();

	}
	@Test(priority = 3, groups = { "smoke" })
	@Description("Valid Register with correct credentials for ER")
	public void verifyRegistrationFromPMG() throws InterruptedException {
		SignInPage.navigateToPMG();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("comfirmPassword"));
		OverlayPage.skipoverlayPage();
		DashboardPage.verifyDashboardPageforPMG();
		ApplicationPage.verifyApplicationPageForPMG();
	}

	@Test(priority = 4, groups = { "smoke" })
	@Description("Valid Register with correct credentials for ESL")
	public void testingRegisterFunctionalityFromESL() throws InterruptedException {
		SignInPage.navigateToESL();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("comfirmPassword"));
		OverlayPage.skipoverlayPage();
		DashboardPage.verifyDashboardPageforESL();
		ApplicationPage.verifyApplicationPageForESL();
	}


	@AfterMethod
	public void testTearDown() {
		Setup.testTearDown();
	}
}

