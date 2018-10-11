#https://jira.polestarglobal.com/browse/SCREEN-655
@Smoke_Testcases 
@Regression_Testcases
@add_by_list
Feature: 
  As a Screening PSP user
  I want to see an input box
  so I can manually enter IMO numbers to be screened.

  Scenario: Login to Devtest and clicking on Screening menu
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page

  Scenario: Verify all the headings in Add ships By ship page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`

  Scenario: To be landed in By list page
    Given I click on `By list` tab
    Then I should be landed in By list page and should see the header

  Scenario: Copy pasting the IMO's separated by commas
    Given I click on the text field and copy paste the IMO's
    Then `Screen` button should be enabled and number next to should get updated
    Then click on Screen button I should be landed in Screening results page

  Scenario: Click on Cancel should be landed in Screening results page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Then I click on `By list` tab
    Then I click on the text field and copy paste the IMO's
    But I click on `Cancel` button
    Then I should be landed in Screening results page
    

  
   Scenario: Click on Screen should be landed in Screening results page with the added ships
    Given check the Refresh button text
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Then I click on `By list` tab
    Then I click on the text field and copy paste the IMO's
    Then verify the screen button is enabled and click
    Then I should be landed in Screening results page
    Then the Refresh button text should change to pending ships
    And close the browser driver 
    