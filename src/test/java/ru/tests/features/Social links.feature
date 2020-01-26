#language: en

Feature: Check social pages and other footer links

  Background:
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    When we go to DodoPage and turn off cookies

  @social
  Scenario: Check social pages and other footer links
    When we go to DodoPage and turn off cookies
    And verifying that we get to "Instagram" page
    And verifying that we get to "Facebook" page
    And verifying that we get to "Terms and conditions" page