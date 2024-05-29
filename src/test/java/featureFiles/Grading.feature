Feature: Accessing the grading page and verifying button functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

    Scenario: Grading page and verifying button functionality
      Given Click on the Grading Section
      When Navigate to Grading Page
      Then Click on the Student Transcript Button
      When Navigate to Student Transcript Section
      Then Click on the Course Grade Button
      When Navigate to Course Grade Section
      Then Click on the Transcript by Subject Button
      When Navigate to Transcript by Subject Section

