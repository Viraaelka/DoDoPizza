#language: en

  Feature: Applying a promocode for giveaway pizza

    @sale
    Scenario: Applying a promocode

      When we go to DodoPage and turn off cookies
      And checking titles on the navigation menu
