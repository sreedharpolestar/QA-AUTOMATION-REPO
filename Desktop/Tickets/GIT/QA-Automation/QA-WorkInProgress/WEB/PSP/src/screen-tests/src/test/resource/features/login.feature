@login
 @Smoke_Testcases 
  @Regression_Testcases
Feature: This is a Login feature

  Background: 
    Given I navigate to the devtest URL

  @login_1
  Scenario: Login with valid username and password
    When given valid username and valid password
    Then Click on Login button
    Then I should be logged in successfully
    Then click on logout button
    And close the browser driver

  @login_2
  Scenario: Login with invalid username and invalid password
    When give invalid username and invalid password
    Then Click on Login button
    Then login should be unsuccessful
    And close the browser driver

  @login_3
  Scenario: Login with invalid username and valid password
    When give invalid username and valid password
    Then Click on Login button
    Then login should be unsuccessful
    And close the browser driver

  @login_4
  Scenario: Just click on Login button without username and password
    When I click on Login button without username and password
    Then login should be unsuccessful
    And close the browser driver
