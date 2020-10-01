@Dashboard-api
Feature: dashboard stats on api


  Scenario: User get dashboard stats
    When Send get request
    Then Get dashboard stats
