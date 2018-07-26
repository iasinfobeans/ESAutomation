package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;
public class UserListingsPage {

private static Logger log = Logger.getLogger(UserListingsPage.class.getName());
	
	@FindBy(xpath = "//a[@class='tbl-icon-gear dropdown-toggle']")
	static WebElement buttonForMoreOptions;
	
	@FindBy(linkText ="View Profile")
	static WebElement viewProfileOption;
	
	@FindBy(xpath = "//div[@class='ehading']")
	static WebElement viewProfileVerifyElement;
	
	@FindBy(linkText ="Approve")
	static WebElement approveOption;
	
	@FindBy(linkText ="Decline")
	static WebElement declineOption;
	
	@Step("Verify view profile from user listings")
	public static void checkViewProfileOption() {
		buttonForMoreOptions.click();
		log.info("more options");
		viewProfileOption.click();
		log.info("Viewing Profile of user");
		viewProfileVerifyElement.isDisplayed();
		log.info("View Profile page verified");
	}
	
	@Step("Verify approve and decline requests visibility for updation from user listings")
	public static void checkApproveAndDeclineOption() {
		buttonForMoreOptions.click();
		log.info("more options");
		approveOption.isDisplayed();
		log.info("Approve request option available");
		declineOption.isDisplayed();
		log.info("Decline request option available");
	}
	
	@Step("Verify approve requests for updation from user listings")
	public static void approveProfileUpdateRequest() {
		if(buttonForMoreOptions.isDisplayed())
		{
			buttonForMoreOptions.click();
			log.info("more options available");
			approveOption.click();
			log.info("Request approved");
			SeleniumUtils.acceptPopup();
			log.info("final Request approved popup clicked");
		}
	}
	
	@Step("Verify decline requests for updation from user listings")
	public static void declineProfileUpdateRequest() {
		if(buttonForMoreOptions.isDisplayed())
		{
			buttonForMoreOptions.click();
			log.info("more options available");
			declineOption.click();
			log.info("Request approved");
			SeleniumUtils.acceptPopup();
			log.info("final Request approved popup clicked");
		}
	}
	
}
//