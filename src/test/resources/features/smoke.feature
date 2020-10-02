@ELW-132
Feature: 

	#Adding book using API end point as a librarian. (Positive Scenario)
	@ELW-114 @ELW-131
	Scenario: Verify that as a librarian, user can add book using end point
		Scenario: Add book as a librarian on api
		    Given the user as a librarian makes post request with using add_book end point
		
		      | name             | KILIC YARASI GIBI                   |
		      | isbn             | tkl-12355897                        |
		      | year             | 1999                                |
		      | author           | Ahmet ALTAN                         |
		      | book_category_id | 2                                   |
		      | description      | SAVAS ASK IHTILAL ENTRIKA ESMERALDA |
		
		
		
		    Then  user should be able to get "The book has been created." in response body for add book	

	#As a  user I should be able to add book
	@ELW-115 @ELW-131 @ELW-129 @ELW-111
	Scenario: Add book as a librarian on api
		Given the user as a librarian makes post request with using add_book end point
		
		      | name             | KILIC YARASI GIBI                   |
		      | isbn             | tkl-12355896                        |
		      | year             | 1999                                |
		      | author           | Ahmet ALTAN                         |
		      | book_category_id | 2                                   |
		      | description      | SAVAS ASK IHTILAL ENTRIKA ESMERALDA |
		    
		Then  user should be able to get "The book has been created." in response body for add book
			

	#As a user i should get dashboard datas
	@ELW-116 @ELW-131 @ELW-129 @ELW-111
	Scenario: dashboard stats on api
		When Send get request
		Then Get dashboard stats	

	#User can edit book on api with patch request
	@ELW-117 @ELW-131 @ELW-129 @ELW-111
	Scenario: User can edit book on api with patch request
		Given the user as a librarian makes patch request with using update_book end point
		Then user should be able to get "The book has been updated." in response body	

	#Edit book as a student on api negative test
	@ELW-118 @ELW-131 @ELW-129 @ELW-111
	Scenario: Edit book as a student on api negative test
		Given the user as a student makes patch request with using update_book end point
		Then status code should be 403 for student	

	#Borrow book as a student on api
	@ELW-119 @ELW-131 @ELW-129 @ELW-111
	Scenario: Borrow book as a student on api
		Given the user as a student makes post request with using book_borrow end point user_id 170
		
		Then  user should be able to get "The book has been borrowed..." in response body for borrow book	

	#As a user i should check dashboard datas
	@ELW-120 @ELW-131 @ELW-129 @ELW-111
	Scenario: Checking dashboard datas
		Given the user is on the Library app login page
		When the user logs in as librarian
		Then the informations getting from API and UI should be matched	

	#As a librarian I should create a user
	@ELW-121 @ELW-131 @ELW-129 @ELW-111
	Scenario Outline: user can create user on api <userType>
		Given create new user with "<userType>"
		Then user should be able to get "The user has been created." in response body for add user
		    Examples:
		      | userType  |
		      | librarian |
		      | student   |	

	#Borrow book on api , check from UI
	@ELW-122 @ELW-131 @ELW-129 @ELW-111
	Scenario: Borrow book as a student on api E2E
		Given send request to get dashboardStats before borrowing book on api
		And the user is on the Library app login page
		And the user logs in as student
		And the user click the avaliable borrow book button
		Given send request to get dashboardStats after borrowing book on api
		Then check the dasboard stats	

	#As a librarian I should be able to add book on API
	@ELW-123 @ELW-131 @ELW-129 @ELW-111
	Scenario: Add book on api , check from UI
		Given the user as a librarian makes post request with using add_book end point with random values
		And the user is on the Library app login page
		And the user logs in as librarian
		And the user navigates to "Books" page
		And the user search corresponding book name
		Then the user should see the book created in the API on the list	

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