
Feature: Validate the functionality of the application "Festicket"
  To test the Search functionality in the application

  @tag1
  Scenario Outline: Validate the search functionality for the festival present
    Given User is on the chrome browser
    When User navigates to the Festicket homepage
    And Click on search 
    And Enters the festival "<name>"
    And User select the festival "<Festival_Name>"
    Then User should be presented with the festival result page and verify the festival name
    And Browser Closes

  Examples: 
      | name   | Festival_Name |
      | Surrey | The Surrey Food Festival 2019 |   
      | lovebox| Lovebox Festival 2019 |
      | hide   | Hideout Festival 2018 |
		
	@Tag2
	Scenario Outline: Validate the search functionality for invalid festival name
		Given User is on the chrome browser
    When User navigates to the Festicket homepage
    And Click on search
    And Enter the invalid festival "<name>"
    Then User should see the empty list and cannot proceed
    And Browser Closes 
    
   Examples:
   		| name   | 
   		|        | 	
   		|********|