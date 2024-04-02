Feature: 03. Browse categories

  @valid
  Scenario Outline: TC001: Browse a category logged in
    Given I open Etsy page
    And   I accept GDPR
    And   I open Sign In form
    And   I enter petrescuroberto764@gmail.com and testtesttest for user
    And   I click on Sign In button
    And   I check Welcome message
    When  I click on Categories menu
    And   I select <category> category from menu
    Then  I check category header for <categoryHeader>

    Examples:
      | category      | categoryHeader |
      | Bath & Beauty | Bath & Beauty  |
      | Bags & Purses | Bags & Purses  |
//313dec95751a4e29825fc0ea023e49a3
  @valid
  Scenario Outline: TC002: Browse a category without logging in
    Given I open Etsy page
    And   I accept GDPR
    When  I click on Categories menu
    And   I select <category> category from menu
    Then  I check category header for <categoryHeader>

    Examples:
      | category      | categoryHeader |
      | Bath & Beauty | Bath & Beauty  |
      | Bags & Purses | Bags & Purses  |
    #new