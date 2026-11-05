
Feature: User Registration

  Scenario: Successfully register a new customer

    Given the user is on the ParaBank home page
    When the user clicks on the Register link
    And the user fills out the registration form with valid information
    And the user submits the registration form
    Then the user should see a successful registration message
    And the user should see a welcome message containing their username
