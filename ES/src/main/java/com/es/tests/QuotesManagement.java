package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.GetAQuotePage;
import com.es.pom.QuotationPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class QuotesManagement extends Setup{
	
	@Test(groups = { "smoke" })
	@Description("Verify that a 'Get a Quote' button is present on the Quotation Listing page for the customer.")
	public void verifyGetAQuoteButtonOnQuotationListingPage() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationPage.verifyGetAQuoteButton();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyGetAQuoteButtonOnQuotationListingPage");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })
	@Description("Verify that the customer is able to click on the Get a Quote button.")
	public void verifyCustomerClickOnGetAQuoteButton() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyGetAQuoteButton();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerClickOnGetAQuoteButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke" })
	@Description("Verify that the customer is able to request for a quote.")
	public void verifyCustomerReportforQuote() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerReportforQuote( Prop.getTestData("productType"), Prop.getTestData ("productDescription"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerReportforQuote");
			e.getStackTrace();
			throw e;
		}
	}
}