package com.es.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.es.pom.DashboardPage;
import com.es.pom.SignInPage;
import com.es.pom.UpdateProfilePage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;

import io.qameta.allure.Description;

public class ContactManagement extends Setup {

	@Test(groups = {"smoke"})
	@Description("Verify that the customers are allowed to update their own profile information")
	public static void verifyUpdateProfile() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToEditProfilePage();
			UpdateProfilePage.updateProfile();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUpdateProfile");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke"})
	@Description("Verify that the customer is able to update all the information except email address & company name")
	public static void verifyUpdateProfileWithRestrictions() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToEditProfilePage();
			UpdateProfilePage.updateRestriction();
			UpdateProfilePage.updateProfile();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUpdateProfileWithRestrictions");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke"})
	@Description("Verify that once the profile has been updated, the customer receives an email notification.")
	public static void verifyUpdateAccountEmail_Customer() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToEditProfilePage();
			UpdateProfilePage.updateRestriction();
			UpdateProfilePage.updateProfile();
			Yopmail.verifyReqForProfileUpdate(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUpdateAccountEmail_Customer");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke"})
	@Description("Verify that once the profile has been updated, the staff receives an email notification.")
	public static void verifyUpdateAccountEmail_Staff() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigateToEditProfilePage();
			UpdateProfilePage.updateProfile();
			UpdateProfilePage.updateRestriction();
			Yopmail.verifyProfileUpdatedMail(Prop.getTestData("Staffuser"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUpdateAccountEmail_Staff");
			e.getStackTrace();
			throw e;
		}
	}

}
