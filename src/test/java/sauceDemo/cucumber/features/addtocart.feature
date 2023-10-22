Feature: Add To Cart
  @TDD
  Scenario Outline: User success add to cart
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    And click addtocart button
    Then cart will increase

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |