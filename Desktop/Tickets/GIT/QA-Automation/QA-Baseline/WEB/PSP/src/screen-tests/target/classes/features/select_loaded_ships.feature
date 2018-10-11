#https://jira.polestarglobal.com/browse/SCREEN-651
Feature: 
  As a Screening PSP user
  I want to select all loaded ships in the table
  so I can perform actions on the selected ships.

  @select_all_check_box
   @Smoke_Testcases 
  @Regression_Testcases
  
  Scenario: Clicking on the checkbox at the top should select all the ships loaded
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on the check at the top should select all the ships which are loaded
    Then the checkbox should a tick mark
    But when I clear on the check box all the selections should be cleared
    And close the browser driver

  @select_all_with_flag_filter
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is check the select all feature with the flag filter
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I select a flag filter
    Then I click on clear_flag_filter selection
    Then I select a flag filter and search for the same flag_type string
    Then only the ships which were loaded with the filter should be selected
    And close the browser driver
    
    @select_all_with_ship_type_filter
     @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is check the select all feature with the flag filter
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I select a ship_type filter
    Then I click on the checkbox at the top
    Then I click on clear_ship_type_filter selection
    Then I select a ship_type filter and search for the same ship_type string
    Then only the ships which were loaded with the filter should be selected
    And close the browser driver
