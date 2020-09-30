package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.BooksAPI;
import com.cybertekschool.library.api.BorrowingBooksAPI;
import com.cybertekschool.library.utils.api.AuthenticationUtility;
import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import com.cybertekschool.library.utils.api.StudentAuthenticationUtility;
import com.cybertekschool.library.utils.common.Encoder;
import com.cybertekschool.library.utils.common.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowBookStepDefs {
Response response;
    @Given("the user as a student makes post request with using book_borrow end point user_id {int}")
    public void the_user_as_a_student_makes_post_request_with_using_book_borrow_end_point_user_id(Integer user_id) {
        BorrowingBooksAPI borrowingBooksAPI = new BorrowingBooksAPI();

        int barrowableBook = borrowingBooksAPI.getBarrowableBook();

        response = borrowingBooksAPI.borrowBook(user_id, barrowableBook);


    }




    @Then("user should be able to get {string} in response body for borrow book")
    public void user_should_be_able_to_get_in_response_body_for_borrow_book(String message) {
        Assert.assertEquals(message, response.path("message"));
    }



}
