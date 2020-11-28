@ELW-139
Feature: 

	
	@ELW-135 @ELW-138 @ELW-140
	Scenario Outline: Edit book as Librarian
		Given get token  with "<username>" "<password>"
		Then response body return "Sorry, Wrong Email or Password" and status code will be 404
		
		Examples:
		| username          | password      |
		| student16@library | wrongpassword |
		| wrong@library     | 87x8afWY      |
		|                   | 87x8afWY      |
		| wrong@library     |               |	

	
	@ELW-136 @ELW-138 @ELW-140
	Scenario: dashboard stats on api
		When Send get request
		Then Get dashboard stats
			

	
	@ELW-137 @ELW-138 @ELW-140
	Scenario: Student should have a history of borrowed books
		Given the user is on the Library app login page
		Given  the user enter valid student credential "student11@library" "tScBPCUr"
		When  the user navigate to Books module
		And the user click the Barrow Book button
		And the user navigate to Barrowing Books module
		Then Verify the user can see borrowed books list