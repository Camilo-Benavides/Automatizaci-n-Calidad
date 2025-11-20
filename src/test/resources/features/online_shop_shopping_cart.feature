Feature:Check how many products I have in the shopping car

  As User I want to view and manage my shopping cart so I can see how many products I have.

  Background: User is logged in the saucedemo page
    Given I am in the saucedemo page
    When I fill the login

  Scenario: Add elements
    When I select some products
    Then the elements are added

  Scenario: Remove elements
    Given I add some elements to the shopping cart
    When I remove one of them
    Then the element is removed

  Scenario: I want to review my items
    Given I already have elements in the shopping cart
    When I select the shopping cart
    Then It shows how many products I have in my cart