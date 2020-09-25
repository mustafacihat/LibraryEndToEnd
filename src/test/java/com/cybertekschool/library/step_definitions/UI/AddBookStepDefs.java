package com.cybertekschool.library.step_definitions.UI;

import com.cybertekschool.library.pages.AddBookPage;
import com.cybertekschool.library.utils.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import javax.swing.*;

public class AddBookStepDefs {
    String bookName = "";
    @Given("the user is on Book Management Page")
    public void the_user_is_on_Book_Management_Page() {
        // Write code here that turns the phrase above into concrete actions
        new AddBookPage().Books.click();
        Assert.assertEquals("http://library2.cybertekschool.com/#books", Driver.getDriver().getCurrentUrl());

    }
    @When("the user clicks on Add Book")
    public void the_user_clicks_on_Add_Book() {
        // Write code here that turns the phrase above into concrete actions
        new AddBookPage().AddBookButton.click();
        Assert.assertTrue(new AddBookPage().popUp.isDisplayed());

    }
    @Then("the user should be able to see Add Book pop-up")
    public void the_user_should_be_able_to_see_Add_Book_pop_up() {


    Assert.assertEquals(new AddBookPage().addBookText.getText(), "Add Book");

    }
    @When("the user must fill Book Name with {string} ,ISBN with {string}, Year with {string}, Author with {string},Description with {string}")
    public void the_user_must_fill_Book_Name_with_ISBN_with_Year_with_Author_with_Description_with(String name, String ISBN, String year, String author, String description) throws InterruptedException {

        Thread.sleep(2000);
        AddBookPage addBookPage = new AddBookPage();
        addBookPage.BookNameInputBox.sendKeys(name);
        addBookPage.ISBNinputBox.click();
        addBookPage.ISBNinputBox.sendKeys(ISBN);
        addBookPage.YearInputBox.sendKeys(year);
        addBookPage.AuthorInputBox.sendKeys(author);
        addBookPage.DescriptionInputBox.sendKeys(description);



        Thread.sleep(2000);


    }

    @When("the user must select Book Category as {string}")
    public void the_user_must_select_Book_Category_as(String bookCat) {

//        AddBookPage addBookPage = new AddBookPage();
//
//        WebElement bookCategoryDropdown = addBookPage.BookCategoryDropdown;


        Select selectObj = new Select(new AddBookPage().BookCategoryDropdown);

        selectObj.selectByVisibleText(bookCat);


    }




    @When("the user must click Save Changes")
    public void the_user_must_click_Save_Changes() {
        new AddBookPage().SaveChangesButton.click();

    }
    @Then("the book should be added {string}")
    public void the_book_should_be_added(String name) throws InterruptedException {
        Thread.sleep(1500);
        new AddBookPage().SearchBox.sendKeys(name);
        Thread.sleep(1500);

        Assert.assertEquals(new AddBookPage().expextedBook.getText(), name);





    }


}

