package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.PaymentPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class InvoicePayment extends Setup {

	@Test(groups = {"smoke"})
	@Description("Verify the displayed details on Payment page")
	public static void verifyInvoicePaymentPageElements() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.verifyPaymentPageElements();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyInvoicePaymentPageElements");
			e.getStackTrace();
			throw e;
		}
	}
}
