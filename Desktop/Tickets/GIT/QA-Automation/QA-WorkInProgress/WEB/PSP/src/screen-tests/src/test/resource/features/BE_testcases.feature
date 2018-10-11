@BE_testcases

Feature: This is a feature where the ship name is clicked to open the left panel

 @Port_state_control_history_check_1
  Scenario: Clicking on particular ship and checking the result for Port state control history check
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name XXX
    Then validate all the Latest Screening Results accordion
    Then Validate Port State Control history check
    Then verify the result
    And close the browser driver
    
    @Ship_global_sanctions_list_check_1
    Scenario: Clicking on particular ship and checking the result for ship global sanctions list check
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name XXX
    Then validate all the Latest Screening Results accordion
    Then Validate  Ship global sanctions list check
    And close the browser driver
    
    @Company_global_sanctions_list_check_1
    Scenario: Clicking on particular ship and checking the result for Company global sanctions list check
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name XXX
    Then validate all the Latest Screening Results accordion
    Then Validate Company global sanctions list check
    And close the browser driver
    
    @Country_sanctions_check_1
    Scenario: Clicking on particular ship and checking the result for Country sanctions check
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name XXX
    Then validate all the Latest Screening Results accordion
    Then Validate Country sanctions check
    And close the browser driver
    
    @Ship_movement_history_check_1
    Scenario: Clicking on particular ship and checking the result for Country sanctions check
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name XXX
    Then validate all the Latest Screening Results accordion
    Then Validate Ship movement history check
    And close the browser driver
    
    
    
    