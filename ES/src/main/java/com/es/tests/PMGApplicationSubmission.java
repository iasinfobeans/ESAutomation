package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;

import com.es.pom.ApplicationsListingPage;
import com.es.pom.DashboardPage;
import com.es.pom.OverlayPage;
import com.es.pom.PMGApplicationFormPage;
import com.es.pom.RegisterPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.CRM;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;
public class PMGApplicationSubmission extends Setup {

	@Test(groups = {"smoke", "PMGApplicationSubmission"})
	@Description("Verify that the customer is able to submit the pmg application")
	public static void verifyPmgApplicationFormSubmit_UnapprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPmgApplicationFormSubmit_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the PMG Application submiited email received by the customer.")
	public static void verifyEmailRecievedForPMGApplication_UnapprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgramWithNoPopup();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
			Yopmail.verifyPMGApplicationSubmitByNonApprovedUser(Prop.getTestData("unApprovedUser"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that a non approved user is able to sign the application as the authorized signatory while submitting the application")
	public static void verifySubmitterCanSignApplication_UnApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("unApprovedUser"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySubmitterCanSignApplication_UnApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the subject line and email content for the notification triggered to an unapproved user on signing & submitting the application.")
	public static void verifyEmailForSigningAndSubmittingApplication_UnApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("unApprovedUser"),Prop.getTestData("unApprovedUserPassword"), "Customer");
			//OverlayPage.skipoverlayPage();
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("unApprovedUser"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			Yopmail.verifyPMGApplicationSubmitByNonApprovedUser(Prop.getTestData("unApprovedUser"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailForSigningAndSubmittingApplication_UnApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the case when lead is being qualified on CRM")
	public static void verifyLeadQualifyFromCrm_UnapprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.navigateToPMG();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			PMGApplicationFormPage.PmgApplicationFormFill(email);
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			CRM.qualifyLeadInCRM(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"),Prop.getTestData("Name"), email);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the case when lead is being disqualified from CRM")
	public static void verifyLeadDisQualifyFromCrm_UnapprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.navigateToPMG();
			String email = RegisterPage.enterEmailInRegistration();
			RegisterPage.enterPersonalInfoInRegistration(Prop.getTestData("firstName"), Prop.getTestData("lastName"),
					Prop.getTestData("companyName"), Prop.getTestData("phone"), Prop.getTestData("newPassword"),
					Prop.getTestData("confirmPassword"),email);
			PMGApplicationFormPage.PmgApplicationFormFill(email);
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			CRM.disQualifyLeadInCRM(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"),Prop.getTestData("Name"), email);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_UnapprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	//27
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that the approved customer is able to submit the pmg application")
	public static void verifyPmgApplicationFormSubmit_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPmgApplicationFormSubmit_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	//28
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that if the authorized signatory is same as the submitter of the application, then the submitter should be allowed to sign the application at the time of submission itself")
	public static void verifySubmitterCanSignApplication_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySubmitterCanSignApplication_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that if the submitter (authorized signatory) does not check the signature checkbox, the application would not be submitted.")
	public static void verifySubmitterHasToSignApplicationToSubmitIt_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.clickSubmitPMGApplication();
			PMGApplicationFormPage.checkIfApplicationNotSubmitted();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySubmitterHasToSignApplicationToSubmitIt_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	//30
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that the application status when the authorized signatory is the same as the submitter & submits the application")
	public static void verifyApplicationStatus_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.navigateToApplicationListingPage();
			String appId = ApplicationsListingPage.getFirstApplicationId();
			ApplicationsListingPage.checkStatus(appId);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyApplicationStatus_ApprovedUser");
			e.getStackTrace();
			throw e;
		}	
	}
	//31
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the emails triggered to customer and staff on application submission")
	public static void verifyEmaiForCustomerAndStaffOnSubmission_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
			Yopmail.verifyPMGApplicationMail(Prop.getTestData("username"));
			Yopmail.verifyPMGApplicationMailInStaffInbox(Prop.getTestData("Staffuser"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmaiForCustomerAndStaffOnSubmission_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	//32
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the subject line and email content for the notification triggered to an approved user on signing & submitting the application.")
	public static void verifyEmailForSigningAndSubmittingApplication_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgram();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
			PMGApplicationFormPage.SignAsAuthorizedSignatory();
			PMGApplicationFormPage.PmgApplicationFormSubmit();
		    Yopmail.verifyPMGApplicationMailInCustomerInbox(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailForSigningAndSubmittingApplication_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	//33
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify the email sent to the customer on submitting the application")
	public static void verifyEmailRecievedForPMGApplication_ApprovedUser() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
			Yopmail.verifyPMGApplicationMail(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_ApprovedUser");
			e.getStackTrace();
			throw e;
		}
	}
	
	//34
		@Test(groups = {"smoke","PMGApplicationSubmission"})
		@Description("Verify that email, for creating a password , is sent to the authorized signatory once the application is submitted")
		public static void verifyLinkForPassword() throws IOException, InterruptedException {
			try{
				String email = RegisterPage.generateMail();
				SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
				DashboardPage.navigateToPMGApplicationProgramApprovedUser();
				PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData(email));
				PMGApplicationFormPage.PmgApplicationFormSubmit();
				PMGApplicationFormPage.verifySuccessMessage();
				//Yopmail method 
			}catch(Exception e){
				SeleniumUtils.captureScreenshot("verifyLinkForPassword");
				e.getStackTrace();
				throw e;
			}
		}
	
	//36
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that email is sent to the authorized signatory.")
	public static void verifyEmail_AuthorizedSignatory() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			Yopmail.verifyMailInAuthorizedSignatoryInbox(Prop.getTestData("legalRepresentativeMail"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmail_AuthorizedSignatory");
			e.getStackTrace();
			throw e;
		}
	}
	
	//37
		@Test(groups = {"smoke","PMGApplicationSubmission", "Runnow"})
		@Description("Verify that authorized signatory is able to sign the application by clicking the link sent in the email")
		public static void verifyAuthorizedSignatoryCanSignByMail() throws IOException, InterruptedException {
			try{
				SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
				DashboardPage.navigateToPMGApplicationProgramApprovedUser();
				PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
				PMGApplicationFormPage.PmgApplicationFormSubmit();
				DashboardPage.logout();
				SignInPage.login(Prop.getTestData("legalRepresentativeMail"),Prop.getTestData("legalRepPassword"), "Customer");
				Yopmail.verifyDeliveredSigningMailLinks(Prop.getTestData("legalRepresentativeMail"));
			}catch(Exception e){
				SeleniumUtils.captureScreenshot("verifyAuthorizedSignatoryCanSignByMail");
				e.getStackTrace();
				throw e;
			}
		}
	
	//38
	@Test(groups = {"smoke","PMGApplicationSubmission", "38"})
	@Description("Verify that an email is sent to the submitter of the application after the signatures have been received")
	public static void verifyEmailAfterSigningBySignatory() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("legalRepresentativeMail"),Prop.getTestData("legalRepPassword"), "Customer");
			Yopmail.verifyDeliveredSigningMailLinks(Prop.getTestData("legalRepresentativeMail"));
			Yopmail.verifySignaturesReceivedMail(Prop.getTestData("username"));
			//Sign the application method
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmailAfterSigningBySignatory");
			e.getStackTrace();
			throw e;
		}
	}
	
	//39
	@Test(groups = {"smoke","PMGApplicationSubmission"})
	@Description("Verify that an email is sent to the ES-staff after the signatures have been received")
	public static void verifyEmaiForStaffAfterSubmissionForSignature() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToPMGApplicationProgramApprovedUser();
			PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("legalRepresentativeMail"));
			PMGApplicationFormPage.PmgApplicationFormSubmit();
			PMGApplicationFormPage.verifySuccessMessage();
			Yopmail.verifyPMGApplicationMailInStaffInbox(Prop.getTestData("Staffuser"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyEmaiForStaffAfterSubmissionForSignature");
			e.getStackTrace();
			throw e;
		}
	}
	
	//40
		@Test(groups = {"smoke","PMGApplicationSubmission"})
		@Description("Verify that the staff is able to review the application")
		public static void verifyStaffCanReviewApplication_ApprovedUser() throws IOException, InterruptedException {
			try{
				SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
				DashboardPage.navigateToPMGApplicationProgramApprovedUser();
				PMGApplicationFormPage.PmgApplicationFormFill(Prop.getTestData("username"));
				PMGApplicationFormPage.SignAsAuthorizedSignatory();
				PMGApplicationFormPage.PmgApplicationFormSubmit();
				DashboardPage.logout();
				SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
				DashboardPage.navigateToApplicationListingPageWhenLoggedIn();
				String appId = ApplicationsListingPage.getFirstApplicationId();
				ApplicationsListingPage.selectApplication(appId);
				ApplicationsListingPage.checkEditOptionForAGivenApplication(appId);
			}catch(Exception e){
				SeleniumUtils.captureScreenshot("verifyEmailRecievedForPMGApplication_ApprovedUser");
				e.getStackTrace();
				throw e;
			}
		}
	
}