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
  Scenario Outline: User cannot login when input invalid account
    Given user is on the home page
    And user navigates to the login page
    When user enters email "<email>" and password "<password>"
    And user clicks on the login button
    Then The message "<message>" is displayed
    Examples:
      | email           | password    | message                              |
      |                 |             | A login and a password are required. |
      | abcdg@gmail.com |             | This is a required field.            |
      |                 | acfvd@se556 | This is a required field.            |






