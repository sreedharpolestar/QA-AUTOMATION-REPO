  #https://jira.polestarglobal.com/browse/SCREEN-661
@Smoke_Testcases 
@Regression_Testcases
@All_results

Feature:
Filtering the screening table based on results

    
   @All_results_dropdown_dropdown_check
 
   Scenario: Selection of ship global sanctions check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    And close the browser driver 
    
@All_results_dropdown_select_the_check_ship_global_sanctions_list
 
   Scenario: Selection of ship global sanctions check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select Ship global sanction check.
    Then Critical value alone should be selected
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then validate whether Ship global sanctions list check result is Critical
    And close the browser driver
     
    
    @All_results_dropdown_select_the_port_state_control
    Scenario: Selection of port state control check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select port state control check
    Then Warning value alone should be selected
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then validate whether port state control check result is Warning
    Then close the browser driver
    
    @All_results_dropdown_select_the_ship_movement_history
    Scenario: Selection of ship movement history check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select ship movement history check
    Then OK value alone should be selected
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then validate whether ship movementhistory check result is OK
    Then close the browser driver
     
     
     @All_results_dropdown_select_the_Country_sanctions_check
    Scenario: Selection of country sanctions check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select Country sanctions check
    Then OK value alone should be selected
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then validate whether Country sanctions check result is OK
    Then close the browser driver
    
    
     @All_results_dropdown_select_the_Company_global_sanctions
    Scenario: Selection of company global sanctions check from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select Company global sanctions check
    Then Unknown value alone should be selected
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    Then validate whether Company global sanctions check result is Pending
    Then close the browser driver
    
    
    @All_results_dropdown_select_the_overall_screening_result_by_escalated_results
    Scenario: Selection of overall screening result option from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select overall screening result option
    Then click on the Escalated results only toggle button
    Then close the browser driver
    
    
    @All_results_dropdown_select_the_overall_screening_result_by_critical
    Scenario: Selection of overall screening result option from the filter.
  Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select overall screening result option
    Then Critical value alone should be selected
    And close the browser driver
    
    
    @All_results_Filter_button_validation_after_selection
    Scenario: Selection of option and result from the dropdown and checking the buton title according to selection
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check the filter and select overall screening result option
    Then click on the Escalated results only toggle button