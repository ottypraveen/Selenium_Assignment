@ErrorValidation1
Feature: Error validation
  I want to use this template for my feature file



  Scenario Outline: Error Validation
    Given I landed on Ecommerce Page
    When Logged in with username "<name>" and password "<password>"
    Then "*Enter Valid Email" message is displayed

     Examples: 
      | name  								|  password		    |
      | abc.klm@ 		|  abcklm      		| 
