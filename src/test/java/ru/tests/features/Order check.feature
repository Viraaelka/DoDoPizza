#language: en

Feature: Check what would be if I move to My Order button

  Background: When we go to DodoPage and turn off cookies

  @myorder
  Scenario: Check what would be if I move to My Order button
    And checking what is going on when the mouse is navigated to the MyOrder button

  @live
  Scenario: Check the Live button
    When we go to DodoPage and turn off cookies
    And checking if the Camera container appears when the Live button is clicked