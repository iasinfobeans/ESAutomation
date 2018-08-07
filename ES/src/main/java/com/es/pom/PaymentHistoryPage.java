package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.es.util.Prop;
import io.qameta.allure.Step;

public class PaymentHistoryPage {
	private static Logger log = Logger.getLogger(PaymentHistoryPage.class.getName());

	@FindBy(xpath="//span[@class='message success alert']//ul//li")
	static WebElement paymentSuccessMessege;

	@FindBy(xpath="//*[@id='paymentListTable']/tbody/tr[1]/td[5]")
	static WebElement newApplication;

	@Step("Verify that the payment was successful.")
	public static void verifyPaymentSucess(){
		if(paymentSuccessMessege.getText().equals(Prop.getTestData("paymentSuccessMessage"))){
			log.info("Payment was successful");
		}
	}
}