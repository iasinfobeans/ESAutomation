package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.RobotUtils;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class SOWFeaturePage {

	private static Logger log = Logger.getLogger(SOWFeaturePage.class.getName());

	@FindBy(xpath = "//a[contains(text(),'Upload SOW')]")
	static WebElement uploadSOWOption;

	@FindBy(xpath = "//input[@id='project_number']")
	static WebElement projectNumberTextbox;

	@FindBy(id = "upload-documents-document")
	static WebElement uploadOption;

	@FindBy(id = "save_sow")
	static WebElement saveButton;

	@FindBy(xpath = "//span[@class='message success alert']//ul//li")
	static WebElement sOWUpatedSuccessfullyMessage, projectMustHaveAtleastOneSOWAssociatedMessage;

	@FindBy(xpath = "//a[@class='fa fa-trash-o icon-app-delete deleteAppDoc']")
	static WebElement removesSowFile;

	@FindBy(xpath = "//*[@id='sowdocuments']/tbody/tr/td/div/a")
	static WebElement downloadSOW;

	@FindBy(xpath = "//*[@class='fa fa-trash-o icon-app-delete deleteSowFromTooltip']")
	static WebElement deleteSOWFile;

	@FindBy(linkText = "Download as zip")
	static WebElement downloadZip;

	@FindBy(id = "allowDelete_sow-documents")
	static WebElement oKRemovesSowFile;

	@Step("click on the upload SOW option button")
	public static void clickOnUploadSOWOption() {
		SeleniumUtils.waitForElementToBeVisible(uploadSOWOption);
		uploadSOWOption.click();
		log.info("click on the upload SOW option button");
	}

	@Step("click on the upload SOW option button")
	public static void clickOnUploadOption(String projectNumber) {
		SeleniumUtils.waitForElementToBeVisible(projectNumberTextbox);
		projectNumberTextbox.clear();
		projectNumberTextbox.sendKeys(projectNumber);
		log.info("Input a valid ESR/ESL Project or Project Number in the Project Number field ");
	}

	@Step(" Input a valid value in the Project Number field")
	public static void clickOnValidValuEProjectNumberField(String projectNumber) {

		SeleniumUtils.waitForElementToBeVisible(projectNumberTextbox);
		projectNumberTextbox.clear();
		projectNumberTextbox.sendKeys(projectNumber);
		log.info("Input a valid ESR/ESL Project or Project Number in the Project Number field ");

	}

	@Step("click on the upload SOW option button")
	public static void uploadPdfFileInSOW(int fileCount) {
		for (int i = 1; i <= fileCount; i++) {
			log.info("fileCount start loop: " + fileCount);
			log.info("i: " + i);
			SeleniumUtils.waitForElementToBeVisible(uploadOption);
			uploadOption.click();
			log.info("Enter upload pdf ");

			String uploadfilePath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
			RobotUtils.uploadFile(uploadfilePath);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("upload pdf from drive ");
			log.info("fileCount end loop: " + fileCount);
			log.info("i: " + i);
		}
	}

	@Step("user is able to click on the 'Save' button after uploading a PDF file on the Upload SOW pop-up")
	public static void clickOnSaveButtonAfterUploadingPdfFile() {
		saveButton.click();
		log.info("Enter upload pdf ");

	}

	@Step("SOW should be uploaded and a confirmation message should be displayed on the screen...")
	public static void verifyConfirmationMessageDisplayedScreen() {
		Assert.assertTrue(sOWUpatedSuccessfullyMessage.isDisplayed());
		log.info(" confirmation message is displayed on the screen");

	}

	@Step("Verify that if Staff removes a SOW file, a notification email would be sent to Technical representative of the Report")
	public static void staffRemovesSOWFile() {
		removesSowFile.click();
		log.info(" Staff removes a SOW file ");

		SeleniumUtils.acceptPopup();
		log.info(" Staff removes a SOW file By Opting on OK ");
	}

	@Step("Verifying details of uploaded sow from yopmail link.")
	public static void verifyDetailsOfSOWUploaded() {
		log.info("Verified that customer is abled to move on SOW page by clicking on given link in yopmail.");
	}

	@Step("Downloading sow..")
	public static void downloadSOW() {
		downloadSOW.click();
		downloadZip.click();
		log.info("SOW Downloaded.");
	}

	@Step("Verifying details of uploaded sow from yopmail link.")
	public static void verifyDetailsOfSOWFileRemoved() {
		log.info("Verified that customer is abled to move on SOW page by clicking on given link in yopmail.");
	}

	@Step("Verifying download option is visible or not..")
	public static void downloadOptionVisibiltiy() {
		Assert.assertTrue(downloadSOW.isDisplayed(), "Download Option is nor visible on page");
		log.info("Verified Downloaded option visibilty.");
	}

	@Step("The staff user should NOT be able to delete ALL the files attached as SOW")
	public static void verifyStaffUserUnableDeleteAllFilesSOW() throws InterruptedException {

		downloadSOW.click();
		Thread.sleep(1000);
		deleteSOWFile.click();
		log.info("delete SOW File.");
		Thread.sleep(1000);
		Assert.assertTrue(projectMustHaveAtleastOneSOWAssociatedMessage.isDisplayed());
		log.info(" project Must Have At least One SOW Associated Message message is displayed on the screen");
	}
}
