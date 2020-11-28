package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.BooksAPI;
import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import com.cybertekschool.library.utils.common.Environment;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class AddBookStepDefs {
    Response pageAddResponse;
    Response studentResponse;

    @Given("the user as a librarian makes post request with using add_book end point")
    public void the_user_as_a_librarian_makes_post_request_with_using_add_book_end_point(Map<String, String> addBook) {
//        Gson gson = new Gson();
//        String json = gson.toJson(addBook);
//
//        String token = new LibrarianAuthenticationUtility().getToken();
//
//        pageAddResponse = RestAssured.given().accept(ContentType.JSON)
//                .and().contentType("application/json")
//                .header("x-library-token", token)
//                .and().body(json)
//                .when().post(Environment.getProperty("libraryurl") + Endpoints.ADD_BOOK);

        BooksAPI booksAPI = new BooksAPI();

        pageAddResponse = booksAPI.addBook(addBook);


    }

    @Then("user should be able to get {string} in response body for add book")
    public void user_should_be_able_to_get_in_response_body_for_add_book(String message) {
        Assert.assertEquals(message, pageAddResponse.path("message"));
    }


    @Given("the user as a student makes post request with using add_book end point")
    public void the_user_as_a_student_makes_post_request_with_using_add_book_end_point() {
        Map<String, String> book = LibraryUserUtility.createBook();

        BooksAPI booksAPI = new BooksAPI();

         studentResponse = booksAPI.addBookAsStudent(book);



    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {

        Assert.assertEquals((int)statusCode, studentResponse.statusCode() );
    }

}
