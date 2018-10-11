#https://jira.polestarglobal.com/browse/SCREEN-675
Feature: 
  As a Screening PSP user
  I want to filter ships in my table by ship type
  so I can see only ships of a certain type.
 @Smoke_Testcases 
  @Regression_Testcases
   @Filter_by_ship_type
  
  Scenario: Screening table - user can filter table by ship type
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on the ship_types filter then I enter the ship_type to be searched in the field
    Then the all ship_type header should be updated with `1 ship type` selected
    Then The table should be updated with the search result for ship_type
    Then I search for another ship_type then the screening results page should be updated with the ship_type selected
    Then the all ship_type header should be updated with the `2 ship types` selected
    Then click on the clear ship_type selection the table should be updated with all the results
    And close the browser driver
 @Smoke_Testcases 
  @Regression_Testcases
   @filter_cross_mark_ship_type
  Scenario: Verify clicking on `X` will remove the filter selected
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on the ship_types filter then I enter the ship_type to be searched in the field
    Then the all ship_type header should be updated with `1 ship type` selected
    Then The table should be updated with the search result for ship_type
    Then I click on the cross mark next to the ship_type filter , the filter should be removed and the table should be updated with all the results
    And close the browser driver
