Feature: Login to Sauce Demo
  @TDD
  Scenario Outline: User login to sauceDemo
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    Then user verify <status> login

    Examples:
      | username       | password      | status  |
      | standard_user  | secret_sauce  | success |
      | standard_user  | secret_sauces | failed  |

