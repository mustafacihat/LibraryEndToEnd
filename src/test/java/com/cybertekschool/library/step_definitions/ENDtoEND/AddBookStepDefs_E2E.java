package com.cybertekschool.library.step_definitions.ENDtoEND;

import com.cybertekschool.library.api.BooksAPI;
import com.cybertekschool.library.pages.BooksPage;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.util.Map;

public class AddBookStepDefs_E2E {

    String name;

    @Given("the user as a librarian makes post request with using add_book end point with random values")
    public void the_user_as_a_librarian_makes_post_request_with_using_add_book_end_point_with_random_values() {
        Map<String,String> book = new LibraryUserUtility().createBook();

        System.out.println(book.toString());

        Response response = new BooksAPI().addBook(book);
        name = book.get("name");
        System.out.println("name = " + name);


    }

    @Test
    public void test(){
        Map<String,String> book = new LibraryUserUtility().createBook();

        System.out.println(book.toString());

        Response response = new BooksAPI().addBook(book);
        name = response.path("name");
        System.out.println("name = " + name);
    }


    @Given("the user search corresponding book name")
    public void the_user_search_corresponding_book_name() throws InterruptedException {
        new BooksPage().searchBox.sendKeys(name+ Keys.ENTER);
        Thread.sleep(3000);

    }


    @Then("the user should see the book created in the API on the list")
    public void the_user_should_see_the_book_created_in_the_api_on_the_list() {
        Assert.assertEquals(new BooksPage().correspondedBook.getText(), name);

    }

}
