Feature: Logout from Sauce Demo
  @TDD
  Scenario Outline: Logout from Sauce Demo
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    And click burger button
    And click logout button
    Then user successfully logout

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |