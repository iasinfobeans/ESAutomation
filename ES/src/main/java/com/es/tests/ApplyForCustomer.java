package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.DependsOn;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.CRM;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class ApplyForCustomer extends Setup {

	@Test(groups = { "smoke", "ApplyForCustomer"},dependsOnMethods="verifyEmailNotificationsToCustomerForApplyWorkFlow")
	@Description("Verify that user is able to register on the portal using the Apply Link from one of the program on to the home page.")
	public void verifyApplyWorkflow() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify the registration process once correct OTP and other fields are entered.","verifyEmailNotificationsToCustomerForApplyWorkFlow");
	/*	try {
			SignInPage.navigateToER();
			RegisterPage.enterEmailInRegistration();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyApplyWorkflow");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "ApplyForCustomer"},dependsOnMethods="verifyEmailNotificationsToCustomerForApplyWorkFlow")
	@Description("Verify the email for OTP.")
	public void verifyEmailForOTPApplyWorkflow() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify the registration process once correct OTP and other fields are entered.","verifyEmailNotificationsToCustomerForApplyWorkFlow");
		/*	try {
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			Yopmail.verifyOTPEmailBody(email);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailForOTPApplyWorkflow");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "ApplyForCustomer"},dependsOnMethods="verifyEmailNotificationsToCustomerForApplyWorkFlow")
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyRegistrationFromApplyWorkflow() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify the registration process once correct OTP and other fields are entered.","verifyEmailNotificationsToCustomerForApplyWorkFlow");
		/*try {
			SignInPage.navigateToPMG();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			ApplicationsListingPage.verifyApplicationPageForPMG();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyRegistrationFromApplyWorkflow");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=1,groups = { "smoke", "ApplyForCustomer"  })
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyEmailNotificationsToCustomerForApplyWorkFlow() throws InterruptedException {
		try {
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			Yopmail.verifyRegistrationEmailBody(email);
			Yopmail.verifyNewAccountRegistrationEmailBody(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEmailNotificationsToCustomerForApplyWorkFlow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "ApplyForCustomer"},dependsOnMethods="verifyEmailNotificationsToCustomerForApplyWorkFlow")
	@Description("Verify the email notifications sent to the Staff upon successful registration.")
	public void verifynEmailNotificationsToStaffForER() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify the registration process once correct OTP and other fields are entered.","verifyEmailNotificationsToCustomerForApplyWorkFlow");
		/*try {
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			Yopmail.verifyNewAccountRegistrationEmailBody(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifynEmailNotificationsToStaffForER");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=2,groups = { "smoke", "ApplyForCustomer"})
	@Description("Verify that ES Staff is able to qualify the lead in CRM.")
	public void verifyEsStaffQualifyLeadinCRMForER() throws InterruptedException {
		try {
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"), email);
			CRM.qualifyLeadInCRM(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"),
					Prop.getTestData("Name"), email);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEsStaffQualifyLeadinCRMForER");
			e.getStackTrace();
			throw e;
		}
	}
}
