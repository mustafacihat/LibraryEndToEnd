@ELW-94
Feature: REGRESSION SUIT

	#User Story: As a Student I can Barrow Books
	#Scenario: Book cannot be borrowed twice at the same time
	@ELW-83 @ELW-92 @ELW-99 @ELW-44 @ELW-93
	Scenario: Book cannot be borrowed twice at the same time
		Given the user is on the Library app login page
		Given  the user enter valid student credential "student24@library" "ya2nTtvY"
		When  the user navigate to Books module
		Then check the borrowed book can not borrow again	

	#User Story: As a Student I can Barrow Books
	#Scenario: Student User Should be able To Barrow Book
	@ELW-82 @ELW-92 @ELW-99 @ELW-44 @ELW-93
	Scenario: Student User Should be able To Barrow Book
		Given the user is on the Library app login page
		Given  the user enter valid student credential "student24@library" "ya2nTtvY"
		When  the user navigate to Books module
		And the user click the Barrow Book button
		Then The Book has been barrowed is verifed	

	#User Story: As a Student I can Barrow Books
	@ELW-84 @ELW-92 @ELW-99 @ELW-44 @ELW-93
	Scenario: Student should be able to return books.
		Given the user is on the Library app login page
		Given  the user enter valid student credential "student24@library" "ya2nTtvY"
		When  the user navigate to Books module
		And the user navigate to Barrowing Books module
		Then verify that the user can return the borrowed book	

	#User Story: As a Student I can Barrow Books
	@ELW-85 @ELW-92 @ELW-99 @ELW-44 @ELW-93
	Scenario: Student should have a history of borrowed books
		Given the user is on the Library app login page
		Given  the user enter valid student credential "student24@library" "ya2nTtvY"
		When  the user navigate to Books module
		And the user click the Barrow Book button
		And the user navigate to Barrowing Books module
		Then Verify the user can see borrowed books list   	

	#User story: As a librarian I should be able to edit books
	@ELW-87 @ELW-92 @ELW-100 @ELW-44 @ELW-93
	Scenario: Edit book as Student
		Given the user is on the Library app login page
		When the user logs in using "student11@library" and "tScBPCUr"
		And the user should be able to login on Library app bookpage
		Then user verifies the "Barrow Book" tab on the screen	

	#User Story: As a user Should be able to edit books
	@ELW-86 @ELW-92 @ELW-100 @ELW-44 @ELW-93
	Scenario:   Scenario: Edit book as Librarian
		Given the user is on the Library app login page
		When the user logs in using "librarian16@library" and "8BzUhhaU"
		Then the user should be able to login on Library app dashbord
		When the user navigates to "Books" page
		And the user selects the first book in the list
		And the user fills in the fields as Book Name: "Book Name",  ISBN:"12345678", Year: "1900"
		And the user clicks on Save Changes button
		Then the field should be updated to Book Name: "Book Name",  ISBN:"12345678", Year: "1900"	

	#Librarian can add book
	@ELW-81 @ELW-92 @ELW-101 @ELW-44 @ELW-93
	Scenario: Librarian can add book
		Given the user is on the Library app login page
		When the user logs in using "librarian18@library" and "rKG2sP88"
		Given the user is on Book Management Page
		When the user clicks on Add Book
		And the user should be able to see Add Book pop-up
		And the user must fill Book Name with "aaaaa Harry Potter-2" ,ISBN with "1000000000000", Year with "2000", Author with "J.K. Rowling",Description with "Added by Cucumber"
		And the user must select Book Category as "Fable"
		And the user must click Save Changes
		Then the book should be added "aaaaa Harry Potter-2"	

	#User Story: Users should be able to login
	@ELW-88 @ELW-92 @ELW-102 @ELW-44 @ELW-93
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

	#User Story: Users should be able to login
	@ELW-89 @ELW-92 @ELW-102 @ELW-44 @ELW-93
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

	#User Story: Users should be able to login
	@ELW-90 @ELW-92 @ELW-102 @ELW-44 @ELW-93
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

	#Users should be able to login
	@ELW-91 @ELW-92 @ELW-102 @ELW-44 @ELW-93
	Scenario: Student login with valid credential
		Given the user is on the Library app login page
		When the user logs in using "student30@library" and "IaT9YI0I"
		