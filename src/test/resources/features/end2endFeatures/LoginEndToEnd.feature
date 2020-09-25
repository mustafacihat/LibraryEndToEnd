@tt
Feature: End to end login test

  Scenario: Login as a student to UI
    Given the user is on the Library app login page
    When the user logs in as student


  Scenario: Login as a librarian to UI
    Given the user is on the Library app login page
    When the user logs in as librarian
