@E-Shopping
Feature: Shopping in YourLogo website
  Scenario: user login with valid credentials
    Given user login with valid credentials
    When user click sign in tab
    And the user enter the email address and password
    And the user click Sign in
    Then the user lands on My Account page

   @SearchAProduct
  Scenario: Search for a product and add them to the cart
     Given user is in My Account page
     When user search for a product in search tab
     And hit enter
     Then the user will be able to see the search results
     When the user sort the products
     And the user click the Quick View tab on the selected product
     Then a pop up with product details will be displayed
     When the user select the size and click Add to Cart
     Then the product is added to the cart

   @ViewCartAndProccedToCheckout
  Scenario: View products in the cart page, make checkout, select the payment mode and place order
     Given user is in home page
     When the user click the cart tab
     And the user click Proceed to checkout
     And the user select the address and click proceed to checkout
     Then the user will be in shipping page
     When the user agree the terms and conditions and click on Proceed to checkout
     Then the user will be on payment page
     When the user select the payment option
     Then the user will be order confirmation page
     When the user click on I confirm the order
     Then the order is placed successfully


