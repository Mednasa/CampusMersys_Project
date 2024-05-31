Feature: Functionality Of Calendar Functions

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Tracking courses from the calendar section
    Given Weekly lesson plan and today's date appear and verify
    When Visibility of P, S, E, C symbols and their meanings on the page
    And Look at the icons (Previous, Today, Next) on the weekly course plan page and click.
    And View the status of scheduled lessons represented by icons (P, S, E, C)
    Then Visibility and clickability of two links to switch to Weekly Course Plan and Calendar pages