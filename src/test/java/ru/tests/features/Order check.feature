#language: en

Feature: Check what would be if I move to My Order button

  @myorder
  Scenario: Check what would be if I move to My Order button
    When we go to DodoPage and turn off cookies
    And checking what is going on when the mouse is navigated to the MyOrder button