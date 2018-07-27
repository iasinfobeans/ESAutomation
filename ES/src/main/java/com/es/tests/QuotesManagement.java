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
import com.es.util.Yopmail;
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
	public void verifyCustomerRequestforQuote() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote( Prop.getTestData("productType"), Prop.getTestData ("productDescription"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerRequestforQuote");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke" })
	@Description("Verify that once the quote is submitted, the staff is notified about the same.")
	public void verifyStaffNotifiedForQuote() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote( Prop.getTestData("productType"), Prop.getTestData ("productDescription"));
			Yopmail.verifyQuotationReceivedByStaff( Prop.getTestData("EmailId"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffNotifiedforQuote");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke" })
	@Description("Verify that once the quote is submitted, the customer is notified about the same.")
	public void verifyCustomerNotifiedForQuote() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote( Prop.getTestData("productType"), Prop.getTestData ("productDescription"));
			Yopmail.verifyQuotationSubmitByCustomer(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerReportforQuote");
			e.getStackTrace();
			throw e;
		}
	}

	// 167-185 CRM based 

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
	@Description("Verify that once the quote is submitted, the staff is notified about the same..")
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
	
	@Test(groups = {"smoke" })
	@Description("Verify that the staff is able to verify number of quotes in View Quotes column .")
	public void verifyNumberOfQuote() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyNumberOfQuote");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke" })
	@Description("Verify that the staff is able to click on the view button.")
	public void verifyViewButton() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyViewOption();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyViewButton");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"smoke" })
	@Description("Verify that the staff is able to view pop up window.")
	public void verifyViewButtonWithPopPupWindow() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyViewOption();
			DashboardPage.verifyPopUpWindowForView();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyViewButtonWithPopPupWindow");
			e.getStackTrace();
			throw e;
		}
	}

}


