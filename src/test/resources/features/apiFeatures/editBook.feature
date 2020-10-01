@editbook-api
Feature: Edit book on api

  Scenario: Edit book as a librarian on api
    Given the user as a librarian makes patch request with using update_book end point
      | id               | 155                        |
      | name             | 1984                        |
      | isbn             | tkl-123546                  |
      | year             | 1948                        |
      | author           | George Orwell               |
      | book_category_id | 3                           |
      | description      | big brother is watching you |



    Then  user should be able to get "The book has been updated." in response body


