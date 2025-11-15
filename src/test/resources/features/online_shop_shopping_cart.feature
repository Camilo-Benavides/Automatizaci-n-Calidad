Feature:Check how many products I have in the shopping car

  As User I need to use it

  Scenario: Search store website
    Given I am in the saucedemo page
    When I fill the login
    Then I can access to the site

  Scenario: Add elements
    Given I am in main menu
    When I select one product
    Then the element is added

  Scenario: Remove elements
    Given I already have elements in the shopping cart
    When I select remove
    Then the element is removed

  Scenario: I want to review my items
    Given I have finished choosing the products
    When I click on the shopping cart
    Then It shows how many products I have in my cart