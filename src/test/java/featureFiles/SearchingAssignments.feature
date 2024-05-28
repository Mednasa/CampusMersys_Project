Feature: Searching assignments functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Searching Assignments To Campus System
    Given Login to the assignment submission
    When Listing of tasks when default search is performed
    And Search and verify assignments by filtering
    And Search and verify assignments using the date icon
    And Search and validate assignments using course, type, date units from the sort menu