package com.cybertekschool.library.step_definitions.UI;

import com.cybertekschool.library.pages.BookManagementPage;
import com.cybertekschool.library.pages.LibraryLoginPage;
import com.cybertekschool.library.utils.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class BarrowBookStepDefs {

    BookManagementPage bookManagementPage;
    String bookinfo = null;



    @Given("the user enter valid student credential {string} {string}" )
    public void the_user_enter_valid_student_credential(String student_username, String student_password) throws InterruptedException {

        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.loginLibrary(student_username, student_password);

        Thread.sleep(3000);

    }


    @When("the user navigate to Books module" )
    public void the_user_navigate_to_Books_module() throws InterruptedException {


        BookManagementPage bookManagementPage = new BookManagementPage();
        //bookManagementPage.navigateToMenu("Books");
        bookManagementPage.recordSelector("500");
        Thread.sleep(2000);





    }

    @When("the user click the Barrow Book button" )
    public void the_user_click_the_Barrow_Book_button() throws InterruptedException {

        Thread.sleep(3000);
        BookManagementPage bookManagementPage = new BookManagementPage();
        bookinfo = bookManagementPage.bookrow.getText();
        System.out.println("bookManagementPage.bookrow.getText() = " + bookManagementPage.bookrow.getText());
        new BookManagementPage().borrowbookbutton.click();


    }

    @Then("The Book has been barrowed is verifed" )
    public void the_Book_has_been_barrowed_is_verifed() throws InterruptedException {

        Thread.sleep(4000);

        BookManagementPage bookManagementPage = new BookManagementPage();

        Assert.assertEquals( "Verify that pop up is visible Book is borrowed...",
                "The book has been borrowed...",bookManagementPage.thebookbarrowedverificiationtext.getText() );
    }



    @When("the user navigate to Barrowing Books module" )
    public void the_user_navigate_to_Barrowing_Books_module() {

        BookManagementPage bookManagementPage = new BookManagementPage();
        bookManagementPage.navigateToMenu("Borrowing Books");

    }

    @Then("barrowed book is visible under the list of Barrowed books" )
    public void barrowed_book_is_visible_under_the_list_of_Barrowed_books() {

        Assert.assertTrue("borrowed book is under the borrowed list", bookManagementPage.book.isEnabled());
    }

    @Then("check the borrowed book can not borrow again")
    public void check_the_borrowed_book_can_not_borrow_again() throws InterruptedException {
        BookManagementPage bookManagementPage = new BookManagementPage();

        Thread.sleep(4000);

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(bookManagementPage.unabletobarrow).click().perform();


        Thread.sleep(2000);


        try {
            Assert.assertFalse("verify borrowed book is not visible",
                    bookManagementPage.thebookbarrowedverificiationtext.isEnabled());
        }catch (Exception e){
            Assert.assertFalse("verify borrowed book is not visible",
                    false);
        }



    }

    @Then("verify that the user can return the borrowed book")
    public void verify_that_the_user_can_return_the_borrowed_book() throws InterruptedException {

        Thread.sleep(3000);
        BookManagementPage bookManagementPage = new BookManagementPage();
       bookManagementPage.returnBook.click();
        Assert.assertEquals("Return book verified", "The book has been returned..",
                bookManagementPage.returnBookVerificaiton.getText());

    }

    @Then("Verify the user can see borrowed books list")
    public void verify_the_user_can_see_borrowed_books_list() {




        BookManagementPage bookManagementPage = new BookManagementPage();
        List<WebElement> borrowedbookList = bookManagementPage.borrowedbookList;
        String lastborrowedBook = borrowedbookList.get(borrowedbookList.size()-1).getText();

        Assert.assertTrue("Verify thay borrowed book is in the List", bookinfo.contains(lastborrowedBook));


    }

}