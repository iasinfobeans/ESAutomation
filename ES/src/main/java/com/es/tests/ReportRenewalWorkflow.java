package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.ApplicationsListingPage;
import com.es.pom.CardDetailsPage;
import com.es.pom.DashboardPage;
import com.es.pom.InvoiceListingPage;
import com.es.pom.OverlayPage;
import com.es.pom.PaymentHistoryPage;
import com.es.pom.PaymentPage;
import com.es.pom.ProjectListingPage;
import com.es.pom.ReportsPage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
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
			PaymentPage.verifyPaymentPageElements();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyActionOnPayButton");
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
			SeleniumUtils.captureScreenshot("verifyActionOnViewProjectsButton");
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
			SeleniumUtils.captureScreenshot("verifyActionOnViewInvoicesButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that the Technical contact associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval)")
	public void verifyTechnicalContactAssociatedWithReport() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("technicalContactAssociatedUsername"),Prop.getTestData("technicalContactAssociatedPassword"),"Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.technicalContactAssociatedWithReport();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyTechnicalContactAssociatedWithReport");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that the Additional Technical contact associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval)' ")
	public void verifyAdditionalTechnicalContactAssociatedWithReport() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.additionalTechnicalContactAssociatedWithReport();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyAdditionalTechnicalContactAssociatedWithReport");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that the Authorized signatory associated with the report can see the report at the Dashboard under the head 'Reports (Pending Approval)")
	public void verifyAuthorizedSignatoryAssociatedWithReport() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.authorizedSignatoryAssociatedWithReport();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyAuthorizedSignatoryAssociatedWithReport");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })    
	@Description("Verify that the payment screen allows the customer to pay any amount greater than zero for renewal.")
	public void verifyCustomerDetailsPayForRenewal()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerDetailsPayForRenewal");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that for renewal, the customer is allowed to upload renewal application.")
	public void verifyCustomerAllowedUploadRenewalApplication()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.uploadRenewalApplicationForCustomer();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerAllowedUploadRenewalApplication");
			e.getStackTrace();
			throw e;
		}
	}


	@Test(groups = { "smoke" })    
	@Description("Verify the presence of an additional field 'Renewal Form' on the payment screen for Application Renewal payment.")
	public void verifyCustomerFieldRenewalForm()  throws InterruptedException {
		try{	
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.additionalCustomerFieldRenewalForm();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerFieldRenewalForm");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke" })   
	@Description("Verify that the Renewal Form field is a mandatory field for PMG renewal")
	public void verifyRenewalFormMandatoryFieldPMGRenewal()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRenewalFormMandatoryFieldPMGRenewal");
			e.getStackTrace();
			throw e;
		}
	}


	@Test(groups = { "smoke" })   
	@Description("Verify that the Renewal Form field is not a mandatory field for ESL & ESR renewal")
	public void verifyRenewalFormNotMandatoryRenewalEslEsr() throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("usernameESL"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.renewalFormNotMandatoryEslEsr(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRenewalFormNotMandatoryRenewalEslEsr");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })   
	@Description("Verify that user is able to pay renewal fee against report no.")
	public void verifyRenewalFeesAgainstReportNo()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.verifyUserNavigatedPaymentGateway();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRenewalFeesAgainstReportNo");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })   
	@Description("Verify that the Renewal payment can be submitted successfully with valid Payment details.")
	public void verifyRenewalPaymentSubmitted()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyRenewalPaymentSubmitted");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })   
	@Description("Verify the mail received by customer for Payment.")
	public void verifyMailReceivedByCustomerForPayment()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			Yopmail.verifyMailReceivedByCustomerForPayment(Prop.getTestData("username"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyMailReceivedByCustomerForPayment");
			e.getStackTrace();
			throw e;
		}
	}


	@Test(groups = { "smoke" })   
	@Description("Verify the mail received to associated staff for Payment.")
	public void verifyMailReceivedByStaffForPayment()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			Yopmail.verifyMailReceivedToStaffForPayment(Prop.getTestData("EmailId"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyMailReceivedByStaffForPayment");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that on successful renewal payment for any application, a new application is created on the portal of the same program type.")
	public void verifyNewApplicationOnPortal()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyNewApplicationCreated();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyNewApplicationOnPortal");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that on newly created applications, user should not be able to perform predefined operations like edit/view/delete/recall")
	public void verifyUserUnablePerformPredefinedOperations()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyNewApplicationCreated();
			DashboardPage.verifyDashboardPage();
			DashboardPage.navigateToApplicationPage();
			ApplicationsListingPage.verifyUserUnablePerformPredefinedOperations();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUserUnablePerformPredefinedOperations");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that on newly created applications, user should not be able to perform predefined operations like edit/view/delete/recall")
	public void verifyStaffUserUnablePerformPredefinedOperations()  throws InterruptedException {

		try{	SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
		DashboardPage.verifyDashboardPage();
		DashboardPage.navigateToApplicationPage();
		ApplicationsListingPage.verifyUserUnablePerformPredefinedOperations();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffUserUnablePerformPredefinedOperations");
			e.getStackTrace();
			throw e;
		}

	}


	@Test(groups = { "smoke" })  
	@Description("Verify that the Customer is able to download Renewal Application document from application listing")
	public void verifyCustomerDownloadRenewalApplicationDocument()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			PaymentHistoryPage.verifyNewApplicationCreated();
			DashboardPage.verifyDashboardPage();
			DashboardPage.navigateToApplicationPage();
			ApplicationsListingPage.customerDownloadRenewalApplicationDocument();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyCustomerDownloadRenewalApplicationDocument");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke" })  
	@Description("Verify that the Staff is able to download Renewal Application document from application listing.")
	public void verifyStaffDownloadRenewalApplicationDocument()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.verifyDashboardPage();
			DashboardPage.navigateToApplicationPage();
			ApplicationsListingPage.customerDownloadRenewalApplicationDocument();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffDownloadRenewalApplicationDocument");
			e.getStackTrace();
			throw e;
		}
	}


	@Test(groups = { "smoke" })    
	@Description("Verify that after successful payment, staff is notified about new renewal file available.")
	public void verifyStaffNotifiedAboutNewRenewalFile()  throws InterruptedException {
		try{
			SignInPage.login(Prop.getTestData("username"),Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.hoveringOverAnyReport();
			DashboardPage.clickActionOnPayButton();
			PaymentPage.detailCustomerPayForRenewal(Prop.getTestData("payAmount"),Prop.getTestData("billingAddress"),Prop.getTestData("city"),Prop.getTestData("zip"),Prop.getTestData("phone"));
			CardDetailsPage.customerPayForRenewal(Prop.getTestData("name"), Prop.getTestData("creditCardNumber"), Prop.getTestData("cVCNumber"));
			Yopmail.verifyNewRenewalFile(Prop.getTestData("EmailId"));
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffNotifiedAboutNewRenewalFile()");
			e.getStackTrace();
			throw e;
		}
	}

}
// 228=GP