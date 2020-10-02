@login-api
Feature: Login in api

  Scenario Outline:user can login api with valid credentials in api <username> <password>
    Given get token  with "<username>" "<password>"
    Then status code should be 200 for login

    Examples:
      | username            | password |
      | student16@library   | VNKw282v |
      | librarian14@library | 87x8afWY |


  Scenario Outline: User can not get token with invalid credentials on api <username> <password>
    Given get token  with "<username>" "<password>"
    Then response body return "Sorry, Wrong Email or Password" and status code will be 404

    Examples:
      | username          | password      |
      | student16@library | wrongpassword |
      | wrong@library     | 87x8afWY      |
      |                   | 87x8afWY      |
      | wrong@library     |               |
