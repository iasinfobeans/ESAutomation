package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
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
	}

	@Test(groups = { "smoke" })
	@Description("Verify that user is able to Register on Portal from ER")
	public void verifyRegistrationFromER() throws InterruptedException {
		SignInPage.navigateToER();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForER();

	}

	@Test(groups = { "smoke" })
	@Description("Valid Register with correct credentials for ER")
	public void verifyRegistrationFromPMG() throws InterruptedException {
		SignInPage.navigateToPMG();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForPMG();
	}

	@Test(groups = { "smoke" })
	@Description("Valid Register with correct credentials for ESL")
	public void testingRegisterFunctionalityFromESL() throws InterruptedException {
		SignInPage.navigateToESL();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationPage.verifyApplicationPageForESL();
	}*/


	@Test(groups = { "smoke" })
	@Description("Verify that the user is able to initiate the registration process by clicking on the register link present on the home page.")
	public void verifyRegistrationFromPortal() throws InterruptedException {
		try{
			SignInPage.navigateToNormalRegistration() ;
			RegisterPage.enterEmailInRegistration();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRegistrationFromPortal");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke"})
	@Description("Verify the email for OTP.")
	public void verifyEmailForOTP() throws InterruptedException {
		try{
			SignInPage.navigateToNormalRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			Yopmail.verifyOTPEmailBody(email);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailForOTP");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyRegistrationWithCorrectOTP() throws InterruptedException {
		try{
			SignInPage.navigateToNormalRegistration();
			RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
			DashboardPage.verifyRegistrationProcessAfterEnteringCorrectOTP();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRegistrationWithCorrectOTP");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke"})
	@Description("Verify the email notifications sent to the Customer upon successful registration.")
	public void verifySuccessfulRegistrationEmailNotificationsToCustomer() throws InterruptedException {
		try{
			SignInPage.navigateToNormalRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
			Yopmail.verifyRegistrationEmailBody(email);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySuccessfulRegistrationEmailNotificationsToCustomer");
			e.getStackTrace();
			throw e;
		}
	}

	// 5,6 and 7 are CRM Based 

	@Test(groups = { "smoke" })
	@Description("Verify that the user is qualified and all the portal options get available to user.")
	public void verifyUserIsQualified() throws InterruptedException {
		try{	
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyPortalOptionForQualifiedUser();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUserIsQualified");
			e.getStackTrace();
			throw e;
		}
	}
}
