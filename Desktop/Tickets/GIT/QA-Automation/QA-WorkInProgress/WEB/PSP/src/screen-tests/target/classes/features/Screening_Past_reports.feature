#https://jira.polestarglobal.com/browse/SCREEN-1003

Feature: 
  As a Screening PSP user
  to download past report  from Screening history accordion
 
  
  @Download_past_report_from_screening_history
   Scenario: This is to download past report from screening history accordion
   
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Given I select a ship clicking on the checkbox and the `Rescreen` button should be enabled
    Then number next to the Rescreen should be updated to `1` next to it
    Then click on the `Rescreen` button, a modal should be seen with `CANCEL` and `Rescreen` buttons
    When I click on `Rescreen` button
    Then click on the ship name in the first row.
    Then validate all the Screening History accordion
    Then validate the Screening History table in the accordion
    Then click on Download button.
    Then check whether the file is downloaded
    And close the browser driver
    
     