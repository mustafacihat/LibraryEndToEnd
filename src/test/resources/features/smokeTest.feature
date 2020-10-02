@ELW-133
Feature: Smoke test
    #As a user i should get dashboard datas
	@ELW-116 @ELW-131 @ELW-129 @ELW-111
	Scenario: dashboard stats on api
		When Send get request
		Then Get dashboard stats
    #As a user i should check dashboard datas
	@ELW-120 @ELW-131 @ELW-129 @ELW-111
	Scenario: Checking dashboard datas
		Given the user is on the Library app login page
		When the user logs in as librarian
		Then the informations getting from API and UI should be matched
    #user can login api with valid credentials in api
	@ELW-124 @ELW-131 @ELW-129 @ELW-111
	Scenario Outline: user can login api with valid credentials in api
		Given get token  with "<username>" "<password>"
		Then status code should be 200 for login
		Examples:
			| username            | password |
			| student16@library   | VNKw282v |
			| librarian14@library | 87x8afWY |
    #User can not get token with invalid credentials on api
	@ELW-125 @ELW-131 @ELW-129 @ELW-111
	Scenario Outline: User can not get token with invalid credentials on api
		Given get token  with "<username>" "<password>"
		Then response body return "Sorry, Wrong Email or Password" and status code will be 404
		Examples:
			| username          | password      |
			| student16@library | wrongpassword |
			| wrong@library     | 87x8afWY      |
			|                   | 87x8afWY      |
			| wrong@library     |               |
    #Edit book as a librarian on api for end to end testing
	@ELW-126 @ELW-131 @ELW-129 @ELW-111
	Scenario: Edit book as a librarian on api
		Given the user as a librarian makes patch request with using update_book end point for ui
		And the user is on the Library app login page
		And the user logs in as librarian
		And the user navigates to "Books" page
		And the user search corresponding book name for edit
		Then the user should see the book edited in the API on the list
    #Login as a student to UI for end to end testing
	@ELW-127 @ELW-131 @ELW-129 @ELW-111
	Scenario: Login as a student to UI
		Given the user is on the Library app login page
		When the user logs in as student
    #Login as a librarian to UI for end to end testing
	@ELW-128 @ELW-131 @ELW-129 @ELW-111
	Scenario: Login as a librarian to UI librarian
		Given the user is on the Library app login page
		When the user logs in as librarian