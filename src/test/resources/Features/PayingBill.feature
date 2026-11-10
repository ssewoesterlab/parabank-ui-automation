Feature: Paying Functionality


  Background:
    Given the user is on the ParaBank home page
    When the user enters valid login credentials
    And the user clicks the login button
    Then the user should be logged in successfully


  @Smoke @Regression
  Scenario Outline: Pay a <bill_type> bill
    Given the user opens the Bill Pay page
    When the user enters "<payee_name>" as the payee name
    And the user fills in the other payee details with random values
    And the user enters "<amount>" as the amount
    And the user selects the payment account
    And the user clicks the pay button
    Then the payment should be completed successfully


    Examples:
      | bill_type   | payee_name                 | amount |
      | electricity | Enerjisa Elektrik Faturası | 15     |
      | water       | İSKİ Su Faturası           | 45     |
      | natural gas | İGDAŞ Doğalgaz Faturası    | 20    |






