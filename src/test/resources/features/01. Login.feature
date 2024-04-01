Feature: Login file

  Background:
    Given I open Etsy page
    And   I accept GDPR
    When  I open Sign In form

  @valid
  Scenario: Test login feature with valid credentials
    And   I enter petrescuroberto764@gmail.com and testtesttest for user
    And   I click on Sign In button
    Then  I check Welcome message

  @invalid
  Scenario Outline: Test invalid login credentials
    And   I enter <username> and <password> for user
    And   I click on Sign In button
    Then  I check Incorrect username message

    Examples:
      | username  | password |
      | inoccrect | password |