Feature: Profile Picture Management

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario:  Interactive Profile Photo Management
    Given Click on the profile and click on the Settings
    Then Verification that you are on the settings page
    When Click on the profile picture and upload button
    And  Select the photo to upload from the files
    And After taking the photo, click the Upload button and save button
    Then Receive a Success message when they successfully upload or change their profile picture.