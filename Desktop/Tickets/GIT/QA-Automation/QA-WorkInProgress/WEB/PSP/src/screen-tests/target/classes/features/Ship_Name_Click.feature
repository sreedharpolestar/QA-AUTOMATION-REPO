
@Ship_Name_Click
@Smoke_Testcases 
@Regression_Testcases
Feature: This is a feature where the ship name is clicked to open the left panel

  @Ship_Name_Click_1
  Scenario: Clicking on row 1 ship name from the screening table
             and to validate the Year of build.
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate the year of build for the ship.
    And close the browser driver