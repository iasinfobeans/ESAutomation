package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.setup.Driver;
import com.es.util.Prop;
import io.qameta.allure.Step;

public class ForgotPasswordPage {
	
	private static Logger log = Logger.getLogger(Driver.class.getName());
	
	@FindBy(id="user_forget_pass")
	static WebElement enterEmailPlaceholder;
	 
	@FindBy(xpath="//input[@value='SEND RESET PASSWORD LINK']")
	static WebElement passwordResetLink;
	
	@FindBy(xpath="//span[@class='message success alert']/ul/li")
	static WebElement resetPasswordSucessMessage;
	
	@Step("Reset Password")
	public static void resetPassword(String email)
	{
		enterEmailPlaceholder.sendKeys(email);
		log.info("entered email");
		
		passwordResetLink.click();
		log.info("clicked on password reset link");
		
		Assert.assertEquals(Prop.getTestData("resetPasswordSuccess"), resetPasswordSucessMessage.getText());
	}
	
	
}