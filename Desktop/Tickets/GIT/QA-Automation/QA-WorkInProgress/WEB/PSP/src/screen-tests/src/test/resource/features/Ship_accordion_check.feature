#https://jira.polestarglobal.com/browse/SCREEN-664
@Ship_name_accordion
 @Smoke_Testcases 
  @Regression_Testcases
Feature: This is a feature where the ship name is clicked to open the left panel

  @Ship_name_accordion_1_Latest_screening_results
  Scenario: Clicking on row 1 ship name and checking the Latest Screening Results accordion
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Latest Screening Results accordion
    And close the browser driver

  @Ship_name_accordion_2_Screening_history
  Scenario: Clicking on row 1 ship name and checking the Screening History accordion
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Screening History accordion
    And close the browser driver

  @Ship_name_accordion_3_Ship_information
  Scenario: Clicking on row 1 ship name and checking the Ship information accordion
    Given I login to devtest application with valid username and password
   #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the ship name in the first row.
    Then validate all the Ship Information accordion
    And close the browser driver