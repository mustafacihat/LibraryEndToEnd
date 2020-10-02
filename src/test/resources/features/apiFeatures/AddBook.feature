@addbook-api

Feature: Add book on api

  Scenario: Add book as a librarian on api
    Given the user as a librarian makes post request with using add_book end point

      | name             | KILIC YARASI GIBI                   |
      | isbn             | tkl-12355896                        |
      | year             | 1999                                |
      | author           | Ahmet ALTAN                         |
      | book_category_id | 2                                   |
      | description      | SAVAS ASK IHTILAL ENTRIKA ESMERALDA |



    Then  user should be able to get "The book has been created." in response body for add book


    Scenario: Add book as a student on api negative test
      Given the user as a student makes post request with using add_book end point
      Then status code should be 403

