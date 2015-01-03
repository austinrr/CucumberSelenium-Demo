Feature: User Creation

  @Runme
  Scenario: Create Valid User
    Given I am on the NewUser page
    When I submit a new user:
      | name   | email             |
      | Austin | austin@rhodes.com |
    Then I am directed to the User list page
    And The user appears in the list
