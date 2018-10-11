#https://jira.polestarglobal.com/browse/SCREEN-646
Feature: 
  As a Screening PSP user
  I want to search for a ship using ship name or IMO number
  so I can view the searched ship's details in the table.

  @Screening_results_page_search
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify the search field
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I enter three string characters in the search field
    Then the table has to update with the results for the characters entered
    When I click on cross mark in the search field string should be cleared
    Then I enter a number in the search field  
    Then the screening results table should be updated to return the results with that number
    Then agin I click on cross mark the table should be updated with all the results
    And close the browser driver
