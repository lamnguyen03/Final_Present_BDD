Feature: Buy Item

  Scenario Outline: user buy item success
    Given user is on the home page
    And user navigates to the login page
    When user enters email "<email>" and password "<password>"
    And user clicks on the login button
    When user scroll-down to choose the item
    And user navigate to the detail page and select info item
    Then user navigate to the check out page to payment


    Examples:
      | email                           |  | password    |
      | lamlam112.nguyenthanh@gmail.com |  | Thanhlam26@ |