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
- **Seleniun Grid:** for parallel test execution
- **Jenkins:** for CI/CD

## Integration
- **yopmail:** to exchange information with user
- **MS CRM:** to run cron jobs and provide approvals

---

## Execution
- **Setup Steps** 
   Take latest code from GIT repository. URL for git is - https://github.com/iasinfobeans/IASAutomation.git
   Go to root folder of project ES, (right click) Run As->Run Configurations-> go to JRE tab and add -DEnv=qa -DBrowser=chrome      -DTestSuite=smoke -Dexec.mainClass=com.ias.setup.DriverScript to VM args
   To run project as Maven -> Set up MAVEN_HOME and path in environment variable.Go to root folder of project IAS, (right click) Run As->Run Configurations->in Main tab, under goals , put - clean test site exec:java as maven goals.
   

## Execution
### Local 
- **Chrome:** -DEnv=qa -DBrowser=chrome -DTestSuite=smoke -Dexec.mainClass=com.ias.setup.DriverScript
- **FireFox:** -DEnv=qa -DBrowser=Firefox -DTestSuite=smoke -Dexec.mainClass=com.ias.setup.DriverScript
- **IE:** -DEnv=qa -DBrowser=IE -DTestSuite=smoke -Dexec.mainClass=com.ias.setup.DriverScript

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

