package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.es.setup.Driver;
import com.es.util.Prop;

import io.qameta.allure.Step;

public class QuotationRequestFormPage {
	
	
	WebDriver driver;
	
	private static Logger log = Logger.getLogger(Driver.class.getName());
	
	@FindBy(xpath="//h1[@class='entry-title post-title']")
	static WebElement dashboardElement;
	
	@FindBy(linkText="Get a Quote")
	static WebElement getQuoteLink;
	
	 @FindBy(id="salutation")
	  static WebElement userSalutation;
	     
	  @FindBy(id="firstname")
	  static WebElement firstnameOfApplicant;
	  
	  @FindBy(id="lastname")
	  static WebElement lastnameOfApplicant;
	  
	  @FindBy(id="emailaddress1")
	  static WebElement email1OfApplicant;
	  
	  @FindBy(id="telephone1")
	  static WebElement teleNumberofApplicant_1;
	  
	  //@FindBy(id="telephone1")
	  //static WebElement teleNumberofApplicant_1;
	  
	  @FindBy(id="jobtitle")
	  static WebElement jobTitle;
	  
	  @FindBy(id="companyname")
	  static WebElement companyName;
	  
	  @FindBy(id="address1_line1")
	  static WebElement street;
	  
	  @FindBy(id="address1_city")
	  static WebElement city;
	  
	  @FindBy(id="address1_postalcode")
	  static WebElement postalCode;
	  
	  @FindBy(id="address1_stateorprovince")
	  static WebElement stateOrProvince;
	  
	  @FindBy(id="address1_country")
	  static WebElement country;
	  
	  @FindBy(id="leadsourcecode")
	  static WebElement leadSource;
	  
	  @FindBy(id="websiteurl")
	  static WebElement websiteUrl;
	  
	  @FindBy(id="accr_program")
	  static WebElement accrediationProgram;
	  
	  @FindBy(id="cmp_file")
	  static WebElement businessLicenseDoc;
	  
	  @FindBy(id="file_upload")
	  static WebElement fileUpload;
	  
	  @FindBy(id="insert")
	  static WebElement submitRequestButton;
	  
	/**
 	 * @author Shefali.Garg
 	 * @description This method would perform login based on account type
 	 * @return void
 	 * @param driver
 	 */
	
	 public QuotationRequestFormPage(WebDriver driver)
	 {
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	}
	 
	 @Step(" Fill get a quote form step...")
		public static void getAQoute() throws InterruptedException{
			getQuoteLink.click();
			log.info("clicked on get a quote");
			Select dropdown = new Select(userSalutation);
			dropdown.selectByValue("Mr.");
			log.info("Choose a salutation");
			
			firstnameOfApplicant.sendKeys(Prop.getTestData("firstnameOfApplicant"));
			log.info("Entered First Name");
			
			lastnameOfApplicant.sendKeys(Prop.getTestData("lastnameOfApplicant"));
			log.info("Entered Last Name");
			
			email1OfApplicant.sendKeys(Prop.getTestData("email1OfApplicant"));
			log.info("Entered Email address");
			
			teleNumberofApplicant_1.sendKeys(Prop.getTestData("teleNumberofApplicant_1"));
			
			jobTitle.sendKeys(Prop.getTestData("jobTitle"));
			log.info("Entered job title");
			
			companyName.sendKeys(Prop.getTestData("companyName"));
			log.info("Entered Company Name");
			
			street.sendKeys(Prop.getTestData("street"));
			log.info(" Entered street");
			
			city.sendKeys(Prop.getTestData("city"));
			log.info("Entered City");
			
			postalCode.sendKeys(Prop.getTestData("postalCode"));
			log.info("Entered Postal Code");
			
			stateOrProvince.sendKeys(Prop.getTestData("stateOrProvince"));
			log.info("Entered State or province");
			
			country.sendKeys(Prop.getTestData("country"));
			log.info("Entered Country");
			
			websiteUrl.sendKeys(Prop.getTestData("websiteUrl"));
			log.info("Entered Website Url");
			
			Select d = new Select(leadSource);
			d.selectByValue("8");
			
			Select a = new Select(accrediationProgram);
			a.selectByValue("4");
			log.info("clicked on get a quote");
			
			businessLicenseDoc.sendKeys("C:\\Users\\Nisha.Gathiya\\git\\IASAutomation\\IAS\\src\\main\\resources\\files\\test.pdf");
			log.info("Uploaded file");
			fileUpload.sendKeys("C:\\Users\\Nisha.Gathiya\\git\\IASAutomation\\IAS\\src\\main\\resources\\files\\test.pdf");
			log.info("Uploaded file");
			Thread.sleep(6000);
		/*	try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	 
	 
	 @Step("clicked on get quote request")
	 public static void submitQuoteRequest()
	 {
		 submitRequestButton.click();
		 log.info("Submitted request");
	 }
}
