@check_modal_screening
@Smoke_Testcases 
@Regression_Testcases
Feature: This is a feature where 
         Latest Screening results accordion is expanded
         and the individual checks are clicked 
         and then the modal opens.

 
@Port_state_control_history_check_modal
  Scenario: Clicking on row 1 ship name and check the port state control history check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Port State Control history check
    Then click on the Port State Control history check link
    Then validate the modal
    And close the browser driver
    
    
@Ship_global_sanctions_list_check_modal
    Scenario: Clicking on row 1 ship name and check the Ship global sanctions list check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate  Ship global sanctions list check
    Then click on the Ship global sanctions list check link
    Then validate the Ship global sanctions list check modal
    And close the browser driver
    

@Country_sanctions_check_modal  
Scenario: Clicking on row 1 ship name and check the Country sanctions check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Country sanctions check
    Then click on the Country sanctions check link
    Then validate the Country sanctions check link modal
    And close the browser driver  
    
    
@Ship_movement_history_check_modal   
Scenario: Clicking on row 1 ship name and check the ship movement history check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Ship movement history check
    Then click on the Ship movement history check link
    Then validate the Ship movement history check modal
    And close the browser driver  
    
    
    
@Company_global_sanctions_list_check_modal  
Scenario: Clicking on row 1 ship name and check the company global sanctions list check
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Company global sanctions list check
    Then click on the Company global sanctions list check link
    Then validate the Company global sanctions list check  modal
    And close the browser driver  