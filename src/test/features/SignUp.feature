#@ignore
Feature: SignUp

  @tc001
  Scenario Outline: Register user with valid data
    Given user is on the home page
    And user navigate to the sign up page
    When user enters their <firstName>,<lastName>,<email>,<password>,<confirmPassword>
    And the user clicks on the Create Account button
    Then user should be redirected to the account dashboard page
    Examples:
      | firstName |  | lastName |  | email                     |  | password       |  | confirmPassword |
      | Coj       |  | Nguyen   |  | lam.nguyennn+22@gmail.com |  | Thanhlam11@123 |  | Thanhlam11@123  |