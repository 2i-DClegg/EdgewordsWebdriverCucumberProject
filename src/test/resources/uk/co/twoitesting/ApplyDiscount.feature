Feature: E-Commerce Site
  Background:
    Given I have logged in with username "TBD" and password "TBD"
    And I have navigated to the shop page
    And I add a clothing item to the cart
    And I navigate to the cart

  Scenario: Add Item to cart and apply login
    Given I have an item in the cart
    When I apply the discount code "edgewords"
    Then The 15% discount should be applied to the product, and the price should be adjusted for shipping.

  Scenario: Complete an order and confirm it in order history
    Given I have gone to check out
    When I fill in my billing details/address And I place the order
    Then I should be taken to a completed order screen which has the order number
    When I navigate to my account and go to the orders section
    Then I can see this order with the same order number.

