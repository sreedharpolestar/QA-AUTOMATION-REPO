
#https://jira.polestarglobal.com/browse/SCREEN-816
@Download_latest_report_from_modal_accordion
@Smoke_Testcases 
@Regression_Testcases

Feature: 
  As a Screening PSP user
  to download full report from Latest Screening accordion 
  and also from all the modals.
  
  @Download_latest_report_from_accordion
   Scenario: This is to download Full report from the Latest Screening results accordion
   
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate the 'Download full report' button in the accordion
    Then click on the button
    Then validate the file in the system
    And close the browser driver
    
       
    @Ship_global_sanctions_list_check_modal_download
    Scenario: Clicking on row 1 ship name and check the download feature in Ship global sanctions modal
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate  Ship global sanctions list check
    Then click on the Ship global sanctions list check link
    Then click on the download button in the Ship global modal
    And close the browser driver
    
    
   @Port_state_control_history_check_modal_download
   Scenario: Clicking on row 1 ship name and check the download feature in Port State control modal
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Port State Control history check
    Then click on the Port State Control history check link
    Then click on the download button in the Port state modal
    And close the browser driver
    
    
    @Country_sanctions_check_modal_download
    Scenario: Clicking on row 1 ship name and check the download feature in Country sanctions check modal
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Country sanctions check
    Then click on the Country sanctions check link
    Then click on the download button in the Country sanctions modal
    And close the browser driver
    

    
    @Ship_movement_history_check_modal_Download  
    Scenario: Clicking on row 1 ship name and check the ship movement history check result
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Ship movement history check
    Then click on the Ship movement history check link
    Then click on the download button in the Ship movement history modal
    And close the browser driver  
    
  
 
@Company_global_sanctions_list_check_modal_Download  
Scenario: Clicking on row 1 ship name and check the company global sanctions list check
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then Validate Company global sanctions list check
    Then click on the Company global sanctions list check link
    Then click on the download button in the Company global sanctions list modal
    And close the browser driver  
    
    
    
    