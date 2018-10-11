#https://jira.polestarglobal.com/browse/SCREEN-839
Feature: 
  As Screening PSP user
  I want to see an element containing add ship errors
  so I know I have entered incorrect IMO numbers.

@verify_already_existing_screening_error
  Scenario: Login to Devtest and clicking on Screening menu
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given If the screening error element is visible then click on the error element and clear all errors
    And close the browser driver
    
@verify_screening_error_visibility_when_invalid_imo_added
  Scenario: verify_screening_error_visibility_when_invali_imo_added
  	Given I login to devtest application with valid username and password
   # When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I click on `By list` tab
    Then I should be landed in By list page and should see the header
    Given I click on the text field and copy paste the invalid IMO's
    Then click on Screen button I should be landed in Screening results page
    Then On the screening results page screening_errors tab should be seen
 		Given I click on the screening_errors element I should see the fields
 		Then I can click on individual invalid IMO's to clear the list
 		Then the count next to the screening error should decrement
 		But I can also click on `Clear all` to clear all the invalid IMO list
 		And close the browser driver
 		

