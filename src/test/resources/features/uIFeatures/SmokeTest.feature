@ELW-80
Feature: Smoke test


   @ELW-62 @ELW-79 @ELW-45 @ELW-18
  Scenario: User should be able to add book
    Given the user is on the Library app login page
    When the user logs in using "librarian18@library" and "rKG2sP88"
    Given the user is on Book Management Page
    When the user clicks on Add Book
    Then the user should be able to see Add Book pop-up

	#Edit book as a Librarian
  @ELW-55 @ELW-79 @ELW-45 @ELW-44
  Scenario: Edit book as Librarian
    Given the user is on the Library app login page
    When the user logs in using "librarian16@library" and "8BzUhhaU"
    Then the user should be able to login on Library app dashbord
    When the user navigates to "Books" page
    And the user selects the first book in the list
    And the user fills in the fields as Book Name: "Book Name",  ISBN:"12345678", Year: "1900"
    And the user clicks on Save Changes button
    Then the field should be updated to Book Name: "Book Name",  ISBN:"12345678", Year: "1900"