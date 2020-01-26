#language: en

Feature: Check what would be if I move to My Order button

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    When we go to DodoPage and turn off cookies

  @myorder
  Scenario: Check what would be if I move to My Order button
    And checking what is going on when the mouse is navigated to the MyOrder button

  @live
  Scenario: Check the Live button
    And checking if the Camera container appears when the Live button is clicked
