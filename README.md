# UI + API Automation Framework

## 📌 Overview
This project is a scalable UI and API automation testing framework built using
Java, Selenium WebDriver, Cucumber BDD, and TestNG.
The framework follows Page Object Model (POM) design pattern and supports
BDD-style test automation.

This framework is designed to be clean, maintainable, and interview-ready.

---

## 🛠 Tech Stack
- Java
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Git & GitHub

---

## 📂 Framework Architecture

src/test/java  
- driver  
  - Manages WebDriver creation and lifecycle  
- hooks  
  - Cucumber hooks for setup and teardown  
- pages  
  - Page Object classes containing locators and actions  
- stepdefinitions  
  - Step definition classes mapping feature steps to Java code  
- runners  
  - TestNG Cucumber runner class  
- utils  
  - Utility classes (config reader, constants, helpers)

src/test/resources  
- features  
  - Cucumber feature files written in Gherkin  
- config.properties  
  - Environment configuration (URL, browser, etc.)  
- testng.xml  
  - TestNG suite configuration

---

## 🚀 How to Run Tests

### Run using Maven
```bash
mvn test
