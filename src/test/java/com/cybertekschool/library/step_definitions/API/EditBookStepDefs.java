package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.BooksAPI;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;

public class EditBookStepDefs {

    Response pageEditResponse;
    Response editStudentResponse;


    @Given("the user as a librarian makes patch request with using update_book end point")
    public void the_user_as_a_librarian_makes_patch_request_with_using_update_book_end_point() {
        Map<String, Object> editBookInfo = LibraryUserUtility.editableBookInfo();

        pageEditResponse = new BooksAPI().editBook(editBookInfo);

        pageEditResponse.prettyPrint();
    }


    @Then("user should be able to get {string} in response body")
    public void user_should_be_able_to_get_in_response_body(String message) {

        Assert.assertEquals(message, pageEditResponse.path("message"));
    }

    @Given("the user as a student makes patch request with using update_book end point")
    public void the_user_as_a_student_makes_patch_request_with_using_update_book_end_point() {
        BooksAPI booksAPI = new BooksAPI();

        Map<String, Object> editBook = LibraryUserUtility.editableBookInfo();

        editStudentResponse = booksAPI.editBookAsStudent(editBook);



    }



    @Then("status code should be {int} for student")
    public void status_code_should_be_for_student(Integer statusCode) {
        Assert.assertEquals((int) statusCode,editStudentResponse.statusCode());
    }

}
