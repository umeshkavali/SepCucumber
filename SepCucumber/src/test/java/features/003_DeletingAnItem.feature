Feature: Deleting the item from Cart

  Scenario: Successful deletion of an item from Cart
    Given User launch Chrome Browser
    When User navigates to the URL "https://www.amazon.in/"
    Then User should mouseHover to Hello SignIn link
    When User enters Email ID as "umeshk@outlook.in"
    Then User should click on Continue button
    And User enters Password as "Umesh@062"
    And User should click on the checkbox
    And User should click on Signin button
    Then User should click on Cart button
    And User should verify the "Shopping Cart" header
    Then User should click on delete button
    And User should verify the "Your Amazon Cart is empty." header
    Then User should click on Logout link
    Then User should verify the page title as "Amazon Sign In"
    Then User should close the browser finally
