#https://jira.polestarglobal.com/browse/SCREEN-650
Feature: 
  As a Screening PSP user
  I want to permanently remove ships from my Screening table
  so I do not see them anymore.

  @modal_cancel
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can select and Cancel ship
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I select a ship clicking on the checkbox and the decline button should be enabled
    Then the number next to the decline should be updated to `1` next to it
    Then click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons
    When I click on `Cancel` the ship should still be selected
    And close the browser driver

  @modal_decline_one_ship
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can select and Decline ship
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Given I select a ship clicking on the checkbox and the decline button should be enabled
    Then click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons
    Then I click on `Decline` ship should be deleted and the ship count has to be reduced by one
    And close the browser driver

  @modal_decline_two_ships
   @Smoke_Testcases 
  @Regression_Testcases
  Scenario: This is to verify user can select and decline multiple ships
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Given I select two ships clicking on the checkbox and the decline button should be enabled
    Then the number next to the decline should be updated to two next to it
    Then click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons with heading and message changed
    When I click on `Cancel` the ships should still be selected
    Then click on the Decline button, a modal should be seen with `CANCEL` and `DECLINE` buttons with heading and message changed
    But when I click on `Decline` ships should be deleted and the ship count has to be reduced by two
    And close the browser driver
    
    
   
