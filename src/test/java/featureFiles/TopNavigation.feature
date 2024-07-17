Feature: Top Navigation Menu
  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

    Scenario:
      Given The user should be able to see all the main menu items
      When The right action should take place when clicking on any of the main menu elements
