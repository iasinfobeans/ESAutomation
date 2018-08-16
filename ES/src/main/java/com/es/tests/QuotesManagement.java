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

public class QuotesManagement extends Setup {

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that a 'Get a Quote' button is present on the Quotation Listing page for the customer.")
	public void verifyGetAQuoteButtonOnQuotationListingPage() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyGetAQuoteButtonOnQuotationListingPage");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that the customer is able to click on the Get a Quote button.")
	public void verifyCustomerClickOnGetAQuoteButton() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyGetAQuoteButton();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerClickOnGetAQuoteButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that the customer is able to request for a quote.")
	public void verifyCustomerReportforQuote() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerReportforQuote");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that once the quote is submitted, the staff is notified about the same.")
	public void verifyStaffNotifiedForQuote() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			Yopmail.verifyQuotationReceivedByStaff(Prop.getTestData("EmailId"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffNotifiedForQuote");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that once the quote is submitted, the customer is notified about the same.")
	public void verifyCustomerNotifiedForQuote() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			GetAQuotePage.verifyCustomerRequestforQuote(Prop.getTestData("productType"),
					Prop.getTestData("productDescription"));
			Yopmail.verifyQuotationSubmitByCustomer(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerNotifiedForQuote");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify the different statuses of the quotation request.")
	public void verifyStatusesOfQuotationRequest() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.verifyApplicationPageForViewQuote();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequest");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that once the quote is submitted, the staff is notified about the same..")
	public void verifyStatusesOfQuotationRequestApplicationSaved() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStatusesOfQuotationRequestApplicationSaved");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff is able to verify number of quotes in View Quotes column .")
	public void verifyNumberOfQuote() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNumberOfQuote");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff is able to click on the view button.")
	public void verifyViewButton() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyViewOption();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyViewButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that the staff is able to view pop up window.")
	public void verifyViewButtonWithPopPupWindow() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyViewOption();
			DashboardPage.verifyPopUpWindowForView();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyViewButtonWithPopPupWindow");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff is able to view pop up window.")
	public void verifyUploadButton() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUploadButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the Expiry date is a mandatory field & it  is defaulted with a date 30 days ahead from the current date.")
	public void verifyExpiryDateDefaultedWithThirtyDaysAhead() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.checkExpiryDate();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyExpiryDateDefaultedWithThirtyDaysAhead");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that once the staff creates a quote, a notification email is sent to the customer along with the quote file as attachment.")
	public void verifyAfterGivenInputInUploadOption() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyAfterGivenInputInUploadOption");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify the email triggered to the customer once the staff creates a quote.")
	public void verifyCustomerMailAfterGivenInputInUploadOption() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			Yopmail.verifyNewQuotationAvailableMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerMailAfterGivenInputInUploadOption");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff should be able to delete any quote if it has not been used to apply for an application.")
	public void verifyDeleteQuoteByStaff() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			Thread.sleep(10000);
			QuotationListingPage.viewQuotesOptions();
			QuotationListingPage.deleteQuoteByStaff();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyDeleteQuoteByStaff");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the staff person, on receiving the quotation request, will have an option to upload a quote.")
	public void verifyUploadOptionForStaffOnQuotationRequest() throws Exception {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			QuotationListingPage.inputForProductType(Prop.getTestData("productType"));
			QuotationListingPage.inputForProductDescription(Prop.getTestData("productDescription"));
			QuotationListingPage.submitQuotationRequest();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUploadOptionForStaffOnQuotationRequest");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify the different statuses of the quotation request.")
	public void verifyDifferentStatusesOfQuotationRequest() throws Exception {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyDifferentStatus();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyDifferentStatusesOfQuotationRequest");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that if customer has applied for the quote and saved the application, the quote would not be allowed to be used for submitting another application.")
	public void verifyCustomerAppliedForQuoteAndSaveApplication() throws InterruptedException {
		try {
			//Pre-requisites Steps
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			QuotationListingPage.inputForProductType(Prop.getTestData("productType"));
			QuotationListingPage.inputForProductDescription(Prop.getTestData("productDescription"));
			QuotationListingPage.submitQuotationRequest();
			Thread.sleep(10000);
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			Thread.sleep(10000);
			DashboardPage.logout();
			//Actual test case steps
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.viewQuotesOptions();			
			AvaliableQuotesPage.applyForViewQuotesOptions();
			ApplicationPageForQuotation.fillApplication(Prop.getTestData("companyName"),
					Prop.getTestData("companyLegalStatus"), Prop.getTestData("mailingAddress"),
					Prop.getTestData("city"), Prop.getTestData("state"), Prop.getTestData("zip"),
					Prop.getTestData("companyPhoneNumber"), Prop.getTestData("companyEmailAddress"),
					Prop.getTestData("subjectOfReport"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCustomerAppliedForQuoteAndSaveApplication");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the Quotation amount would be basic fees for the application.")
	public void verifyQuotationAmountWithBasicFees() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			QuotationListingPage.inputForProductType(Prop.getTestData("productType"));
			QuotationListingPage.inputForProductDescription(Prop.getTestData("productDescription"));
			QuotationListingPage.submitQuotationRequest();
			Thread.sleep(10000);
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			Thread.sleep(10000);
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
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
			ApplicationPageForQuotation.submitApplication();
			ApplicationPageForQuotation.agreementCheckBox();
			ApplicationPageForQuotation.submitAgreement();
			ApplicationPageForQuotation.pay();
			ApplicationPageForQuotation.observFees();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyQuotationAmountWithBasicFees");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement"})
	@Description("Verify that the customer cannot apply for a coupon discount for applications applied through a quote request.")
	public void verifyCouponDiscountApplicableOrNotForQuotation() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
			QuotationListingPage.verifyGetAQuoteButton();
			QuotationListingPage.customerClickOnGetAQuoteButton();
			QuotationListingPage.inputForProductType(Prop.getTestData("productType"));
			QuotationListingPage.inputForProductDescription(Prop.getTestData("productDescription"));
			QuotationListingPage.submitQuotationRequest();
			Thread.sleep(10000);
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyQuotationOption();
			DashboardPage.verifyUploadOption();
			DashboardPage.verifyPopUpWindowForUpload();
			DashboardPage.InputValuesInUploadOption(Prop.getTestData("programType"), Prop.getTestData("amount"));
			QuotationListingPage.verifyFileUploadedOrNot();
			DashboardPage.clickSendWhileUploadingQuotation();
			QuotationListingPage.verifyQuotationUploaded();
			Thread.sleep(10000);
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
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
			ApplicationPageForQuotation.submitApplication();
			ApplicationPageForQuotation.agreementCheckBox();
			ApplicationPageForQuotation.submitAgreement();
			ApplicationPageForQuotation.pay();
			ApplicationPageForQuotation.observFees();
			ApplicationPageForQuotation.couponOption();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyCouponDiscountApplicableOrNotForQuotation");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "QuotesManagement" })
	@Description("Verify that if the customer has selected the quote and saved/submitted the application, but tries to make payment after the expiration date of the quote, then for such applications, the customer should not be able to make the payment.")
	public void verifyPaymentAfterExpiryDate() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("username"), Prop.getTestData("password"), "Customer");
			DashboardPage.verifyQuotationOption();
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
			ApplicationPageForQuotation.submitApplication();
			ApplicationPageForQuotation.agreementCheckBox();
			ApplicationPageForQuotation.submitAgreement();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyPaymentAfterExpiryDate");
			e.getStackTrace();
			throw e;
		}
	}
}
