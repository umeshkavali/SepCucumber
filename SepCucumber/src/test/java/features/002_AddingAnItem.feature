Feature: Searching the Item from Web

  Scenario: Searching the item  and adding it to the Cart from a Web
    Given User launch Chrome Browser
    When User navigates to the URL "https://www.amazon.in/"
    Then User should mouseHover to Hello SignIn link
    When User enters Email ID as "umeshk@outlook.in"
    Then User should click on Continue button
    And User enters Password as "Umesh@062"
    And User should click on the checkbox
    And User should click on Signin button
    And User should select "All Categories" from the dropdown
    Then User should enter "Pixel 7a 5G (Sea, 8GB RAM, 128GB Storage)"
    And User should click on Search button
    Then User should select the "Pixel 7a 5G (Sea, 8GB RAM, 128GB Storage)" from the search page
    Then User should verify the Text as "Added to Cart"
    Then User should click on Logout link
    Then User should verify the page title as "Amazon Sign In"
    Then User should close the browser finally
