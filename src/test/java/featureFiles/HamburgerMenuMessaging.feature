Feature: Hamburger Menu Messaging Functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Navigate to the Hamburger Menu Messaging Functionality
    Given User clicks on the hamburger menu button
    Then From opened dropdown menu select messaging
    And Click on the New Message button
    Then User should be redirected to the new message page
    When User clicks on the Add Receiver button
    Then The add receiver window should open, and the user should select receivers.
    | receiverSearch | student |
    | receiverSearch | teacher |
    When User clicks on the Add & Close button


