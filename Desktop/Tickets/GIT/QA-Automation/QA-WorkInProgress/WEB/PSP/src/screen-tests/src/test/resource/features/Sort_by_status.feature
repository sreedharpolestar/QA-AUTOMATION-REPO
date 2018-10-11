Feature:
As a Screening PSP user
I want to sort the Screening columns individually
so my results are ordered in the selected column.

@Status_sort
 @Smoke_Testcases 
  @Regression_Testcases
  Scenario: Sort the Status column
    Given I login to devtest application with valid username and password
    Then I should be landed in Screening results page
    Then check whether the status column is present
    Then sort Status column in ascending order
    Then click on the status column 
   # Then the status column should be sorted in descendng order
    And close the browser driver

    
    
