package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.ApplicationPageForQuotation;
import com.es.pom.AvaliableQuotesPage;
import com.es.pom.DashboardPage;
import com.es.pom.DependsOn;
import com.es.pom.GetAQuotePage;
import com.es.pom.OverlayPage;
import com.es.pom.PaymentPage;
import com.es.pom.QuotationListingPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.AdminLogin;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class QuotesManagement extends Setup {

	@Test(groups = { "smoke", "QuotesManagement"},dependsOnMethods="verifyCustomerNotifiedForQuote")
	@Description("Verify that a 'Get a Quote' button is present on the Quotation Listing page for the customer.")
	public void verifyGetAQuoteButtonOnQuotationListingPage() throws InterruptedException {
		DependsOn.dependsOnMethod("	Verify that once the quote is submitted, the customer is notified about the same.","verifyCustomerNotifiedForQuote");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyGetAQuoteButtonOnQuotationListingPage");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "QuotesManagement" },dependsOnMethods="verifyCustomerNotifiedForQuote")
	@Description("Verify that the customer is able to click on the Get a Quote button.")
	public void verifyCustomerClickOnGetAQuoteButton() throws InterruptedException {
		DependsOn.dependsOnMethod("	Verify that once the quote is submitted, the customer is notified about the same.","verifyCustomerNotifiedForQuote");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyGetAQuoteButton();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerClickOnGetAQuoteButton");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "QuotesManagement" },dependsOnMethods="verifyCustomerNotifiedForQuote")
	@Description("Verify that the customer is able to request for a quote.")
	public void verifyCustomerRequestforQuote() throws InterruptedException {
		DependsOn.dependsOnMethod("	Verify that once the quote is submitted, the customer is notified about the same.","verifyCustomerNotifiedForQuote");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerReportforQuote");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "QuotesManagement"},dependsOnMethods="verifyCustomerNotifiedForQuote")
	@Description("Verify that once the quote is submitted, the staff is notified about the same.")
	public void verifyStaffNotifiedForQuote() throws InterruptedException {
		DependsOn.dependsOnMethod("	Verify that once the quote is submitted, the customer is notified about the same.","verifyCustomerNotifiedForQuote");
		/*
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			Yopmail.verifyQuotationReceivedByStaff(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffNotifiedForQuote");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=1,groups = { "smoke", "QuotesManagement"})
	@Description("Verify that once the quote is submitted, the customer is notified about the same.")
	public void verifyCustomerNotifiedForQuote() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			Yopmail.verifyQuotationSubmitByCustomer(Prop.getTestData("username"));
			Yopmail.verifyQuotationReceivedByStaff(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerNotifiedForQuote");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"},dependsOnMethods="verifyESstaffUploadMultipleQuotes")
	@Description("Verify that the staff person, on receiving the quotation request, will have an option to upload a quote.")
	public void verifyUploadOptionForStaffOnQuotationRequest() throws Exception {
		DependsOn.dependsOnMethod("Verify that the ES staff can upload multiple quotes.","verifyESstaffUploadMultipleQuotes");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUploadOptionForStaffOnQuotationRequest");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "QuotesManagement" },dependsOnMethods="verifyESstaffUploadMultipleQuotes")
	@Description("Verify the View Quotes column to have the number of quotes that the staff has uploaded for a particular Quotation No.")
	public void verifyNumberOfQuote() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that the ES staff can upload multiple quotes.","verifyESstaffUploadMultipleQuotes");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNumberOfQuote");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(groups = { "smoke", "QuotesManagement" },dependsOnMethods="verifyViewButtonWithPopPupWindow")
	@Description("Verify that the staff is able to click on the view button.")
	public void verifyViewButton() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that the staff is able to view pop up window.","verifyViewButtonWithPopPupWindow");
		/*try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyViewOption();
			QuotationListingPage.verifyQuotationRequest();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyViewButton");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=2,groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff is able to view pop up window.")
	public void verifyViewButtonWithPopPupWindow() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyViewOption();
			QuotationListingPage.verifyPopUpWindowForView();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyViewButtonWithPopPupWindow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"},dependsOnMethods="verifyESstaffUploadMultipleQuotes")
	@Description("Verify that the staff is able to click on the Upload button")
	public void verifyUploadButton() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that the ES staff can upload multiple quotes.","verifyESstaffUploadMultipleQuotes");
		/*try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.verifyPopUpWindowForUpload();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUploadButton");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=3,groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the Expiry date is a mandatory field & it  is defaulted with a date 30 days ahead from the current date.")
	public void verifyExpiryDateDefaultedWithThirtyDaysAhead() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			Thread.sleep(3000);
			QuotationListingPage.checkExpiryDateDefaultedWithThirtyDaysAhead();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyExpiryDateDefaultedWithThirtyDaysAhead");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=4,groups = { "smoke", "QuotesManagement" })
	@Description("Verify that once the staff creates a quote, a notification email is sent to the customer along with the quote file as attachment.")
	public void verifyNotificationEmailAndQuoteFile() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			Yopmail.verifyNewQuotationAvailableMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNotificationEmailAndQuoteFile");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=5,groups = { "smoke", "QuotesManagement" })
	@Description("Verify the email triggered to the customer once the staff creates a quote.")
	public void verifyCustomerMailAfterGivenInputInUploadOption() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			Thread.sleep(3000);
			QuotationListingPage.clickSendWhileUploadingQuotation();
			Yopmail.verifyNewQuotationAvailableMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerMailAfterGivenInputInUploadOption");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=6,groups = { "smoke", "QuotesManagement" })
	@Description("Verify that the staff should be able to delete any quote if it has not been used to apply for an application.")
	public void verifyDeleteQuoteByStaff() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();
			QuotationListingPage.deleteQuoteByStaff();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyDeleteQuoteByStaff");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=7,groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the ES staff can upload multiple quotes.")
	public void verifyESstaffUploadMultipleQuotes() throws InterruptedException {
		int fileCount = 7;
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			for (i = 0; i < fileCount; i++) {
				SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
				DashboardPage.verifyQuotationOption();
				QuotationListingPage.verifyUploadOption();
				QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),
						Prop.getTestData("amount"));
				QuotationListingPage.verifyFileUploadedOrNot();
				QuotationListingPage.clickSendWhileUploadingQuotation();
				QuotationListingPage.verifyQuotationUploaded();
				DashboardPage.logout();
			}
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyESstaffUploadMultipleQuotes");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=8,groups = { "smoke", "QuotesManagement" })
	@Description("Verify the different statuses of the quotation request.")
	public void verifyDifferentStatusesOfQuotationRequest() throws Exception {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyDifferentStatus();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyDifferentStatusesOfQuotationRequest");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"},dependsOnMethods="verifyStatusesOfQuotationRequestOnceApplicationSaved") 
	@Description("Verify that the customer is allowed to fill one application against one quotation.")
	public void verifyCustomerAllowedFillOneApplicationQuotation() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify the status of the Quotation request once the application is saved.","verifyStatusesOfQuotationRequestOnceApplicationSaved");
		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),
					Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();

			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewActiveStatusofQuote();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequest");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=9,groups = { "smoke", "QuotesManagement"}) 
	@Description("Verify the status of the Quotation request once the application is saved.")
	public void verifyStatusesOfQuotationRequestOnceApplicationSaved() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),
					Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();

			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewActiveStatusofQuote();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
			ApplicationPageForQuotation.verifySaveReport();
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyStatus();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequestApplicationSaved");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=10,groups = { "smoke", "QuotesManagement"})
	@Description("Verify that if customer has applied for the quote and saved the application, the quote would not be allowed to be used for submitting another application.")
	public void verifyAppliedQuoteNotAllowedSubmittingAnotherApplication() throws Exception {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewExpiredStatusofQuote();
			QuotationListingPage.viewQuotesOptionsForExpiredQuotes();
			AvaliableQuotesPage.verifyAppliedQuote();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyAppliedQuoteNotAllowedSubmittingAnotherApplication");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" },dependsOnMethods="verifyCouponDiscountApplicableOrNotForQuotation") 
	@Description("Verify that the Quotation amount would be basic fees for the application.")
	public void verifyQuotationAmountWithBasicFees() throws InterruptedException {
		DependsOn.dependsOnMethod("Verify that the customer cannot apply for a coupon discount for applications applied through a quote request.","verifyCouponDiscountApplicableOrNotForQuotation");

		/*try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),
					Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();

			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewActiveStatusofQuote();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
			ApplicationPageForQuotation.fillContactDetails(Prop.getTestData("technicalRepresentativeName"),
					Prop.getTestData("authSignatoryName"), Prop.getTestData("billingRepresentativeName"),
					Prop.getTestData("technicalRepresentativeEmail"), Prop.getTestData("authSignatoryEmail"),
					Prop.getTestData("billingRepresentativeEmail"));
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
			ApplicationPageForQuotation.submitApplication();
			ApplicationPageForQuotation.agreementCheckBox();
			ApplicationPageForQuotation.submitAgreement();
			ApplicationPageForQuotation.pay();
			ApplicationPageForQuotation.observeBasicFees();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyQuotationAmountWithBasicFees");
			e.getStackTrace();
			throw e;
		}*/
	}

	@Test(priority=11, groups = { "smoke", "QuotesManagement"}) 
	@Description("Verify that the customer cannot apply for a coupon discount for applications applied through a quote request.")
	public void verifyCouponDiscountApplicableOrNotForQuotation() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyUploadOption();
			QuotationListingPage.inputValuesInUploadOption(Prop.getTestData("programType"),
					Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();

			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewActiveStatusofQuote();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
			ApplicationPageForQuotation.fillContactDetails(Prop.getTestData("technicalRepresentativeName"),
					Prop.getTestData("authSignatoryName"), Prop.getTestData("billingRepresentativeName"),
					Prop.getTestData("technicalRepresentativeEmail"), Prop.getTestData("authSignatoryEmail"),
					Prop.getTestData("billingRepresentativeEmail"));
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
			ApplicationPageForQuotation.submitApplication();
			ApplicationPageForQuotation.agreementCheckBox();
			ApplicationPageForQuotation.submitAgreement();
			ApplicationPageForQuotation.pay();
			ApplicationPageForQuotation.observeBasicFees();
			ApplicationPageForQuotation.couponOption();
			ApplicationPageForQuotation.customerDetailsForQuotation(Prop.getTestData("billingAddress"),
					Prop.getTestData("city"),Prop.getTestData("zip"), Prop.getTestData("phone"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCouponDiscountApplicableOrNotForQuotation");
			e.getStackTrace();
			throw e;
		}
	}


	@Test(priority=12,groups = { "smoke", "QuotesManagement"}) 
	@Description("Verify that if the customer has selected the quote and saved/submitted the application, but tries to make payment after the expiration date of the quote, then for such applications, the customer should not be able to make the payment.")
	public void verifyPaymentAfterExpiryDate() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.expiredQuotationNumber(Prop.getTestData("expiredQuotationNumber"));
			QuotationListingPage.viewExpiredQuotesOptions();
			AvaliableQuotesPage.viewQuotesForExpiredQuote();
			ApplicationPageForQuotation.payForExpiredQuote();
			PaymentPage.paymenAfterExpirationDate();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyPaymentAfterExpiryDate");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(priority=13,groups = { "smoke", "QuotesManagement" ,"priority=23"})
	@Description("Customer has requested for a quotation; Staff has send the quote; It should be 7 or 2 or 1 day(s) before the expiration date.")
	public void verifyStaffSendQuoteBeforeExpirationDate() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.clickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.quoteBeforeExpirationDate(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			QuotationListingPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			DashboardPage.logout();
			AdminLogin.runJobForQuoteExpiry();
			Yopmail.verifyExpiryDateForQuotationMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffSendQuoteBeforeExpirationDate()");
			e.getStackTrace();
			throw e;
		}
	}
}