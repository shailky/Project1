# Getting started with Serenity and Cucumber

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured. 

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

The latest version of Serenity supports Cucumber 5.5.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
          + useCase.feature                  Feature file subdirectories 
             
       + webdriver                 Bundled webdriver binaries
         + linux
         + mac
         + windows 
           chromedriver.exe       OS-specific Webdriver binaries 
           geckodriver.exe
```

This project assumes that you have the latest version of Chrome (83) installed.

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `src/test/resources/webdriver` directories. These binaries are configured in the `drivers` section of the `serenity.conf` config file:
```json
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/webdriver/windows/geckodriver.exe"
  }
This configuration means that development machines and build servers do not need to have a particular version of the WebDriver drivers installed for the tests to run correctly.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = ""
  }
  dev {
    webdriver.base.url = ""
  }
  staging {
    webdriver.base.url = ""
  }
  prod {
    webdriver.base.url = ""
  }
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```
Attempted: UI Automation
Framework: Serenity-Cucumber-BDD framework
Framework Description: Serenity BDD is a library that makes it easier to write high-quality automated acceptance tests, with powerful reporting and living documentation features. Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

Project Structure:
UseCasePageObjects.java- It contains all the locators of the page. Since we are dealing with only home page. hence, I have created a single class. Page classes increases as per the number of pages to be navigated.
UseCaseStepDefinitions.java- It controls the calling of steps in feature file. Step definition maps the Test Case Steps in the feature files(introduced by Given/When/Then) to code. 
UseCaseSteps.java- Implementation of step definition files lies in steps file which calls locators from UseCasePageObjects
UseCases.feature- It contains a list of scenarios to be tested for that feature. Given/When/Then/And defines the scenarios. Verification steps resides in THEN keyword
Serenity.conf- Default URL and browser details are mentioned in this file

Reporting: Serenity generates a single-page, self-contained HTML summary report, containing an overview of the test results, and a configurable breakdown of the status of different areas of the application. It contains screenshot of all the steps executed. Hence the scenario mentioned in use case 1 where user needs to take screenshot of the item could be covered with reporting. We don't need to explicitly mention screenshot methods
Report Location: Project->Target->site->Serenity->Index.html

Dependencies: All dependencies are added in pom.xml. U need to download dependencies after importing the project.

Project running can be achieved by following: 
1.By running CucumberTestSuite
2.By running UseCase.feature
3.Go to terminal-> mvn clean verify
4.Go to terminal-> mvn clean verify -Dcucumber.options="--tags @TC1/@TC2"
