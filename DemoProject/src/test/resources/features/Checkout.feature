@E-Shopping

Feature: E-shopping
  Scenario: Searching and placing order in website
    Given the user is in YourLogo website
    When user click Search tab and enter the product to be searched
    And click enter
    Then the user will be proceeded to the search results page
    When user sort the product
    And user select the product that is to be placed
    And user click Quick view icon on the product
    Then user will be redirected to the product details page
    When user select the size and quantity
    And user click Add to Cart icon
    Then the product will be successfully added to the cart
    When the user click proceed to checkout
    Then the user will be in cart page
    When the user click Proceed to checkout
    And the user will enter the email address and click create a account
    And the user will enter the personal details
    And user will enter the address and click register
    And the user will click proceed to checkout
    And user agree the terms and conditions and click proceed to checkout
    Then the user will be redirected to the payment page
    When the user select the payment option
    And the user will click I confirm my order
    Then the order is placed successfully

