Feature: Uploading assignments functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario: Uploading Assignments To Campus System

    Given Login to the assignment submission screen and click submit
    When Use functionality such as writing notes, inserting tables and sending images during the assignment submission process
    And Click on the Element
      | editBtn  |
      | pasteBtn |
    Then Verification that the copy and paste button function is not working
    And Click on the Element
      | closeIconBtn   |
      | attachFilesBtn |
      | fromLocalBtn   |
    And Upload files from computer
    And Click on the Element
      | fileBtn        |
      | imageBtn       |
      | saveAsDraftBtn |
    Then Successfully saved as a draft