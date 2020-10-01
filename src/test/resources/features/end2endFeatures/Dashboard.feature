@dashboard-end2end
Feature: Dashboard Page

  Scenario: Checking dashboard datas
    Given the user is on the Library app login page
    When the user logs in as librarian
    Then the informations getting from API and UI should be matched

