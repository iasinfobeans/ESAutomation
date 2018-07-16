package com.es.pom;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.es.setup.Driver;
import com.es.util.Prop;
import io.qameta.allure.Step;

public class ChangePasswordPage {

	private static Logger log = Logger.getLogger(Driver.class.getName());

	@FindBy(xpath="//input[@name='currentpassword']")
	static WebElement currentPasswordTextbox;

	@FindBy(id="password1")
	static WebElement newPassword;

	@FindBy(id="password2")
	static WebElement reenterNewPassword;

	@FindBy(id="submit")
	static WebElement submitButton;

	@FindBy(xpath="//span[@class='message success alert']")
	static WebElement successMessage;
	
	static String storePassword;
	
	@Step("cahnge password for user account...")
	public static void changePassword() throws IOException
	{
		currentPasswordTextbox.sendKeys(Prop.getTestData("passwordToTest"));
		log.info("entered current password");
		newPassword.sendKeys(Prop.getTestData("passwordToTest"));
		log.info("entered new password");
		reenterNewPassword.sendKeys(Prop.getTestData("passwordToTest"));
		log.info("Re enter new password");
		log.info("Changed Password");
		successMessage.isDisplayed()
;	}

}