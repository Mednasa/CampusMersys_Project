Feature: Navigate to HomePage

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: User directed to homepage
    Given See the company logo
    When Click on the Company Logo
    Then Navigate to Homepage

