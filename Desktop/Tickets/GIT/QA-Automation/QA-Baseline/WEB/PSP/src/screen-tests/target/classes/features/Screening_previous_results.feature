#https://jira.polestarglobal.com/browse/SCREEN-998
Feature: 
  As a Screening PSP user
  hover over the current result of the ship 
  and find the previous result with date.

@Previous_result_check
  Scenario: Login to Devtest and clicking on Export list button to download all ships 
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then check the last updated date of the ship
    Given I select a ship clicking on the checkbox and the `Rescreen` button should be enabled
    Then click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons
    When I click on `Rescreen` button
    Then hover over the current result of the ship to find the previous result.
    Then validate the previous result
    And close the browser driver