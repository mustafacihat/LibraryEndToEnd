@borrowbook-e2e

Feature: Borrow book on api , check from UI

  Scenario: Borrow book as a student on api

    And the user is on the Library app login page
    And the user logs in as student
    And the user navigates to "Books" page
    And  the user click the Barrow Book button
