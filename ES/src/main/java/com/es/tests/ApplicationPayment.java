package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.DashboardPage;
import com.es.pom.OverlayPage;
import com.es.pom.PaymentPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class ApplicationPayment extends Setup {

	@Test(groups = {"smoke","ApplicationPayment"})
	@Description("Verify the displayed details on Payment page")
	public static void verifyPaymentPageDetailsForApplication() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigateToApplicationListingPage();
			ApplicationsListingPage.navigateToPaymentPage();
			PaymentPage.verifyPaymentPageElementsForApplication();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPaymentPageDetailsForApplication");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","ApplicationPayment"})
	@Description("Verify the displayed details on Payment page")
	public static void verifyNavigationToPaymentGateway() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigateToApplicationListingPage();
			ApplicationsListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForApplication();
			PaymentPage.navigateToPaymentGatewayPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyNavigationToPaymentGateway");
			e.getStackTrace();
			throw e;
		}
	}
	
}