Feature: Login Functionality

  @SmokeTest
  Scenario: Login with valid credentials
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Login without credentials
    Given Navigate to the Campus
    When User attempts to login without entering credentials
    Then The system should display an error message indicating that credentials are required

  Scenario: Login with only username entered
    Given Navigate to the Campus
    When User enters only username and clicks the login button
    Then The system should display an error message indicating that password is required

  Scenario: Login with only password entered
    Given Navigate to the Campus
    When User enters only password and clicks the login button
    Then The system should display an error message indicating that username is required