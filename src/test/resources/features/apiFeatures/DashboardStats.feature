@Dashboard
Feature: Get dashboard stats


  Scenario: User get dashboard stats
    Given With the student credentials
    When Send get request
    Then Get dashboard stats


  Scenario: User get dashboard stats
    Given With the librarian credentials
    When Send get request
    Then Get dashboard stats