#https://jira.polestarglobal.com/browse/SCREEN-662
Feature: 
  As a Screening PSP user
  I want to select multiple ships in the table
  so I can perform actions based on selected ships.
 @Smoke_Testcases 
  @Regression_Testcases
@single_row
  Scenario: Click on the one check box whole row should be selected/highlighted.
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then I click on one check box whole row should be highlighted
    But when I unclick on the checkbox the row should be unselected.
    
 @Smoke_Testcases 
  @Regression_Testcases
@multiple_row
   Scenario: Click on the multiple check box whole multiple rows should be selected/highlighted.
    Then I click on multiple check boxes whole multiple rows should be highlighted
    But when I unclick on the checkboxes the row should be unselected.
    And close the browser driver