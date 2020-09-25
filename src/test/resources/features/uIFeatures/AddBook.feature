Feature: Librarian can add book
  @addBook
  Scenario: User should be able to add book
    Given the user is on the Library app login page
    When the user logs in using "librarian18@library" and "rKG2sP88"
    Given the user is on Book Management Page
    When the user clicks on Add Book
    And the user should be able to see Add Book pop-up
    And the user must fill Book Name with "aaaaa Harry Potter-2" ,ISBN with "1000000000000", Year with "2000", Author with "J.K. Rowling",Description with "Added by Cucumber"
    And the user must select Book Category as "Fable"
    And the user must click Save Changes
    Then the book should be added "aaaaa Harry Potter-2"
