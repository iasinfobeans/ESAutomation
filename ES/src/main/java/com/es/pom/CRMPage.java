package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.es.setup.Driver;
import com.es.setup.Setup;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;


public class CRMPage {
	
	private static Logger log = Logger.getLogger(CRMPage.class.getName());
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_UsernameTextBox']")
	static WebElement userNameTextbox;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_PasswordTextBox']")
	static WebElement passwordTextbox;
	
	@FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_SubmitButton']")
	static WebElement crmLoginButton;
	
	@FindBy(xpath = "//*[@id='dontShowAgainFirst']")
	static WebElement dontShowAgainFirst;
	
	@FindBy(xpath = "//*[text()='No, thanks']")
	static WebElement noThanks;
	
	@FindBy(xpath = "//*[text()='Microsoft Dynamics CRM']")
	static WebElement moveToSales;
	
	@FindBy(xpath = "//*[@id='SFA' and @title='Sales']")
	static WebElement clickOnSales;
	
	@FindBy(xpath = "//*[@id='crmGrid_findCriteria']")
	static WebElement searchFilter;
	
	@FindBy(xpath = "//*[text()=' Qualify ']")
	static WebElement qualify;
	
	@Step("Signing in CRM..")
	public static void login(String username, String password) {
		try {
			userNameTextbox.sendKeys(username);
			passwordTextbox.sendKeys(password);
			crmLoginButton.click();
			log.info("Logged in successfully in CRM.");
			SeleniumUtils.switchToIframeById("InlineDialog_Iframe");
			dontShowAgainFirst.click();
			noThanks.click();
			SeleniumUtils.switchToDefaultIframe();
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Step("qualifying lead in CRM..")
	public static void qaulifyLeadInCRMPage(String name, String email) {
		try {
			String findLead = "//*[text()='" + email + "']";
			Actions act = new Actions(Setup.driver);
			act.moveToElement(moveToSales).perform();
			Thread.sleep(20000);
			act.moveToElement(clickOnSales).click().build().perform();
			SeleniumUtils.switchToIframeByIndex(0);

			Thread.sleep(20000);
			searchFilter.sendKeys(name);
			searchFilter.sendKeys(Keys.RETURN);
			Thread.sleep(20000);
			WebElement ele = Setup.driver.findElement(By.xpath(findLead));
			JavascriptExecutor js = (JavascriptExecutor) Setup.driver;
			js.executeScript("arguments[0].click();", ele);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SeleniumUtils.switchToDefaultIframe();
		}
		qualify.click();
		log.info("Qualified lead in CRM for "+name + "and for email id :"+email);
	}

}
