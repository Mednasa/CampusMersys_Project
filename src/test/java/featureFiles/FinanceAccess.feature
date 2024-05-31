@SmokeTest
Feature: Finance Access Functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Access the Finance Page via Hamburger Menu
    When User clicks on the "hamburgerMenu" from the header
    And User clicks on the "financeLink" from the drop-down menu
    And User clicks on the "myFinanceLink" from the sub-menu
    Then User should be redirected to the Finance page