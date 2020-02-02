#language: en
Feature: Toppings addition

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
#    When we go to DodoPage and turn off cookies

  @addtoppings
  Scenario: Adding toppings to pizza in Germantown
    And choosing "Pepperoni" pizza
    And checking the size and the kind of pastry
      | Size           | 10                |
      | Kind of pastry | Traditional crust |
    And adding the topping "Extra Mozzarella "
    Then checking that the toppping " + Extra Mozzarella " has been added to cart
    And adding the topping "Extra Sauce"
    Then checking that the toppping " + Extra Sauce" has been added to cart
    And adding the topping "Italian sausage"
    Then checking that the toppping " + Italian sausage" has been added to cart
    And adding the pizza to cart

    And choosing "Chicken Club" pizza
    And adding the topping "Extra Mozzarella "
    Then checking that the toppping " + Extra Mozzarella " has been added to cart
    And adding the topping "Extra Sauce"
    Then checking that the toppping " + Extra Sauce" has been added to cart
    And adding the topping "Mushrooms"
    Then checking that the toppping " + Mushrooms" has been added to cart
    And adding the pizza to cart