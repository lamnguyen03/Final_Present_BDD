#@ignore
Feature: Login

  @tc001
  Scenario Outline: User login success with valid data
    Given user is on the home page
    And user navigates to the login page
    When user enters email "<email>" and password "<password>"
    And user clicks on the login button
    Then display success message and navigate to the home page
    Examples:
      | email                           | password    |
      | lamlam112.nguyenthanh@gmail.com | Thanhlam26@ |

  @tc002
  Scenario Outline: User cannot login with invalid email
    Given user is on the home page
    And user navigates to the login page
    When user enters email "<email>" and password "<password>"
    And user clicks on the login button
    Then display capcha message and navigate to the home page
    Examples:
      | email                  | password    |
      | lam26lam03+2@gmail.com | thanhlam26@ |


  @tc003
  Scenario Outline: User cannot login when email and password are empty
    Given user is on the home page
    And user navigates to the login page
    When user enters email "<email>" and password "<password>"
    And user clicks on the login button
    Then display fail message and navigate to the home page
    Examples:
      | email | password |
      |       |          |






