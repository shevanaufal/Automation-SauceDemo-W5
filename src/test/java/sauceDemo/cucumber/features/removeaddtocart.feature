Feature: Remove Add To Cart
  @TDD
  Scenario Outline: User success remove add to cart
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    And click addtocart button
    Then cart will increase
    And click remove button
    Then product will removed from cart

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |