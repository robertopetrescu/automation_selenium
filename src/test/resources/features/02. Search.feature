Feature: 02. Search by keyword

  @valid
Scenario: TC001: Test search feature
    Given I open Etsy page
    And   I accept GDPR
    And   I open Sign In form
    And   I enter petrescuroberto764@gmail.com and testtesttest for user
    And   I click on Sign In button
    And   I check Welcome message
    When  I search for perfume
    And   I click on search product button
    Then  Product list is greater than 3

  @valid @ignore
  Scenario: Test search feature without logging in
    Given I open Etsy page
    And   I accept GDPR
    When  I search for perfume
    And   I click on search product button
    Then  Product list is greater than 3