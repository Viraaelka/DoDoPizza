#language: en

Feature: Check social pages and other footer links

  @social
  Scenario: Check social pages and other footer links
    When we go to DodoPage and turn off cookies
    And verifying that we get to "Instagram" page
    And verifying that we get to "Facebook" page
    And verifying that we get to "Terms and conditions" page