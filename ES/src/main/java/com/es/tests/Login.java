package com.es.tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class Login extends Setup {

	@Test(groups = { "smoke" })
	@Description("Verify that a customer is able to login into the portal")
	public static void verifyLoginAsCustomer() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyDashboardPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyLoginAsCustomer");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })
	@Description("Verify that a ES Staff member is able to login into the portal")
	public static void verifyLoginAsStaff() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyDashboardPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyLoginAsStaff");
			e.getStackTrace();
			throw e;
		}
	}
}
