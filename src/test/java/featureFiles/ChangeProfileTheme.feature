Feature: Change theme from profile

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

    Scenario: Change theme
      When Click on the profile, click on the settings button from the submenu that opens
      And Theme one
      Then Receive verification message
      When Click on the profile, click on the settings button from the submenu that opens
      And Theme two
      Then Receive verification message
      When Click on the profile, click on the settings button from the submenu that opens
      And Theme three
      Then Receive verification message