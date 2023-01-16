Feature: Check the input methods in feature file
  I want Check the input methods in feature file


  Scenario: Title for scenario
    Given I lauch the URL"https://phptravels.com/demo/"
    And input value to name as "NIBRAS"
  
@so 
  Scenario Outline: Title for scenario outline
    Given I lauch the URL"https://phptravels.com/demo/"
    When I want to write a step with "<firstname>"
    Then I check for the "<lastname>" in step
    And I verify the "<businessname>" in step

    Examples: 
      | firstname   | lastname | businessname  |
      | NIB         |     PT	 | QEA 			     |
      | AJU         |    Rahma | Q2  				   |

  @datatable    
  Scenario: Using data table
    Given I lauch the URL"https://phptravels.com/demo/"
 	  When  i fill the valid date in the fields with list of list
 	| Fields                 | Values              |
	| First Name             | SARBIN              |
	| Last Name              | Data table          |
	| businessname           | tetqea DT           |
	  And  i fill the valid data using data Table with Header and Single Row with list of map
  | First Name   |  Last Name    | businessname        |
  | SARBIN2      | Data table2 | tetqea DT2 | 
	 And   i fill the valid data using data Table with Header and Multiple Row with list of map
	 | First Name   |  Last Name    | businessname        |
   | SARBIN3      | Data table3 | tetqea DT3 | 
	 | SARBIN4     | Data table4 | tetqea DT4 | 
	 	And display message success in console
