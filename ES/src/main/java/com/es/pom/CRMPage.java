package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.es.setup.Setup;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

/**
 * This class is used to define methods which are used in CRM integration.
 * 
 * @author Tushar
 *
 */
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

	@FindBy(xpath = "//*[@id='datetimeFilterPopupcrmGridleadcreatedon']/div/a/div")
	static WebElement clickOnDropDown;

	@FindBy(xpath = "//*[text()='Sort Newest to Oldest']")
	static WebElement selNewToOld;

	@FindBy(xpath = "//*[@title='Sort by Email']")
	static WebElement clickForSort;

	@FindBy(xpath = "//*[@id='grid_refresh']")
	static WebElement refreshLeadList;

	@FindBy(xpath = "//*[text()='ES Portal']")
	static WebElement esPortalOption;

	@FindBy(xpath = "//*[@id='navTabButtonUserInfoSignOutId']")
	static WebElement signOutOption;

	/**
	 * This method will login in CRM using given credentials.
	 * 
	 * @param username
	 * @param password
	 */
	@Step("Signing in CRM..")
	public static void login(String username, String password) {
		try {
			Assert.assertTrue(userNameTextbox.isDisplayed());
			Assert.assertTrue(passwordTextbox.isDisplayed());
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

	/**
	 * This method will used to qualify to particular customer in CRM .
	 * 
	 * @param name
	 *            - name of customer to be qualified.
	 * @param email
	 *            - email of customer to be qualified.
	 */
	@Step("qualifying lead in CRM..")
	public static void qualifyLeadInCRMPage(String name, String email) {
		try {
			String findLead = "//*[text()='" + email + "']";
			Actions act = new Actions(Setup.driver);
			act.moveToElement(moveToSales).perform();
			SeleniumUtils.waitForElementToBeVisible(clickOnSales);
			act.moveToElement(clickOnSales).click().build().perform();
			SeleniumUtils.switchToIframeByIndex(0);
			SeleniumUtils.executeJavaScript("arguments[0].click();", refreshLeadList);
			log.info("Refreshed Lead List.");
			Assert.assertTrue(searchFilter.isDisplayed());
			SeleniumUtils.waitForElementToBeVisible(searchFilter);
			searchFilter.sendKeys(name);
			searchFilter.sendKeys(Keys.RETURN);
			SeleniumUtils.waitForElementToBeVisible(clickForSort);
			clickForSort.click();
			clickForSort.click();
			WebElement ele = Setup.driver.findElement(By.xpath(findLead));
			SeleniumUtils.executeJavaScript("arguments[0].click();", ele);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SeleniumUtils.switchToDefaultIframe();
		}
		qualify.click();
		log.info("Qualified lead in CRM for " + name + "and for email id :" + email);
	}

	/**
	 * This method will logout crm user.
	 */
	@Step("Signing Out From CRM..")
	public static void logout() {
		SeleniumUtils.switchToDefaultIframe();
		Assert.assertTrue(esPortalOption.isDisplayed());
		SeleniumUtils.waitForElementToBeVisible(esPortalOption);
		esPortalOption.click();
		SeleniumUtils.waitForElementToBeVisible(signOutOption);
		signOutOption.click();
		log.info("Logged out from CRM.");
	}

}
