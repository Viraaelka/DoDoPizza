#language: en

Feature: Check what would be if I move to My Order button

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    When we go to DodoPage and turn off cookies

  @makeOrder
  Scenario: Making an order
    And choosing "Pepperoni" pizza
    And checking the size and the kind of pastry
      | Size           | 10                |
      | Kind of pastry | Traditional crust |
    And changing the size of the pizaa to "14"
    And changing the size of the pizaa to "Thin"
    And checking the size and the kind of pastry
      | Size           | 14         |
      | Kind of pastry | Thin crust |
    And changing the size of the pizaa to "12"
    And checking the size and the kind of pastry
      | Size           | 12                |
      | Kind of pastry | Traditional crust |
    And adding the pizza to cart
    Then the amount of pizza added equals "1"
    And choosing "Supreme" pizza
    And checking the size and the kind of pastry
      | Size           | 10                |
      | Kind of pastry | Traditional crust |
    And adding the pizza to cart
    Then the amount of pizza added equals "2"