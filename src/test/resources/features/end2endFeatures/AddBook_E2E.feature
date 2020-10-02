@addbook-E2E

Feature: Add book on api , check from UI

  Scenario: Add book as a librarian on api
      Given the user as a librarian makes post request with using add_book end point with random values
      And the user is on the Library app login page
      And the user logs in as librarian
      And the user navigates to "Books" page
      And the user search corresponding book name
      Then the user should see the book created in the API on the list

    