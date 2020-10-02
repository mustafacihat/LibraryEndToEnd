@borrowbook-e2e

Feature: Borrow book on api , check from UI

  Scenario: Borrow book as a student on api

    Given send request to get dashboardStats before borrowing book on api
    And the user is on the Library app login page
    And the user logs in as student
    And the user click the avaliable borrow book button
    Given send request to get dashboardStats after borrowing book on api
    Then check the dasboard stats

