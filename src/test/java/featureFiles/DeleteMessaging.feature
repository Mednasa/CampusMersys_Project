Feature: Deleting from Outbox via Hamburger Menu

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

    Scenario: Delete message
      When Click on the outbox in the messaging section in the hamburger menu
      Then Delete the message and verify whether the message has been deleted
