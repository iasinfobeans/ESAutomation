package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.OverlayPage;
import com.es.pom.PaymentPage;
import com.es.pom.ProjectListingPage;
import com.es.pom.ReportsPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class ReportRenewalWorkflow extends Setup{

	@Test(groups = { "smoke" })
	@Description("Verify the customer Dashboard to have an additional head titled 'Reports (Pending Renewal.")
	public void verifyGetAQuoteButtonOnQuotationListingPage() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyTitleReports();
			ReportsPage.verifyTitleReport();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyGetAQuoteButtonOnQuotationListingPage");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" }) 
	@Description("Verify the actions available on hovering over any report.")
	public void verifyactionsAvailableHoveringOverAnyReport() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.actionsAvailableHoveringOverAnyReport();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyactionsAvailableHoveringOverAnyReport");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify the action on clicking the 'Pay' button")
	public void verifyActionOnPayButton() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.verifyPaymentPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyActionOnPayButton()");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = { "smoke" })  
	@Description("Verify the action on clicking the 'View Projects' button")
	public void verifyActionOnViewInvoicessButton() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnViewProjectsButton();
			ProjectListingPage.verifyViewProjectsPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyActionOnViewInvoicessButton()");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = { "smoke" })  
	@Description("Verify the action on clicking the 'View Invoices' button")
	public void verifyActionOnViewInvoicesButton() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnViewInvoicesButton();
			InvoiceListingPage.verifyViewInvoicesPage();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyActionOnViewInvoicesButton(");
			e.getStackTrace();
			throw e;
		}
	}
	
}

