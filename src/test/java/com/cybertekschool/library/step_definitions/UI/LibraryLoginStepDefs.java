package com.cybertekschool.library.step_definitions.UI;


import com.cybertekschool.library.pages.LibraryLoginPage;
import com.cybertekschool.library.utils.common.Environment;
import com.cybertekschool.library.utils.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LibraryLoginStepDefs {


    @Given("the user is on the Library app login page")
    public void the_user_is_on_the_Library_app_login_page() {
        Driver.getDriver().get(Environment.getProperty("url"));
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String email, String password) throws InterruptedException {

        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.loginLibrary(email, password);

        Thread.sleep(3000);


    }

    @Then("the user should be able to login on Library app bookpage")
    public void the_user_should_be_able_to_login_on_Library_app_bookpage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals("http://library2.cybertekschool.com/#books", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user should be able to login on Library app dashbord")
    public void the_user_should_be_able_to_login_on_Library_app_dashbord() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals("http://library2.cybertekschool.com/#dashboard", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user should not be able to login on Library app")
    public void the_user_should_not_be_able_to_login_on_Library_app() {
        Assert.assertEquals("http://library2.cybertekschool.com/login.html", Driver.getDriver().getCurrentUrl());
    }



}
