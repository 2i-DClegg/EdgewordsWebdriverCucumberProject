Feature: E-Commerce Site

  Background:
    Given I have logged in with username "TBD" and password "TBD"
    Given I have an item in the cart

  Scenario: Add Item to cart and apply login

    When I apply the discount code "edgewords"
    Then The 15% discount should be applied to the product, and the price should be adjusted for shipping.

  Scenario: Complete an order and confirm it in order history
    When I place the order #with the following details
    #inline table
      | FirstName | LastName | HouseNumberStreetName  | Town   | Postcode | Phone       | Email                     |
      | John      | Smith    | Wimbledon Cricket Club | London | SW19 5AG | 01234567891 | TestingUser@TestEmail.com |
    Then I should be taken to a completed order screen which has the order number
    Then I can see this order in my account with the same order number.
