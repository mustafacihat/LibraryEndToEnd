
@ELW-65
Feature: As a Student I can Barrow Books

  Background:
    Given the user is on the Library app login page
    Given  the user enter valid student credential "student11@library" "tScBPCUr"
    When  the user navigate to Books module

@smoke @bb
  Scenario: Student User Should be able To Barrow Book

    And the user click the Barrow Book button
    Then The Book has been barrowed is verifed

  @bb
  Scenario: Book cannot be borrowed twice at the same time

    Then check the borrowed book can not borrow again
  @bb
  Scenario:  Student should be able to return books.


    And the user navigate to Barrowing Books module
    Then verify that the user can return the borrowed book

  @bb @ELW-65
  Scenario:  Student should have a history of borrowed books


    And the user click the Barrow Book button
    And the user navigate to Barrowing Books module
    Then Verify the user can see borrowed books list


