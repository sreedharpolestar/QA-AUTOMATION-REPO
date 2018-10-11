#https://jira.polestarglobal.com/browse/SCREEN-645

Feature:
As a Screening PSP user
I want to sort the Screening columns individually
so my results are ordered in the selected column.

@Last_Updated_column_sort
 @Smoke_Testcases 
  @Regression_Testcases
  Scenario: Sort the Last Updated column
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I should see by default the page is sorted by Last Updated descending order
    Then I click again on the Last Updated column it should be sorted by descending order
    

  @Shipname_sort
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: Sort the Ship name column
    
    Given I click on Ship name the column should be sorted by ascending order arrow up
    Then I click again on the column name it should be sorted by descending order
   

  @Flagcolumn_sort
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: Sort the Flag column
   
    Given I click on Flag heading the column should be sorted by ascending order arrow up
    Then I click again on the Flag heading column it should be sorted by descending order
    

  @IMO_column_sort
   @Smoke_Testcases 
    @Regression_Testcases
  Scenario: Sort the IMO column
   Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then I click again on the IMO column name it should be sorted by descending order
    Given I click on IMO header the column should be sorted by ascending order arrow up
    

  @Ship_Type_column_sort
   @Smoke_Testcases 
    @Regression_Testcases
  Scenario: Sort the Ship Type column
 
    Given I click on Ship Type header the column should be sorted by ascending order arrow up
    Then I click again on the Ship Type column name it should be sorted by descending order
    And close the browser driver
    
   @Latest_Result_column_sort 
     Scenario: Sort the Last Updated column
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
   # Given I should see by default the page is sorted by Last Updated descending order
   # Then check the Latest result column
    Then check the ascending sorting
    And close the browser driver
    
