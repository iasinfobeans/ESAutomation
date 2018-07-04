# IAS Automation

## Overview
[IAS](https://www.iasonline.org/) The International Accreditation Service (IAS) provides objective evidence that an organization operates at the highest level of ethical, legal and technical standards.

Web Automation Framework utilizes open source [Selenium](http://seleniumhq.org/) tool to interact with IAS Application....

## Supported Platforms
- **Chrome** Latest Version
- **IE:** Latest Version
- **Firefox** Latest Version


## Tools
- **Selenium:** to 
- **Maven:** for Java project management  
- **TestNG:** for Java testing framework 
- **RestAssured:** to automate Mobile Web APIs
- **Seleniun Grid:** for parallel test execution
- **Jenkins:** for CI/CD

## Integration
- **TBD** 
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



## Change Log
- Version 1.0.5 - [Change Log](CHANGELOG.md)

## Contributors
- Shefali Garg <shefali.garg@infobeans.com>


## License & copyright
Copyright � 1999 - 2017 IAS
All rights reserved.
This is the confidential and proprietary information of 
IAS, Inc. ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with IAS.

