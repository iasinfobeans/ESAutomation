package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class ApplyForCustomer extends Setup{

	@Test(groups = { "smoke" })
	@Description("Verify that user is able to register on the portal using the Apply Link from one of the program on to the home page.")
	public void verifyApplyWorkflow() throws InterruptedException {
		try{
			SignInPage.navigateToER();
			RegisterPage.enterEmailInRegistration();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyApplyWorkflow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke"})
	@Description("Verify the email for OTP..")
	public void verifyEmailForOTPApplyWorkflow()throws InterruptedException {
		try{
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			Yopmail.verifyOTPEmailBody(email);}catch(Exception e){
				SeleniumUtils.captureScreenshot("verifyEmailForOTPApplyWorkflow");
				e.getStackTrace();
				throw e;
			}
	}

	@Test(groups = { "smoke" })
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyRegistrationFromApplyWorkflow() throws InterruptedException {
		try{	
			SignInPage.navigateToPMG();
			RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
			ApplicationsListingPage.verifyApplicationPageForPMG();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRegistrationFromApplyWorkflow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke"})
	@Description("Verify the registration process once correct OTP and other fields are entered.")
	public void verifyEmailNotificationsToCustomerForApplyWorkFlow() throws InterruptedException {
		try{	
			SignInPage.navigateToER();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),Prop.getTestData("companyName"),Prop.getTestData("phone"),Prop.getTestData("newPassword"),Prop.getTestData("confirmPassword"));
			Yopmail.verifyRegistrationEmailBody(email);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailNotificationsToCustomerForApplyWorkFlow");
			e.getStackTrace();
			throw e;
		}
	}
}

//18 and 19 are CRM Based
