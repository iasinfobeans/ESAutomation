package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class ApplicationPage {

	private static Logger log = Logger.getLogger(ApplicationPage.class.getName());

	@FindBy(id="signer_name")
	static WebElement signerNameTextbox;

	@FindBy(id="signer_email")
	static WebElement signerEmailTextbox;

	@FindBy(id="appcompanyname")
	static  WebElement companyNameTextbox;

	@Step("verify Edit Application page can't allow to edit signatory information(i.e. name and email)...")
	public static void verifySignatoryInfoIsNotEditable(){
		companyNameTextbox.sendKeys("Infobeans");
		log.info("Field editable");
		SeleniumUtils.scrollToBottom();
		String readonly = signerNameTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonly);
		log.info("Verified that signer name text box is non editable");
		String readonlyCompany= signerEmailTextbox.getAttribute("readonly");
		Assert.assertNotNull(readonlyCompany);
		log.info("Verified that signer email text box is non editable");
	}

}


