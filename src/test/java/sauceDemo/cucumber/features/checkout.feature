Feature: Checkout Sauce Demo Product
  @TDD
  Scenario Outline: User success checkout product
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    And click addtocart button
    When click shopping cart icon
    Then click checkout button
    Then user input <firstname> as firstname
    And user input <lastname> as lastname
    And user input <postalcode> as postalcode
    Then user click continue button
    Then user click finish button
    Then user successfully checkout

    Examples:
      | firstname | lastname  | postalcode  | username      | password      |
      | sheva     | naufal    | toto       | standard_user | secret_sauce  |