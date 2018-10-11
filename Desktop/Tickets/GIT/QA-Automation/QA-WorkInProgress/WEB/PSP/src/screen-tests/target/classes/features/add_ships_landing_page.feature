#https://jira.polestarglobal.com/browse/SCREEN-690
@AddShips_LandingPage
 @Smoke_Testcases 
  @Regression_Testcases
Feature: 
  landing page after you click on "add ships". has a "cancel" button only

  Scenario: Login to Devtest and clicking on Screening menu
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page

  Scenario: Verify all the headings in Add ships By ship page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Then I should see the subtext under page heading
    Then `Cancel` button should be seen which is enabled
    Then `Screen` button which is disabled
    And `By ship` tab higlighted
    And close the browser driver
