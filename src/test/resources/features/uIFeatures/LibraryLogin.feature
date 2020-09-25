@login @ELW-21

Feature: Users should be able to login
  @ELW-50
  Scenario Outline: Login as a Student with valid credentials <email> <password>
    Given the user is on the Library app login page
    When the user logs in using "<email>" and "<password>"
    Then the user should be able to login on Library app bookpage
    Examples:
      | email             | password |
      | student28@library | 19Ceq2sT |
      | student30@library | IaT9YI0I |
      | student11@library | tScBPCUr |
      | student12@library | UC0LC9Hj |
      | student25@library | kV4feS7y |
  @ELW-51
  Scenario Outline: Login as a Librarian with valid credentials <email> <password>
    Given the user is on the Library app login page
    When the user logs in using "<email>" and "<password>"
    Then the user should be able to login on Library app dashbord
    Examples:
      | email               | password |
      | librarian18@library | rKG2sP88 |
      | librarian43@library | np6AxVIh |
      | librarian44@library | 4Lzovksn |
      | librarian60@library | OoNKtPqP |
      | librarian61@library | mabeKv1k |
  @ELW-52
  Scenario Outline: Not login with invalid credentials <email> <password>
    Given the user is on the Library app login page
    When the user logs in using "<email>" and "<password>"
    Then the user should not be able to login on Library app
    Examples:
      | email               | password |
      | librarian18@library | 123456   |
      | test123@library     | np6AxVIh |
      | librarian44@library |          |
      |                     | OoNKtPqP |
      | test1@hotmail.com   | aa12bb34 |
      | student11@library   | 12345    |
      | testtest@yahoo.com  | UC0LC9Hj |
      | student25@library   |          |


  Scenario: Student login with valid credential
    Given the user is on the Library app login page
    When the user logs in using "student30@library" and "IaT9YI0I"


  Scenario: Librarian login with valid credential
    Given the user is on the Library app login page
    When the user logs in using "librarian18@library" and "rKG2sP88"


