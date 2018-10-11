#https://jira.polestarglobal.com/browse/SCREEN-673

Feature:
As a Screening PSP user
I want to filter ships in my table by Flag
so I can see only ships under a certain flag/flags.
 @Smoke_Testcases 
  @Regression_Testcases
@Filter_by_flags
  Scenario: Screening table - user can filter table by Flags
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on the flags filter then I enter the flag to be searched in the field
    Then the all flags header should be updated with the number of flags selected
    Then The table should be updated with the search result for flag
    Then I search for another flag type then the screening results page should be updated with the flag type selected
    Then the all flags header should be updated with the 2 flags selected
    Then click on the clear flag selection the table should be updated with all the results
    And close the browser driver
 @Smoke_Testcases 
  @Regression_Testcases
  @filter_cross_mark_flag
  Scenario: Verify clicking on `X` will remove the filter selected
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on the flags filter then I enter the flag to be searched in the field
    Then the all flags header should be updated with the number of flags selected
    Then The table should be updated with the search result for flag
    Then I click on the cross mark next to the flag filter , the filter should be removed and the table should be updated with all the results
    And close the browser driver
