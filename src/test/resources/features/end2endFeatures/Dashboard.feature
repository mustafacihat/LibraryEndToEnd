@dashboard
Feature: Dashboard Page

  Scenario: Checking dashboard datas
    Given the user logs in as librarian
    When the user is in dashboard page
    Then the informations getting from API and UI should be matched



