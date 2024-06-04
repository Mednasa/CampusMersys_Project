Feature: Accessing the grading page and verifying button functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Grading page and verifying button functionality
    Given Click on the Grading Section
    Then  Verify to Navigate to the grading page
    When Click on the Student Transcript Button
    Then Verify to Navigate to Student Transcript Section
    When Click on the Course Grade Button
    Then Verify to Navigate to Course Grade Section
    When Click on the Transcript by Subject Button
    Then Verify to Navigate to Transcript by Subject Section

