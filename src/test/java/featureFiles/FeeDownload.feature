Feature: Hamburger Menu Messaging Functionality

  Background:
    Given Navigate to the Campus
    When Enter the valid credentials and click the login button
    Then User should be logged in successfully

  Scenario:
    Given User clicks on the hamburger menu button
    Then User clicks on the "financeLink" from the drop-down menu
    And User clicks on the "myFinanceLink" from the sub-menu
    When User clicks on the "financeMoreOptionsBtn" from the fees page
    And User clicks on the "feeExcelExport" from three-point menu button
    Then User clicks on the "financeMoreOptionsBtn" from the fees page
    And User clicks on the "feePdfExport" from three-point menu button
    And User clicks on the download button from page he or she is directed to



