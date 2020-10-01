@dashboard-end2end
Feature: Dashboard Page

  Scenario: Checking dashboard datas
    Given the user is on the Library app login page
    When the user logs in using "librarian18@library" and "rKG2sP88"
    Then the informations getting from API and UI should be matched



git push