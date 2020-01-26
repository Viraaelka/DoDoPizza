#language: en
Feature: Add a few items to cart

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    When we go to DodoPage and turn off cookies

  @addtocart
  Scenario: Add a few items to cart being on the main page
    Then clicking 'Add To Cart' to choose "Garden Fresh salad" item at the price "5.99"
    And checking if the necessary product has been 'Added'
    Then clicking 'Add To Cart' to choose "New York Cheesecake" item at the price "3.25"
    And checking if the necessary product has been 'Added'
    Then clicking 'Add To Cart' to choose "Dr. Pepper can" item at the price "1.29"
    And checking if the necessary product has been 'Added'
    Then clicking 'Add To Cart' to choose "Mountain Dew" beverage at the price "2.49"
    And checking if the necessary product has been 'Added'