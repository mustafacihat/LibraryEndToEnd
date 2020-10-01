@editbook-e2e
Feature: Edit book on api , check from UI

  Scenario: Add book as a librarian on api
    Given the user as a librarian makes patch request with using update_book end point for ui
    And the user is on the Library app login page
    And the user logs in as librarian
    And the user navigates to "Books" page
    And the user search corresponding book name for edit
    Then the user should see the book edited in the API on the list