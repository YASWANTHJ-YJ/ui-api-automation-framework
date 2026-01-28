Feature: Login functionality

@smoke
  Scenario: Valid login
    Given user is on login page
    When user enters valid username and password
    Then user should be logged in successfully
