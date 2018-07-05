# ES Automation

## Application Overview
[ICC-ES](https://myportal.icc-es.org/) has been the industry leader in performing technical evaluations for code compliance, providing regulators and construction professionals with clear evidence that products comply with codes and standards.

## Automation Overview
ES Web Automation Framework utilizes open source [Selenium](http://seleniumhq.org/) tool to automate ICC ES Application test cases on popular browsers.

## Supported Platforms
- **Chrome** Latest Version
- **IE:** Latest Version
- **Firefox** Latest Version


## Tools
- **Selenium:** for browser interaction 
- **Maven:** for Java project management  
- **TestNG:** for Java Testing framework 
- **RestAssured:** to automate REST APIs
- **Log4j:** to log test execution activities
- **Allure Report:** to report test execution results
- **Git Repository:** to store code
- **Seleniun Grid:** for parallel test execution
- **Jenkins:** for CI/CD

## Integration
- **yopmail:** to exchange information with user
- **MS CRM:** to run cron jobs and provide approvals

---

## Project Setup
- **Automation Code** 
   GIT repository URL: https://github.com/iasinfobeans/ESAutomation/tree/master/ES
- **Pre-requisites**
   - Java SDK 1.8: JAVA_HOME and Java path is setup in system variables.
   - Maven v3.x.x: M2_HOME and MAVEN_HOME are setup in system variables.
   - Eclipse IDE is installed on machine and it should have Git, Maven, and TestNG plugins setup.
   - Java and Maven installed path should be setup in Eclipse IDE.
- **Steps**
   - Launch Eclipse and open its Import window from File menu.
   - Expand Git folder and select "Project From Git" option.
   - Click on Next button.
   - Select "Clone URI" as repository source and click on Next button.
   - Enter Git repository URI - "https://github.com/iasinfobeans/ESAutomation.git"
   - Enter credentials and click on Next button.
   - Select "master" branch and click on Next button.
   - Code should be started downlaoded in git folder inside the system user.
   - Click on Finish button after code is downloaded.
   - Reopen Eclipse Import window and expand Maven folder.
   - Select "Existing Maven Projects" option and click on Next button.
   - Click on Browser button to set root directory - System user -> git - > ESAutomation -> ES.
   - Select pom.xml file and click on Next button.
   - Click on finish button.
   - ES maven project should be displayed in Eclipse.
- **Execution**     
   - Right Mouse Click on ES folder and select Run As-> Maven Build..
   - Enter "clean test site exec:java" in Goals text box (without "").
   - Select JRE tab and add "-DEnv=qa -DBrowser=chrome -DTestSuite=smoke -Dexec.mainClass=com.es.setup.DriverScript" to VM args ((without "").
   - Click on Run.
   - Maven will start downloading project dependencies
   - wait for some time, browser will launch and execution will starts.

## Execution
### Local 
- **Chrome:** -DEnv=qa -DBrowser=chrome -DTestSuite=smoke -Dexec.mainClass=com.es.setup.DriverScript
- **FireFox:** -DEnv=qa -DBrowser=Firefox -DTestSuite=smoke -Dexec.mainClass=com.es.setup.DriverScript
- **IE:** -DEnv=qa -DBrowser=IE -DTestSuite=smoke -Dexec.mainClass=com.es.setup.DriverScript

### Jenkins
In progress 


## Change Log
- Version 1.0.0 - [Change Log](CHANGELOG.md)

## Contributors
- Shefali Garg <shefali.garg@infobeans.com>


## License & copyright
Copyright � 2018 ICC Evaluation Service, LLC.
All rights reserved.
This is the confidential and proprietary information of 
ICC Evaluation Service, LLC. ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with ICC Evaluation Service, LLC.

