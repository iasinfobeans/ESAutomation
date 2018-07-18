package com.es.pom;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.es.setup.Driver;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;

import io.qameta.allure.Step;

public class ResetPasswordPage {

	private static Logger log = Logger.getLogger(Driver.class.getName());

	@FindBy(xpath="//input[@name='currentpassword']")
	static WebElement currentPasswordTextbox;

	@FindBy(id="password1")
	static WebElement newPassword;

	@FindBy(id="password2")
	static WebElement reenterNewPassword;

	@FindBy(id="resetpass-button")
	static WebElement resetPasswordButton;

	@FindBy(xpath="//span[@class='message success alert']")
	static WebElement successMessage;
	
	static String storePassword;
	
	@Step("cahnge password for user account...")
	public static void changePassword(String resetPasswordLink) throws IOException
	{
		SeleniumUtils.openUrl(resetPasswordLink);
		newPassword.sendKeys(Prop.getTestData("password"));
		log.info("entered new password");
		reenterNewPassword.sendKeys(Prop.getTestData("password"));
		log.info("Re-entered new password");
		resetPasswordButton.click();
		log.info("Reset password complete");
		successMessage.isDisplayed();
		log.info(successMessage.getText());
		}

}