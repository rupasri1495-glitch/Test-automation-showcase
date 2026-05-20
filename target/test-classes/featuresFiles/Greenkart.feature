Feature: Top deals matches with applicable items in home page

  Scenario: A product from home is there in top deals page
    Given the GreenKart application
    When the item "Tomato" is Searched in searchbar
    And the item is list in the result
    Then navigate to Top Deals screen
    When the item "Tomato" is Searched in searchbar in deals page
    Then the item is list in the result of deals page
    And item is displayed in both screen
    And close the browser
