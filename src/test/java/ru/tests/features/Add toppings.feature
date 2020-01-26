#language: en
Feature:

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    When we go to DodoPage and turn off cookies

  @addtoppings
  Scenario: