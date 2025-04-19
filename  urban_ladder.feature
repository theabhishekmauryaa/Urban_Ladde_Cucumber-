Feature: Urban Ladder End-to-End Testing

  Scenario: User signs up successfully
    Given user is on Urban Ladder homepage
    When user opens the Sign Up form
    And enters valid email and password
    Then user clicks on the Sign Up button

  Scenario: User logs in successfully
    Given user is on Urban Ladder homepage
    When user opens the Log In form
    And enters correct login credentials
    Then user clicks on the Log In button

  Scenario: User adds a sofa to cart and proceeds to checkout
    Given user is on Urban Ladder homepage
    When user searches for "Sofa"
    And selects a product and adds to cart
    Then user proceeds to checkout and fills the shipping details
