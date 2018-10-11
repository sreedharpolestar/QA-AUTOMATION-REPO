#https://jira.polestarglobal.com/browse/SCREEN-664
@Latest_Screening_results
 @Smoke_Testcases 
  @Regression_Testcases
Feature: This is a feature where the ship name is clicked to open the left panel.
 click on Latest Screening Results and validate the links and corresponding results.
 
  @Port_state_control_history_check
  Scenario: Clicking on row 1 ship name and check the port state control history check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Port State Control history check
    And close the browser driver
    

    @Ship_movement_history_check
    Scenario: Clicking on row 1 ship name and check the ship movement history check result
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Ship movement history check
    And close the browser driver
    
    @Country_sanctions_check
    Scenario: Clicking on row 1 ship name and check the Country sanctions check result
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Country sanctions check
    And close the browser driver
    
    
    @Company_global_sanctions_list_check
     Scenario: Clicking on row 1 ship name and check the Company global sanctions list check result
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Company global sanctions list check
    And close the browser driver
    
    @Ship_global_sanctions_list_check
    Scenario: Clicking on row 1 ship name and check the Ship global sanctions list check result
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate  Ship global sanctions list check
    And close the browser driver
    
    @Last_Updated
    Scenario: Clicking on row 1 ship name and check the Last updated
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate  Last updated and Date
    And close the browser driver
    
   