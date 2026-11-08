
Feature: Login Functionality

  Background:
    Given the user is on the ParaBank home page

  Scenario: Successfully log in as a customer
    When the user enters valid login credentials
    And the user clicks the login button
    Then the user should be logged in successfully



  Scenario Outline: Unsuccessful login with invalid credentials
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should see an error message


    Examples:
      | username      | password      |
      | validUser     | passwordwrong |
      | wrongUser     | validPassword |
      | wrongUser     | wrongPassword |
      |               | validPassword |
      | validUser     |               |

