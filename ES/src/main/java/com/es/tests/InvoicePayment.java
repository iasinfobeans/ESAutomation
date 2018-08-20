package com.es.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.OverlayPage;
import com.es.pom.PaymentHistoryPage;
import com.es.pom.CardDetailsPage;
import com.es.pom.PaymentPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;

import io.qameta.allure.Description;

public class InvoicePayment extends Setup {

	@Test(groups = {"smoke", "InvoicePayment"})
	@Description("Verify the displayed details on Payment page")
	public static void verifyInvoicePaymentPageElements() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.verifyPaymentPageElementsForInvoice();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyInvoicePaymentPageElements");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify that on clicking the 'Pay' button, the user is navigated to the Payment Gateway")
	public static void verifyNavigationToPaymentGateway() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.paymentGatewayPageVerification();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyNavigationToPaymentGateway");
			e.getStackTrace(); 
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify that customer is able to make part payment for an invoice")
	public static void verifyInvoicePayment() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyInvoicePayment");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify that the invoice payment can be submitted successfully with valid Payment details")
	public static void verifySuccessfulPaymentSubmissionForInvoice() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyPaymentSucess();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySuccessfulPaymentSubmissionForInvoice");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify the Balance due amount on the Portal")
	public static void verifyDueAmount() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyPaymentSucess();
			DashboardPage.navigatingToMyInvoicesWhenLoggedInAlready();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.compareBalanceAmountBeforAndAfterPay();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyDueAmount");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify mail sent to customer/payee on making payment for an Invoice")
	public static void verifyPaymentMail_Customer() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			Yopmail.verifyPaymentForInvoiceMail(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPaymentMail_Customer");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke","InvoicePayment"})
	@Description("Verify mail sent to staff when customer makes payment for an Invoice")
	public static void verifyPaymentMail_Staff() throws IOException, InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.navigatingToMyInvoices();
			InvoiceListingPage.navigateToPaymentPage();
			PaymentPage.fillPaymentPageFormForInvoice();
			PaymentPage.navigateToPaymentGatewayPage();
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			Yopmail.verifyPaymentForInvoiceReceivedMail(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyPaymentMail_Staff");
			e.getStackTrace();
			throw e;
		}
	}
}