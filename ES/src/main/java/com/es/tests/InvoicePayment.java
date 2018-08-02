package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.PaymentHistoryPage;
import com.es.pom.CardDetailsPage;
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
	
	@Test(groups = {"smoke"})
	@Description("Verify that on clicking the 'Pay' button, the user is navigated to the Payment Gateway")
	public static void verifyNavigationToPaymentGateway() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageForm();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.paymentGatewayPageVerification();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyNavigationToPaymentGateway");
			e.getStackTrace(); 
			throw e;
		}
	}
	
	@Test(groups = {"smoke"})
	@Description("Verify that customer is able to make part payment for an invoice")
	public static void verifyInvoicePayment() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageForm();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyInvoicePayment");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke"})
	@Description("Verify that the invoice payment can be submitted successfully with valid Payment details")
	public static void verifySuccessfulPaymentSubmissionForInvoice() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageForm();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyPaymentSucess();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySuccessfulPaymentSubmissionForInvoice");
			e.getStackTrace();
			throw e;
		}
	}
	
}
