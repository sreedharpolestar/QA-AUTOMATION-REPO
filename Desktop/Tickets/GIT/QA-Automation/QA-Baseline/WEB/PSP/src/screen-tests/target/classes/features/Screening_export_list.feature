#https://jira.polestarglobal.com/browse/SCREEN-631
#https://jira.polestarglobal.com/browse/SCREEN-880
@Export_list
 @Smoke_Testcases 
  @Regression_Testcases
Feature: 
  As a Screening PSP user
  download the ships from the screening table

@Export_list_1
  Scenario: Login to application and clicking on Export list button to download all ships 
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then click on the Export list button.
    And close the browser driver
    
    
@Export_list_2
 Scenario: Login to application and clicking on Export list button to download selected ships
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Then I click on multiple check boxes whole multiple rows should be highlighted
    Then click on the Export button which also has the number of ships selected next to it
    And close the browser driver