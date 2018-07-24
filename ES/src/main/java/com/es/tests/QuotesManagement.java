package com.es.tests;
import org.testng.annotations.Test;

import com.es.pom.ApplicationPageForQuotation;
import com.es.pom.AvaliableQuotesPage;
import com.es.pom.DashboardPage;
import com.es.pom.GetAQuotePage;
import com.es.pom.QuotationListingPage;
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
			QuotationListingPage.verifyGetAQuoteButton();
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
			QuotationListingPage.customerClickOnGetAQuoteButton();
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
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote( Prop.getTestData("productType"), Prop.getTestData ("productDescription"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerReportforQuote");
			e.getStackTrace();
			throw e;
		}
	}

	// 167-178 CRM based 

	@Test(groups = {"smoke" })
	@Description("Verify the different statuses of the quotation request.")
	public void verifyStatusesOfQuotationRequest() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequest");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = {"smoke" })
	@Description("Verify the status of the Quotation request once the application is saved.")
	public void verifyStatusesOfQuotationRequestApplicationSaved() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),Prop.getTestData("companyLegalStatus"),Prop.getTestData("mailingAddress"),Prop.getTestData("city"),Prop.getTestData("state"),Prop.getTestData("zip"),Prop.getTestData("companyPhoneNumber"),Prop.getTestData("companyEmailAddress"),Prop.getTestData("subjectOfReport"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequestApplicationSaved");
			e.getStackTrace();
			throw e;
		}
	}
}

//181-185 crm


