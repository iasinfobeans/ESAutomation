package com.es.tests;

import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.OverlayPage;
import com.es.pom.ProjectListingPage;
import com.es.pom.ReportsPage;
import com.es.pom.SOWFeaturePage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import com.es.util.Yopmail;
import io.qameta.allure.Description;

public class SOWFeature extends Setup {

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the staff is able to 'Upload SOW' for ESR applications.")
	public void verifyStaffUploadSOWForESRApplications() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffUploadSOWForESRApplications");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature" })
	@Description("Verify that the staff is able to 'Upload SOW' for ESL applications.")
	public void verifyStaffUploadSOWForESLApplications() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESL"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffUploadSOWForESLApplications");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the SOW would be uploaded as a PDF file.")
	public void verifySOWUploadedAsPdf() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifySOWUploadedAsPdf()");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the staff can upload any number of SOW for a single Project.")
	public void verifyStaffuploadAnyNumberSOWSingleProject() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(4);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyStaffuploadAnyNumberSOWSingleProject");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the user is able to click on the 'Save' button after uploading a PDF file on the Upload SOW pop-up")
	public void verifyUserAbleClickOnSaveButton() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			SOWFeaturePage.verifyConfirmationMessageDisplayedScreen();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUserAbleClickOnSaveButton");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the portal will notify the technical representative of the Report for new SOW availability.")
	public void verifyNotifyTechnicalRepresentativeNewSOWAvailability() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			SOWFeaturePage.verifyConfirmationMessageDisplayedScreen();
			Yopmail.verifySOWUploadedMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNotifyTechnicalRepresentativeNewSOWAvailability");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the portal will notify the authorized signatory of the Report for new SOW availability.")
	public void verifyNotifyAuthorizedSignatoryNewSOWAvailability() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			SOWFeaturePage.verifyConfirmationMessageDisplayedScreen();
			Yopmail.verifySOWUploadedMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNotifyAuthorizedSignatoryNewSOWAvailability");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that if Staff removes a SOW file, a notification email would be sent to Technical representative of the Report.")
	public void verifyNotificationEmailTechnicalRepresentativeStaffRemovesSOWFile() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			Thread.sleep(1000);
			SOWFeaturePage.staffRemovesSOWFile();
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			Yopmail.verifySOWFileRemoveMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNotificationEmailTechnicalRepresentativeStaffRemovesSOWFile");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that if Staff removes a SOW file, a notification email would be sent to Authorized signatory of the Report ")
	public void verifyNotificationEmailAuthorizedSignatoryStaffRemovesSOWFile() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			Thread.sleep(1000);
			SOWFeaturePage.staffRemovesSOWFile();
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			Yopmail.verifySOWFileRemoveMail(Prop.getTestData("username"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyNotificationEmailAuthorizedSignatoryStaffRemovesSOWFile");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the staff user is NOT able to delete ALL the files attached as SOW")
	public void verifyUnableDeleteAllFilesSOW() throws InterruptedException {
		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.verifyStaffUserUnableDeleteAllFilesSOW();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyUnableDeleteAllFilesSOW");
			e.getStackTrace();
			throw e;
		}
	}

	@Test(groups = { "smoke", "SOWFeature" })
	@Description("Verify that the Technical representative of the report would be able to download the SOW file from the Project listing page.")
	public void verifyTechnicalRepresentativeAableDownloadSOWFile() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("technicalContactAssociated"),
					Prop.getTestData("password"),"Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyReportsOption();
			ReportsPage.navigateToProjectListingPage();
			ProjectListingPage.clickOnViewSOW();
			SOWFeaturePage.downloadSOW();
			Thread.sleep(20000);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyTechnicalRepresentativeAableDownloadSOWFile");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke", "SOWFeature"})
	@Description("Verify that the Technical representative of the report would be able to download the SOW file from the Project listing page.")
	public void verifyAuthorizedSignatoryAableDownloadSOWFile() throws InterruptedException {

		try {
			SignInPage.login(Prop.getTestData("Staffuser"), Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			DashboardPage.logout();
			SignInPage.login(Prop.getTestData("AuthorizedSignatoryAssociated"), Prop.getTestData("password"), "Customer");
			OverlayPage.skipoverlayPage();
			DashboardPage.verifyReportsOption();
			ReportsPage.navigateToProjectListingPage();
			ProjectListingPage.clickOnViewSOW();
			SOWFeaturePage.downloadSOW();
			Thread.sleep(20000);
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyAuthorizedSignatoryAableDownloadSOWFile");
			e.getStackTrace();
			throw e;
		}

	}

}
