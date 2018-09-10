package com.es.pom;
import org.apache.log4j.Logger;
import io.qameta.allure.Step;

public class DependsOn {

	private static Logger log = Logger.getLogger(DependsOn.class.getName());
	/**
	 * This method will print details for dependent test case on Allure report
	 * 
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