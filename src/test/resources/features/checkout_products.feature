Feature: Proceed to checkout products on my shopping cart

    As a User I want to proceed to checkout products on my shopping cart so I can finish my purchase.
    
    Background: User have atleats 1 item in shopping cart
        Given I am in the saucedemo page
        When I fill the login
        And I already have elements in the shopping cart
        And I select the shopping cart
    
    Scenario: Proceed to checkout products sucessfully
        When I select the checkout module
        And I fill the personal information
        And I proceed to the checkout module
        Then I can see the overview of my order

    Scenario: Try to checkout without filling all personal information
        When I select the checkout module
        And I fill only the first name in the personal information
        And I proceed to the checkout module
        Then I should see an error message indicating missing information

    Scenario: Remove item from cart and try to checkout
        When I remove that item from the shopping cart
        And I select the checkout module
        And I fill the personal information
        And I proceed to the checkout module
        Then I should see a message indicating the cart is empty or cannot proceed