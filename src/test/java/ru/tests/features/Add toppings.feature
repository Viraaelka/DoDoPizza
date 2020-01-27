#language: en
Feature: Toppings addition

#  Background:
#    Given that we are choosing the city to be tested further - "Oxford"
#    And checking that the city "Oxford" has been chosen
#    When we go to DodoPage and turn off cooki

  @addtoppings
  Scenario: Adding toppings to pizza
    And choosing "Pepperoni" pizza
    And checking the size and the kind of pastry
      | Size           | 10                |
      | Kind of pastry | Traditional crust |
