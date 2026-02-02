# UI + API Automation Framework

## 📌 Overview
This project is a scalable UI and API automation testing framework built using
Java, Selenium WebDriver, Cucumber BDD, and TestNG.
The framework follows Page Object Model (POM) design pattern and supports
BDD-style test automation.


---

## 🛠 Tech Stack
- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Git & GitHub

---
High - Level Architecture Flow

Feature Files (BDD - Gherkin)
        |
        v
Step Definitions (Glue Code)
        |
        v
Page Objects / API Clients
        |
        v
Driver Factory  ---> Browser Initialization
        |
        v
Hooks (Before / After)
        |
        v
Test Execution (Cucumber + TestNG)
        |
        v
Utilities (Config, Waits, Screenshots)
        |
        v
Extent Reports (HTML)

Project Structure

This is a layered BDD automation framework using Selenium, Cucumber, and TestNG.
Driver initialization and configuration are handled in src/main, while test execution logic, hooks, runners, and utilities are placed under src/test.
The framework follows Page Object Model, supports retry logic, extent reporting, screenshots, and clean separation of concerns.

ui-api-automation-framework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.yaswanth.automation
│   │   │       ├── config
│   │   │       │   └── ConfigReader.java
│   │   │       │       # Reads data from config.properties
│   │   │       │
│   │   │       └── driver
│   │   │           └── DriverFactory.java
│   │   │               # Initializes and manages WebDriver
│   │   │
│   │   └── resources
│   │       ├── config
│   │       │   └── config.properties
│   │       │       # Environment details (URL, browser, credentials)
│   │       │
│   │       └── logback.xml
│   │           # Logging configuration
│
│   ├── test
│   │   ├── java
│   │   │   └── com.yaswanth.automation
│   │   │       ├── hooks
│   │   │       │   └── Hooks.java
│   │   │       │       # Cucumber @Before and @After hooks
│   │   │       │
│   │   │       ├── pages
│   │   │       │   └── LoginPage.java
│   │   │       │       # Page Object Model for Login page
│   │   │       │
│   │   │       ├── retry
│   │   │       │   └── RetryAnalyzer.java
│   │   │       │       # Retry logic for failed tests
│   │   │       │
│   │   │       ├── runners
│   │   │       │   ├── TestRunnerTestNG.java
│   │   │       │   │   # Main Cucumber + TestNG runner
│   │   │       │   └── RerunTestRunner.java
│   │   │       │       # Reruns failed scenarios
│   │   │       │
│   │   │       ├── stepdefinitions
│   │   │       │   └── Stepdefinitions_Login.java
│   │   │       │       # Step definitions for Login.feature
│   │   │       │
│   │   │       └── utils
│   │   │           ├── ExtentReportManager.java
│   │   │           │   # Extent report configuration
│   │   │           ├── ScreenshotUtil.java
│   │   │           │   # Screenshot capture utility
│   │   │           └── TestListener.java
│   │   │               # TestNG listener for reporting
│   │   │
│   │   └── resources
│   │       ├── features
│   │       │   └── Login.feature
│   │       │       # BDD feature file
│   │       │
│   │       └── testng.xml
│   │           # TestNG suite configuration
│
├── pom.xml
│   # Maven dependencies and build configuration
│
├── README.md
│   # Project documentation
│
├── target
│   # Maven build output (ignored in Git)
│
└── test-output
    # TestNG execution results (ignored in Git)


## 📂 Framework Architecture
src/main/java
- ConfigReader 
  - Configures data as browser, env Url, Credentials  
- driver  
  - Manages WebDriver creation and lifecycle  
src/main/resources
- config.properties  
  - Environment configuration (URL, browser, etc.)  
- logback xml
src/test/java  
- hooks  
  - Cucumber hooks for setup and teardown  
- pages  
  - Page Object classes containing locators and actions  
 - retryAnalyzer  
  - Analysis failed testcases and prepares to rerun 
- stepdefinitions  
  - Step definition classes mapping feature steps to Java code  
- runners  
  - TestNG Cucumber runner class
  - Rerun Cucumber failed testcases  
- utils  
  - ExtentReports
  - Screenshot utils
  - TestListener

src/test/resources  
- features  
  - Cucumber feature files written in Gherkin  
- config.properties  
  - Environment configuration (URL, browser, etc.)  
- testng.xml  
  - TestNG suite configuration

---

---

## 🧩 Framework Highlights
- **BDD approach** using Cucumber feature files
- **Page Object Model** for UI elements
- **Single WebDriver instance** using DriverFactory
- **Config-driven execution** via `config.properties`
- **Retry logic** for flaky test cases
- **Extent Reports** with screenshots for pass/fail
- **Cucumber Hooks** for setup and teardown
- **TestNG listeners** for enhanced reporting

---

## ▶️ How to Run Tests

### Run via Maven
```bash
mvn clean test

---

## 🚀 How to Run Tests

### Run using Maven
```bash
mvn test
### Run via TestNG
Right-click testng.xml
Select Run As → TestNG Suite

