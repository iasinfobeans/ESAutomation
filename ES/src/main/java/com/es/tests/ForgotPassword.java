package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ForgotPasswordPage;
import com.es.pom.ResetPasswordPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;

import io.qameta.allure.Description;

public class ForgotPassword extends Setup {

	@Test(groups = {"smoke"})
	@Description("Verify that customer is able to reset the password using the forgot password functionality")
	public static void verifyForgotPasswordFlow() throws IOException, InterruptedException {
		try{
			SignInPage.navigateToForgotPassword();
			ForgotPasswordPage.resetPassword(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyForgotPasswordFlow");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke"})
	@Description("Verify that an email with password reset link is sent to the customer")
	public static void verifyPasswordResetMailisSent() throws IOException, InterruptedException {
		try{
			SignInPage.navigateToForgotPassword();
			ForgotPasswordPage.resetPassword(Prop.getTestData("username"));
			Yopmail.verifyPassResetEmailBody(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyForgotPasswordFlow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke"})
	@Description("Verify that customer is able to reset the password after clicking the link in the email")
	public static void verifydResetPasswordFromMail() throws IOException, InterruptedException {
		try{
			SignInPage.navigateToForgotPassword();
			ForgotPasswordPage.resetPassword(Prop.getTestData("username"));
			String resetPasswordLink = Yopmail.getPasswordResetLink(Prop.getTestData("username"));
			ResetPasswordPage.changePassword(resetPasswordLink);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyForgotPasswordFlow");
			e.getStackTrace();
			throw e;
		}
	}

}
