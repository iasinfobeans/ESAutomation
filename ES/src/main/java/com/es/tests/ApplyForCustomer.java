package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.ApplicationPage;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class ApplyForCustomer extends Setup{

	@Test(groups = { "smoke" })
	@Description("Verify that user is able to register on the portal using the Apply Link from one of the program on to the home page.")
	public void verifyApplyWorkflow() throws InterruptedException {
		SignInPage.navigateToER();
		RegisterPage.enterEmailInRegistration();
	}

	@Test(groups = { "smoke"})
	@Description("Verify the email for OTP..")
	public void verifyEmailForOTPApplyWorkflow()throws InterruptedException {
		SignInPage.navigateToER();
		String email = RegisterPage.enterEmailInRegistration();
		Yopmail.verifyOTPEmailBody(email);
	}

	@Test(groups = { "smoke" })
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyRegistrationFromApplyWorkflow() throws InterruptedException {
		SignInPage.navigateToPMG();
		RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		ApplicationsListingPage.verifyApplicationPageForPMG();
	}

	@Test(groups = { "smoke"})
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyEmailNotificationsToCustomerForApplyWorkFlow() throws InterruptedException {
		SignInPage.navigateToER();
		String email = RegisterPage.enterEmailInRegistration();
		RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
		Yopmail.verifyRegistrationEmailBody(email);
	}
         // 18 and 19 are CRM Based
}
