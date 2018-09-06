package com.es.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.es.util.Prop;
import com.es.util.SeleniumUtils;
import io.qameta.allure.Step;

public class DependsOn {

	private static Logger log = Logger.getLogger(DependsOn.class.getName());
	/**
	 * This method will print details for dependent test case
	 * @param Test_Description
	 * @param Test_Method_Name
	 * @return void
	 */
	@Step("This test case depends on")
	public static void dependsOnMethod(String Test_Description,String Test_Method_Name) {
		log.info("This test case depends on");
		log.info("description: "+Test_Description);
		log.info("method: "+Test_Method_Name);
		
		}
}