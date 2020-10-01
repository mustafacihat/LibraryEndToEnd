package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.BooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;

public class EditBookStepDefs {

    Response pageEditResponse;

    @Given("the user as a librarian makes patch request with using update_book end point")
    public void the_user_as_a_librarian_makes_patch_request_with_using_update_book_end_point(Map<String, Object> updateBook) {
        pageEditResponse = new BooksAPI().editBook(updateBook);

    }


    @Then("user should be able to get {string} in response body")
    public void user_should_be_able_to_get_in_response_body(String message) {

        Assert.assertEquals(message, pageEditResponse.path("message"));
    }
}
