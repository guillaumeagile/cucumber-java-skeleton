Feature: Belly

  Scenario: a few cukes
    Given I have 10 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
   # And I take a coffee

  Scenario: less cakes
    Given I have 1 cukes in my belly
    When I wait 1 hour
    Then my belly should not growl


  Scenario: less cakes
    Given I have 10 cukes in my belly
    When I wait 2 hour
    Then my belly should not growl

  Scenario: some cakes and some times
    Given I have 20 cukes in my belly
    When I wait 2 hour
    Then my belly should growl

  Scenario: some cakes and some times
    Given I have 20 cukes in my belly
    When I wait 3 hour
    Then my belly should not growl