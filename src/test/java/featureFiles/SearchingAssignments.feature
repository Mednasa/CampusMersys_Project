Feature: Searching assignments functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Searching Assignments To Campus System
    Given Login to the assignment submission
    When Listing of tasks when default search is performed
