Feature: Login functionality

@smoke
  Scenario: Valid login
    Given user is on login page
    When user enters "<TestType>" username and password
    Then login should be "<Result>"
    
    Examples:
      | TestType | Result  |
      | valid    | success |
      

    @smoke
  Scenario: Valid login
    Given user is on login page
    When user enters "<TestType>" username and password
    Then login should be "<Result>"
    
    Examples:
      | TestType | Result  |
      | invalid  | failure |

    @smoke
  Scenario: Valid login
    Given user is on login page
    When user enters "<TestType>" username and password
    Then login should be "<Result>"
    
     Examples:
      | TestType | Result  |
      | invalid  | failure |
