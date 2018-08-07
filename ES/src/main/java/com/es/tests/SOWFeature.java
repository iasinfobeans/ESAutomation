package com.es.tests;
import org.testng.annotations.Test;
import com.es.pom.DashboardPage;
import com.es.pom.SOWFeaturePage;
import com.es.pom.SignInPage;
import com.es.setup.Setup;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Description;

public class  SOWFeature extends Setup {




	@Test(groups = { "smoke" })  
	@Description("Verify that the staff is able to 'Upload SOW' for ESR applications.")
	public void verifyStaffUploadSOWForESRApplications()  throws InterruptedException {

		try{	
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESR"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffUploadSOWForESRApplications");
			e.getStackTrace();
			throw e;
		}

	}

	@Test(groups = { "smoke" })  
	@Description("Verify that the staff is able to 'Upload SOW' for ESL applications.")
	public void verifyStaffUploadSOWForESLApplications() throws InterruptedException {

		try{	
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumberESL"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffUploadSOWForESLApplications");
			e.getStackTrace();
			throw e;
		}

	}


	@Test(groups = { "smoke" })  
	@Description("Verify that the SOW would be uploaded as a PDF file.")
	public void verifySOWUploadedAsPdf()  throws InterruptedException {

		try{	
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");  
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifySOWUploadedAsPdf()");
			e.getStackTrace();
			throw e;
		}

	}


	@Test(groups = {"smoke"})  
	@Description("Verify that the staff can upload any number of SOW for a single Project.")
	public void verifyStaffuploadAnyNumberSOWSingleProject()  throws InterruptedException {

		try{	
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(4);
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyStaffuploadAnyNumberSOWSingleProject");
			e.getStackTrace();
			throw e;
		}

	}


	@Test(groups = {"smoke" })  
	@Description("Verify that the user is able to click on the 'Save' button after uploading a PDF file on the Upload SOW pop-up")
	public void verifyUserAbleClickOnSaveButton()  throws InterruptedException {

		try{	
			SignInPage.login(Prop.getTestData("Staffuser"),Prop.getTestData("Staffpassword"), "Staff");
			DashboardPage.clickOnSOWOption();
			SOWFeaturePage.clickOnUploadSOWOption();
			SOWFeaturePage.clickOnValidValuEProjectNumberField(Prop.getTestData("projectNumber"));
			SOWFeaturePage.uploadPdfFileInSOW(1);
			SOWFeaturePage.clickOnSaveButtonAfterUploadingPdfFile();
			SOWFeaturePage.verifyConfirmationMessageDisplayedScreen();
		}catch(Exception e){
			SeleniumUtils.captureScreenshot("verifyUserAbleClickOnSaveButton");
			e.getStackTrace();
			throw e;
		}

	}
	


}
