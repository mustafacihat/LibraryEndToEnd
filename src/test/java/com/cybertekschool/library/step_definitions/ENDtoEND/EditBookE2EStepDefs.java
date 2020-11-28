package com.cybertekschool.library.step_definitions.ENDtoEND;

import com.cybertekschool.library.api.BooksAPI;
import com.cybertekschool.library.pages.BooksPage;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class EditBookE2EStepDefs {

    Response pageEditResponse;
    String name;
    @Given("the user as a librarian makes patch request with using update_book end point for ui")
    public void the_user_as_a_librarian_makes_patch_request_with_using_update_book_end_point_for_ui() {
        Map<String, Object> editBookInfo = LibraryUserUtility.editableBookInfo();

        name = (String)editBookInfo.get("name");
        pageEditResponse = new BooksAPI().editBook(editBookInfo);

        pageEditResponse.prettyPrint();
        
    }

    @Given("the user search corresponding book name for edit")
    public void the_user_search_corresponding_book_name_for_edit() throws InterruptedException {
        new BooksPage().searchBox.sendKeys(name+ Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("the user should see the book edited in the API on the list")
    public void the_user_should_see_the_book_edited_in_the_api_on_the_list() {
        Assert.assertEquals(new BooksPage().correspondedBook.getText(), name);
    }


}
