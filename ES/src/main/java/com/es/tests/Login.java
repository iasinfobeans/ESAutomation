package com.es.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.es.pom.DashboardPage;
import com.es.pom.QuotationRequestFormPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.CommonUtils;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Description;

public class Login extends Setup {
	private static Logger log = Logger.getLogger(Login.class.getName());

	@Test(priority = 0, groups = { "smoke" })
	@Description("Valid login with correct credentials")
	public static void testingLoginFunctionality() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyDashboardPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("testingLoginFunctionality");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority = 1, groups = { "smoke" })
	@Description("Get a quote form")
	public static void testingGetaQuoteFunctionality() throws IOException, InterruptedException {
		try{
			QuotationRequestFormPage.getAQoute();
			QuotationRequestFormPage.submitQuoteRequest();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("testingGetaQuoteFunctionality");
			e.getStackTrace();
			throw e;
		}
	}
}
