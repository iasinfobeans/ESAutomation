package com.es.setup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.testng.TestNG;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlRun;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;


public class DriverScript {

	/**
	 * Copyright 1999 - 2017 ES All rights reserved.
	 *
	 * This software is the confidential and proprietary information of
	 * ES, Inc. ("Confidential Information"). You shall not disclose such
	 * Confidential Information and shall use it only in accordance with the terms
	 * of the license agreement you entered into with Sun.
	 * 
	 * 
	 */

	/**
	 * This driver script for Mobile Automation project, it is main class of this
	 * project. It gets following details from Jenkins job and create TestNG.xml
	 * file programmatically 1. Platform : Android / iOS 2. TestSuite : Smoke /BVT /
	 * SmallRegression / Regression 3. Feature: User/Billing etc 4. Module: SignIn,
	 * Create Survey etc. 5. Env: MT1 / MT2 / MT3 / PROD 6. TestRunID: TestRail test
	 * run id like 10661, 8747 Created TestNG.xml would be available with name
	 * programmedTestNG.xml in root directory of the project. It contains details of
	 * test cases for execution. This driver script also load the OR properties and
	 * test data.
	 * 
	 * @author pankaj.shukla
	 * @version 1.0
	 * @since 2017-03-31
	 * 
	 *        Ref link :
	 *        //http://toolsqa.com/mobile-automation/appium/appium-parallel-execution-using-testng/
	 */
	public static String platform = null;
	public static final Logger logger = Logger.getLogger(DriverScript.class.getName());

	public static void main(String[] args) throws JSONException, InterruptedException, IOException {

		logger.info("Env : " + System.getProperty("Env"));
		logger.info("Browser :" + System.getProperty("Browser"));
		logger.info("TestSuite : "+System.getProperty("TestSuite"));

		// Create ES Automation Suite
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("ES Automation Suite");
		xmlSuite.setParallel(ParallelMode.TESTS);
		xmlSuite.setThreadCount(1);
		xmlSuite.setVerbose(1);

		// Add listeners to test suite
		List<String> listeners = new ArrayList<String>();
		listeners.add("com.es.util.LoggingListener");
		xmlSuite.setListeners(listeners);

		// Create Test Suite
		String testName = null;
		testName = System.getProperty("Browser");
		Map<String,String> parameters = new HashMap<String, String>();
		parameters.put("testName", testName);
		createTest(xmlSuite, testName,parameters);
		createTestNGXmlFile(xmlSuite, "programmedTestNG.xml");

		// Configure and Run TestNG
		TestNG testNG = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		testNG.setXmlSuites(suites);
		testNG.run();
	}

	public static XmlSuite  createTest(XmlSuite xmlSuite,String testName,Map<String, String> parameters){
		//Set Smoke or Regression Test Suite
		XmlTest xmlTest = new XmlTest(xmlSuite);
		xmlTest.setName(testName);
		//xmlTest.addParameter("testName", testName);
		xmlTest.setPreserveOrder(true);
		xmlTest.setParameters(parameters);
		xmlTest.setSuite(xmlSuite);

		List<XmlPackage> xmlPackages = new ArrayList<XmlPackage>();
		XmlPackage xmlPackage = new XmlPackage("com.es.tests");
		xmlPackages.add(xmlPackage);
		xmlTest.setPackages(xmlPackages);

		List<XmlTest> tests = new ArrayList<XmlTest>();
		tests.add(xmlTest);
		xmlSuite.setTests(tests);

		//Group: Smoke or Regression
		XmlGroups group = new XmlGroups();
		XmlRun xmlRun = new XmlRun();
		xmlRun.onInclude(System.getProperty("TestSuite"));
		group.setRun(xmlRun);
		xmlTest.setGroups(group);	
		return xmlSuite;
	}

	public static void createTestNGXmlFile(XmlSuite xmlSuite, String fileName){
		//Generate TestNG file created by programmatically.
		File file = new File(fileName);
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			writer.write(xmlSuite.toXml());
			writer.close();
			logger.info("Generated "+fileName+" file: "+file.getAbsolutePath());
		} catch (IOException e) {
			logger.info("Failed to generate "+fileName+" file");
			e.printStackTrace();
		}
	}
}