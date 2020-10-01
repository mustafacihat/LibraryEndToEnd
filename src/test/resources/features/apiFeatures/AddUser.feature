@createUser-api
Feature: add user on api

  Scenario Outline: user can create user on api <userType>
    Given create new user with "<userType>"
    Then user should be able to get "The user has been created." in response body for add user
    Examples:
      | userType  |
      | librarian |
      | student   |