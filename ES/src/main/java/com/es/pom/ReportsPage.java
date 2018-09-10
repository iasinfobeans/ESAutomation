package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.qameta.allure.Step;

public class ReportsPage {
	private static Logger log = Logger.getLogger(ReportsPage.class.getName());

    @FindBy(xpath = "//*[@id='programReportsTable']/tbody/tr/td/a/parent::td/following-sibling::td/a")
	static WebElement viewReportOption;
	
	
    @Step(" Navigate to Project listing page")
	public static void navigateToProjectListingPage() {
		viewReportOption.click();
		log.info(" Navigate to Project listing page");
	}
}
