#language: en

Feature: Check social pages and other footer links

  Background:
    When we go to DodoPage and turn off cookies

  @socialGermantown @social
  Scenario: Check social pages and other footer links
    Given that we are choosing the city to be tested further - "Germantown"
    And checking that the city "Germantown" has been chosen
    And verifying that we get to "Instagram" page for "Germantown"
    And verifying that we get to "Facebook" page for "Germantown"
    And verifying that we get to "Terms and conditions" page for "Germantown"
    And verifying that we get to "Dodo Pizza Story" page for "Germantown"


  @socialOxford @social
  Scenario: Check social pages and other footer links
    Given that we are choosing the city to be tested further - "Oxford"
    And checking that the city "Oxford" has been chosen
    And verifying that we get to "Facebook" page for "Oxford"
    And verifying that we get to "Terms and conditions" page for "Oxford"
    And verifying that we get to "Dodo Pizza Story" page for "Oxford"