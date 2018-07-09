package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.qameta.allure.Step;

public class ApplicationPage {

	private static Logger log = Logger.getLogger(ApplicationPage.class.getName());

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromER;

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromPMG;

	@FindBy(id="applicationType")
	static WebElement verifyRegisterfromESL;


	/**   
	 * @author Shefali.Garg
	 * @description This method would perform login based on account type
	 * @return void
	 * @param driver
	 */

	@Step("verify Application page for ER Step...")
	public static void verifyApplicationPageForER(){
		Assert.assertTrue(verifyRegisterfromER.isDisplayed());
		log.info("Verify Register from ER displayed");

	}

	@Step("verify Application page for PGM Step...")
	public static void verifyApplicationPageForPMG() {
		Assert.assertTrue(verifyRegisterfromPMG.isDisplayed());
		log.info("Verify Register from PMG displayed");

	}

	@Step("verify Application page for ESL Step...")
	public static void verifyApplicationPageForESL() {
		Assert.assertTrue(verifyRegisterfromESL.isDisplayed());
		log.info("Verify Register from ESL displayed");
	}

}


