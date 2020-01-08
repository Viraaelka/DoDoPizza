#language: en
  Feature: Add a few items to cart
    Background:
      When we go to DodoPage and turn off cookies

      @addtocart
      Scenario: Add a few items to cart being on the main page
        Then clicking Add To Cart to choose "Supreme" pizza
        And clicking Add To Cart to choose "Chicken Salad" item
        And clicking Add To Cart to choose "Mountain Dew" beverage
