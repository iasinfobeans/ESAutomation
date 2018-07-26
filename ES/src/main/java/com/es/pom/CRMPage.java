package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(xpath = "//*[@id='datetimeFilterPopupcrmGridleadcreatedon']/div/a/div")
	static WebElement clickOnDropDown;
	
	@FindBy(xpath = "//*[text()='Sort Newest to Oldest']")
	static WebElement selNewToOld;
	
	@FindBy(xpath = "//*[@title='Sort by Email']")
	static WebElement clickForSort;
	
	@FindBy(xpath = "//*[@id='grid_refresh']")
	static WebElement refreshLeadList;
	
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
			SeleniumUtils.waitForElementToBeVisible(clickOnSales);
			act.moveToElement(clickOnSales).click().build().perform();
			SeleniumUtils.switchToIframeByIndex(0);
			SeleniumUtils.waitForElementToBeVisible(refreshLeadList);
			JavascriptExecutor jsrefresh = (JavascriptExecutor) Setup.driver;
			jsrefresh.executeScript("arguments[0].click();", refreshLeadList);
			
			SeleniumUtils.waitForElementToBeVisible(searchFilter);
			searchFilter.sendKeys(name);
			searchFilter.sendKeys(Keys.RETURN);
			SeleniumUtils.waitForElementToBeVisible(clickForSort);
			clickForSort.click();
			clickForSort.click();			
			
			WebElement ele = Setup.driver.findElement(By.xpath(findLead));
			SeleniumUtils.waitForElementToBeVisible(ele);
			JavascriptExecutor js = (JavascriptExecutor) Setup.driver;
			js.executeScript("arguments[0].click();", ele);
			
			
			/*WebElement selectView = Setup.driver.findElement(By.xpath("//*[@id='crmGrid_SavedNewQuerySelector']/span/img"));
			JavascriptExecutor jsselectView = (JavascriptExecutor) Setup.driver;
			jsselectView.executeScript("arguments[0].click();", selectView);
			
			Setup.driver.findElement(By.xpath("//*[text()='Create Personal View']")).click();
			
			for(String winHandle : Setup.driver.getWindowHandles()){
				Setup.driver.switchTo().window(winHandle);
			}
			
			Thread.sleep(20000);
			Setup.driver.switchTo().frame(0);
			Setup.driver.findElement(By.xpath("//*[@class='ms-crm-SelectBox']")).click();
			Thread.sleep(20000);
			Setup.driver.findElement(By.xpath("//*[@id='fld']/option[56]")).click();
			WebElement filterEle = Setup.driver.findElement(By.xpath("//*[@id='filterButtonImage']"));
			JavascriptExecutor jsfilter = (JavascriptExecutor) Setup.driver;
			jsfilter.executeScript("arguments[0].click();", filterEle);
			Thread.sleep(10000);
			clickOnDropDown.click();
			Thread.sleep(10000);
			selNewToOld.click();
			
			
			
			Thread.sleep(20000);
			WebElement ele = Setup.driver.findElement(By.xpath(findLead));
			JavascriptExecutor js = (JavascriptExecutor) Setup.driver;
			js.executeScript("arguments[0].click();", ele);*/

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SeleniumUtils.switchToDefaultIframe();
		}
		qualify.click();
		log.info("Qualified lead in CRM for "+name + "and for email id :"+email);
	}

}
