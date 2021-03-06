package com.es.tests;

import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.DependsOn;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.AdminLogin;
import com.es.util.CRM;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class Register extends Setup {
	/*
	 * @Test(groups = { "smoke" })
	 * 
	 * @Description("Verify that user is able to Register on Portal") public void
	 * verifyRegistration() throws InterruptedException {
	 * SignInPage.navigateToNormalRegistration() ;
	 * RegisterPage.enterEmailInRegistration();
	 * RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"),
	 * Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData
	 * ("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword")
	 * ); OverlayPage.skipoverlayPage(); DashboardPage.verifyDashboardPage(); }
	 * 
	 * @Test(groups = { "smoke" })
	 * 
	 * @Description("Verify that user is able to Register on Portal from ER") public
	 * void verifyRegistrationFromER() throws InterruptedException {
	 * SignInPage.navigateToER(); RegisterPage.enterEmailInRegistration();
	 * RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"),
	 * Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData
	 * ("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword")
	 * ); ApplicationPage.verifyApplicationPageForER();
	 * 
	 * }
	 * 
	 * @Test(groups = { "smoke" })
	 * 
	 * @Description("Valid Register with correct credentials for ER") public void
	 * verifyRegistrationFromPMG() throws InterruptedException {
	 * SignInPage.navigateToPMG(); RegisterPage.enterEmailInRegistration();
	 * RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"),
	 * Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData
	 * ("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword")
	 * ); ApplicationPage.verifyApplicationPageForPMG(); }
	 * 
	 * @Test(groups = { "smoke" })
	 * 
	 * @Description("Valid Register with correct credentials for ESL") public void
	 * testingRegisterFunctionalityFromESL() throws InterruptedException {
	 * SignInPage.navigateToESL(); RegisterPage.enterEmailInRegistration();
	 * RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"),
	 * Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData
	 * ("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword")
	 * ); ApplicationPage.verifyApplicationPageForESL(); }
	 */

	@Test(groups = { "smoke", "Register"},dependsOnMethods="verifyConfirmationEmailToCustomerCRMQualifying")
	@Description("Verify that the user is able to initiate the registration process by clicking on the register link present on the home page.")
	public void verifyRegistrationFromHomePage() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.","verifyConfirmationEmailToCustomerCRMQualifying");
		/*try {
			SignInPage.navigateToRegistration();
			RegisterPage.enterEmailInRegistration();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyRegistrationFromHomePage");
			e.getStackTrace();
			throw e;
		} */
	}

	@Test(groups = { "smoke", "Register" },dependsOnMethods="verifyConfirmationEmailToCustomerCRMQualifying")
	@Description("Verify the email for OTP.")
	public void verifyEmailForOTP() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.","verifyConfirmationEmailToCustomerCRMQualifying");
		/*try {
			SignInPage.navigateToRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			Yopmail.verifyOTPEmailBody(email);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailForOTP");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "Register" },dependsOnMethods="verifyConfirmationEmailToCustomerCRMQualifying")
	@Description("Verify the registration process once correct OTP and other fields are entered")
	public void verifyRegistrationWithCorrectOTP() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.","verifyConfirmationEmailToCustomerCRMQualifying");
		/*try {
			SignInPage.navigateToRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"), email);
			DashboardPage.verifyRegistrationProcessAfterEnteringCorrectOTP();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyRegistrationWithCorrectOTP");
			e.getStackTrace();
			throw e;
		}*/
	}
	
	@Test(priority=1,groups = { "smoke", "Register"})
	@Description("Verify the email notifications sent to the Customer upon successful registration.")
	public void verifySuccessfulRegistrationEmailNotificationsToCustomer() throws InterruptedException {
		try {
			SignInPage.navigateToRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			Yopmail.verifyRegistrationEmailBody(email);
			Yopmail.verifyNewAccountRegistrationEmailBody(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifySuccessfulRegistrationEmailNotificationsToCustomer");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "Register" },dependsOnMethods="verifyConfirmationEmailToCustomerCRMQualifying")
	@Description("Verify the email notifications sent to the Staff upon successful registration.")
	public void verifyEmailNotificationsToStaff() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.","verifyConfirmationEmailToCustomerCRMQualifying");
		/*try {
			SignInPage.navigateToRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			Yopmail.verifyNewAccountRegistrationEmailBody(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailNotificationsToStaff");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "Register" },dependsOnMethods="verifyConfirmationEmailToCustomerCRMQualifying")
	@Description("Verify that ES Staff is able to qualify the lead in CRM.")
	public void verifyEsStaffQualifyLeadinCRM() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.","verifyConfirmationEmailToCustomerCRMQualifying");
		/*try {
			SignInPage.navigateToRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			CRM.qualifyLeadInCRM(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"),
					Prop.getTestData("Name"), email);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEsStaffQualifyLeadinCRM");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=2, groups = { "smoke", "Register"})
	@Description("Verify that after qualifying from CRM, a confirmation email is triggered to the customer.")
	public void verifyConfirmationEmailToCustomerCRMQualifying() throws InterruptedException {
		try {

			SignInPage.navigateToNormalRegistration();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"), email);
			DashboardPage.logout();
			CRM.qualifyLeadInCRM(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"),
					Prop.getTestData("Name"), email);
			AdminLogin.runJobForApproveRegistration();
			Yopmail.verifyNewAccountApprovedBody(email);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyConfirmationEmailToCustomerCRMQualifying");
			e.getStackTrace();
			throw e;
		}
	} 

	@Test(priority=3,groups = { "smoke", "Register"})
	@Description("Verify that the user is qualified and all the portal options get available to user.")
	public void verifyUserIsQualified() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyPortalOptionForQualifiedUser();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUserIsQualified");
			e.getStackTrace();
			throw e;
		}
	}
}
