@barrowbook-api
Feature: Barrow book on api

  Scenario: Borrow book as a student on api
    Given the user as a student makes post request with using book_borrow end point user_id 170

    Then  user should be able to get "The book has been borrowed..." in response body for borrow book