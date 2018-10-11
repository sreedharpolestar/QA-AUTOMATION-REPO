#https://jira.polestarglobal.com/browse/SCREEN-647
Feature: 
  As a Screening PSP user
  I want to rescreen the ships in the table.
  

  @Rescreen_modal_cancel
  @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can rescreen the ship.
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I select a ship clicking on the checkbox and the `Rescreen` button should be enabled
    Then number next to the Rescreen should be updated to `1` next to it
    Then click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons
    When I click on `Cancel` on the rescreen the ship should still be selected
    And close the browser driver
    
    
    
  @Rescreen_1_ship
  @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can rescreen the ship.
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I select a ship clicking on the checkbox and the `Rescreen` button should be enabled
     Then number next to the Rescreen should be updated to `1` next to it
    Then click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons
    Then Validate the pop up for header and message
    When I click on `Rescreen` button
    Then the ship current result should be in pending status
    And close the browser driver
    
  
  @Rescreen_screening_table
  @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can rescreen the ship.
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons  
   Then validate the pop up
   Then click cancel in the pop up 
    And close the browser driver
    
    
    
    