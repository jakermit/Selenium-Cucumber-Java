## Selenium-Cucumber-Java

This repository contains a solution for one of the interview task

### Installation & Prerequisites

1. JDK 11+ (Ensure that the Java class path is properly set)
2. Maven (Ensure that the .m2 class path is properly set)
3. Intellij IDE / or any other
4. Required Plugins:
    - Maven
    - Cucumber
    - Lombok
5. Browser (Ensure that you have the appropriate browser installed)

## Framework Setup

To set up the framework, you can either fork or clone the repository, or download the ZIP file and set it up in your local workspace.

## Running Sample Tests

Access the CLI of your operating system (e.g., iTerm for macOS or PowerShell for Windows) and navigate to the project directory. Then, run the following command to execute the features: `mvn clean test`.
By default, this command will invoke the Chrome browser and execute all tests. On this version other browsers are not supported.

You can also run scenario from your IDE by running entire class `CucumberRunnerTest.java`, or you can run all or single scenario from feature file 

By default parallel execution is on if you want to disable it please change annotation from `@DataProvider(parallel = true)` to `@DataProvider(parallel = false)` 

## Reporters

Once you have run your tests, various types of reports will be automatically generated.

## Reporting

### Cucumber HTML Report

You can find Cucumber Html Report after test execution at `target/cucumber-reports/report.html`.

### Cucumber  JSON Report

You can find Cucumber JSON Report after test execution at `target/cucumber-reports/Cucumber.html`.

### Cucumber XML Report

You can find Cucumber XML Report after test execution at `target/cucumber-reports/Cucumber.xml`.

## BDD Automation with Cucumber-Java and Page Objects

In this repository, I have used Behavior-Driven Development (BDD) with Cucumber and Java to develop automation scripts. I provided predefined Step Definitions packaged at `com.piotr.chmiel.it.consulting.defintions/NewsValidationSteps.java`.

Tests are written in the Cucumber framework using the Gherkin syntax. Features files are placed at `test/resources/features` 

## The Page Object Design Pattern

To better organize test code and make it more maintainable, I used the Page Object Design Pattern.
You can find Page Object related classes at `com.piotr.chmiel.it.consulting.web.pages`