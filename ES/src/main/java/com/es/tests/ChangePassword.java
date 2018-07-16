package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ChangePasswordPage;
import com.es.pom.DashboardPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Description;

public class ChangePassword extends Setup {

	@Test(groups = {"smoke"},enabled=false)
	@Description("Verify that customer is able to reset the password using the forgot password functionality")
	public static void verifyChangePasswordFlow() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("usertotest"),Prop.getTestData("passwordToTest"), "Customer");
			DashboardPage.verifyDashboardPage();
			DashboardPage.navigateToChangePasswordPage();
			ChangePasswordPage.changePassword();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyChangePasswordFlow");
			e.getStackTrace();
			throw e;
		}
	}


}
