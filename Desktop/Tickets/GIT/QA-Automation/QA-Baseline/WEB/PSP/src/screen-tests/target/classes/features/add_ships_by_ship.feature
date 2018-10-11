#https://jira.polestarglobal.com/browse/SCREEN-654
@Add_by_Ship

Feature: 
  As a Screening PSP user
  I want to search and select a ship using IMO or ship name
  so I can initiate screening on the ship.

  @single_ByShip
  Scenario: This is to verify the screening BY ship page
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I click on search field and enter the text
    Then I should see the search results updated and I click on the first search result
    Then Selected ship should be updated successfully and the number next to screen button is updated
    Then click on Screen button I should be landed in Screening results page
    And close the browser driver

  @multiple_ByShip
  Scenario: This is to verify user can add multiple ships
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I select mutiple ships from the search results
    Then Selected ship should be updated successfully and the number next to screen button is updated to the ship num selected
    Then click on Screen button I should be landed in Screening results page
    And close the browser driver

  @cross_mark_click_by_ships_page
  Scenario: This is to verify the clicking on "X" mark ship is deselected.
    Given I login to devtest application with valid username and password
    #When I click on Notifications menu and then I click on Screening menu
    Then I should be landed in Screening results page
    Given I click on `Add ships` button
    Then I land in `Add ship(s) to be screened page`
    Given I click on search field and enter the text
    Then I should see the search results updated and I click on the first search result
    Then Selected ship should be updated successfully and the number next to screen button is updated
    Given I click on the `X` mark next to the ship name then ship should be deselected
    Then Screen button should be disabled and the count next should disappear
    And close the browser driver
