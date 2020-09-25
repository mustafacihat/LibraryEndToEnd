package com.cybertekschool.library.step_definitions.UI;

import com.cybertekschool.library.pages.BooksPage;
import com.cybertekschool.library.utils.ui.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class EditBooks {



    @When("the user selects the first book in the list")
    public void the_user_selects_the_first_book_in_the_list() throws InterruptedException {
        Thread.sleep(2000);
      //  Driver.get().findElement(By.xpath("/th[@data-name='isbn']")).click();
     //Driver.get().findElement(By.xpath("(//tbody//tr//td//a)[1]")).clear();
     Driver.getDriver().findElement(By.xpath("(//tbody//tr//td//a)[1]")).click();
    }

    @When("the user fills in the fields as Book Name: {string},  ISBN:{string}, Year: {string}")
    public void the_user_fills_in_the_fields_as_Book_Name_ISBN_Year(String name, String isnb, String year) {
        BooksPage books = new BooksPage();

        books.bookName.clear();
        books.bookName.sendKeys(name);
        books.Year.clear();
        books.Year.sendKeys(year);
//        books.ISBN.clear();
//        books.ISBN.sendKeys(isnb.toString());
    }


    @When("the user clicks on Save Changes button")
    public void the_user_clicks_on_Save_Changes_button() throws InterruptedException {
        Thread.sleep(2000);

        Driver.getDriver().findElement(By.xpath("//button[.='Save changes']")).click();
        Thread.sleep(5000);

    }




    @Then("the field should be updated to Book Name: {string},  ISBN:{string}, Year: {string}")
    public void the_field_should_be_updated_to_Book_Name_ISBN_Year(String name, String isnb, String year) {
        BooksPage booksPage = new BooksPage();
        Assert.assertEquals(booksPage.actualName.getText(), name);
        Assert.assertEquals(booksPage.actualyear.getText(), year);
      //  Assert.assertEquals(booksPage.actualIsnb.getText(),isnb);
    }

    @Then("user verifies the {string} tab on the screen")
    public void user_verifies_the_tab_on_the_screen(String string) {
        String text = new BooksPage().studentBooks.getText();
        Assert.assertNotEquals(text, "Edit Book");

    }

}
