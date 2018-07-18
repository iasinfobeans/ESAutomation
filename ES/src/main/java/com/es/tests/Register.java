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
import com.es.util.Yopmail;

import io.qameta.allure.Description;


public class Register extends Setup{



	/*@Test(groups = { "smoke" })
	@Description("Verify that user is able to Register on Portal")
	public void verifyRegistration() throws InterruptedException {
		SignInPage.navigateToNormalRegistration() ;
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		OverlayPage.skipoverlayPage();
		DashboardPage.verifyDashboardPage();
	}*/

	/*@Test(groups = { "smoke" })
	@Description("Verify that user is able to Register on Portal from ER")
	public void verifyRegistrationFromER() throws InterruptedException {
		SignInPage.navigateToER();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForER();

	}*/

	/*@Test(groups = { "smoke" })
	@Description("Valid Register with correct credentials for ER")
	public void verifyRegistrationFromPMG() throws InterruptedException {
		SignInPage.navigateToPMG();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForPMG();
	}*/

	/* @Test(groups = { "smoke","priya" })
	@Description("Valid Register with correct credentials for ESL")
	public void testingRegisterFunctionalityFromESL() throws InterruptedException {
		SignInPage.navigateToESL();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForESL();
	}
}  */

	@Test(groups = { "smoke" })
	@Description("Verify that the user is able to initiate the registration process by clicking on the register link present on the home page.")
	public void verifyRegistrationFromPortal() throws InterruptedException {
		SignInPage.navigateToNormalRegistration() ;
		RegisterPage.enterEmailInRegistration();
	}

	@Test(groups = { "smoke"})
	@Description("Verify the email for OTP.")
	public void verifyEmailForOTP() throws InterruptedException {
		SignInPage.navigateToNormalRegistration();
		String email = RegisterPage.enterEmailInRegistration();
		Yopmail.verifyOTPEmailBody(email);

	}

	@Test(groups = { "smoke" })
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyRegistrationWithCorrectOTP() throws InterruptedException {
		SignInPage.navigateToNormalRegistration();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		DashboardPage.verifyRegistrationProcessAfterEnteringCorrectOTP();
	}

}