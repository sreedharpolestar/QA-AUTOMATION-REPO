#https://jira.polestarglobal.com/browse/SCREEN-656
 @Smoke_Testcases 
  @Regression_Testcases
@by_spreadsheet
Feature: 
  As a Screening PSP user
  I want to upload a file of IMOs
  so I can screen the ships with those IMOs.

@spreadsheet_landingpage
  Scenario: Login to Devtest and clicking on Screening menu
    Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page

@Valid_format
  Scenario: To browse and add the csv file
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I click on `By spreadsheet` tab
    Then I should be landed in By spreadsheet page and should see the header
    Given I click on browse button
    Then search and upload the file
    Then the file should be listed and verify the text in the search field
    Then verify the screen button is enabled and click
    Then I should be landed in Screening results page

  @Invalid_format
  Scenario: To verify the non-csv file is not screened
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I click on `By spreadsheet` tab
    Then I should be landed in By spreadsheet page and should see the header
    Given I click on browse button
    Then search and upload the invalid format file
    Then the file should be listed and verify the text in the search field
    Then verify the screen shouldn't be enabled and should see an validation message
 
  @Cancel
  Scenario: Clicking on Cancel button
    Given I click on Cancel button and then I should land in Screening results page
    And close the browser driver
