@editbook-api

Feature: Edit book on api

  Scenario: User can edit book on api with patch request
  Given the user as a librarian makes patch request with using update_book end point
  Then user should be able to get "The book has been updated." in response body
