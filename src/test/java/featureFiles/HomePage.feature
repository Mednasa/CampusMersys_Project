Feature: Navigate to HomePage

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: User directed to homepage
    Given Locate the company logo in the top left corner of the homepage.
    When Click on the Company Logo
    Then Verify that the user will be redirected to the homepage.

