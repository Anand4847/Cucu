@Login
Feature: Login Feature
 
  @positive
  Scenario: Positive scenario
    Given User should be on the login page
    When I enter valid "anandsoni2641@gmail.com" and click on continue button
    And enter valid "Harbhaj@26" 
    And click on signin button
    Then it should navigate the user to the home page
    
     @negative
  Scenario: Negative scenario
    Given User should be on the login page
   When I enter valid "anandsoni2641@gmail.com" and click on continue button
    And enter invalid "Harbhaj" 
    And click on signin button
    Then it should throw the validation error



  
