@SmokeTest
Feature: Calendar Functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Click on a Lesson in the Weekly Course Plan Page
    Given user navigates to the weekly course plan page via Calendar link.
    When user clicks on a lesson
    Then a window should open and the user should see the name of the course in the opened window

  Scenario: Click on a Lesson that has not Started yet
    When user clicks on a lesson that has not started yet
    Then the course name, teacher name, date and time should be displayed
    And the message "Course Meeting has not been started yet" should be shown

  Scenario: Click on a Lesson
    When user clicks on a published lesson
    Then a pop-up window contains the course information should be opened
    And user should see the Information, Topic, Attachments and Recent Events links are running correctly for the published lesson
    When user clicks on an ended lesson
    Then a pop-up window contains the course information should be opened
    And user should see the Information, Topic, Attachments and Recent Events links are running correctly for the ended lesson


