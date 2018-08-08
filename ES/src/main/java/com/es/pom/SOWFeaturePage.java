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

	@FindBy(xpath="//input[@id='project_number']")
	static WebElement projectNumberTextbox;

	@FindBy(id="upload-documents-document")
	static WebElement uploadOption;

	@FindBy(id="save_sow")
	static WebElement saveButton;

	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static WebElement sOWUpatedSuccessfullyMessege;

	@FindBy(xpath="//a[@class='fa fa-trash-o icon-app-delete deleteAppDoc']")
	static WebElement removesSowFile;

	@FindBy(xpath="//*[@id='sowdocuments']/tbody/tr/td/div/a")
	static WebElement clickOnDownloadSOW;

	@FindBy(linkText="Download as zip")
	static WebElement downloadZip;
	
	@FindBy(id="allowDelete_sow-documents")
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
		for(int i=1;i<=fileCount; i++){
			log.info("fileCount start loop: "+fileCount);
			log.info("i: "+i);
			SeleniumUtils.waitForElementToBeVisible(uploadOption);
			uploadOption.click();
			log.info("Enter upload pdf ");

			String uploadfilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\testFiles\\TestFileForUpload.pdf";
			RobotUtils.uploadFile(uploadfilePath);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("upload pdf from drive ");
			log.info("fileCount end loop: "+fileCount);
			log.info("i: "+i);
		}
	}

	@Step("user is able to click on the 'Save' button after uploading a PDF file on the Upload SOW pop-up")
	public static void clickOnSaveButtonAfterUploadingPdfFile() {
		saveButton.click();
		log.info("Enter upload pdf ");

	}
	@Step("SOW should be uploaded and a confirmation message should be displayed on the screen...")
	public static void verifyConfirmationMessageDisplayedScreen() {
		Assert.assertTrue(sOWUpatedSuccessfullyMessege.isDisplayed());
		log.info(" confirmation message is displayed on the screen");

	}
	@Step("Verify that if Staff removes a SOW file, a notification email would be sent to Technical representative of the Report")
	public static void staffRemovesSOWFile() {
		removesSowFile.click();
		log.info(" Staff removes a SOW file ");
		
		oKRemovesSowFile.click();
		log.info(" Staff removes a SOW file By Opting on OK ");
	}

	@Step("Verifying details of uploaded sow from yopmail link.")
	public static void verifyDetailsOfSOWUploaded() {
		log.info("Verified that customer is abled to move on SOW page by clicking on given link in yopmail.");
	}

	@Step("Downloading sow..")
	public static void downloadSOW() {
		clickOnDownloadSOW.click();
		downloadZip.click();
		log.info("SOW Downloaded.");
	}
}

