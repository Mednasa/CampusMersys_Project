Feature: Attendance Functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Access the Excuse Page from the Attendance Link Submit an Excuse with Attached Files
    When User navigates to the Attendance Excuses via Attendance Link
    Then User should be redirected to the excuse submission page
    When User clicks on the Add icon and writes the excuse in the provided text area
    And User attaches the medical report or an optional file and clicks the send button
    Then User should see a confirmation message