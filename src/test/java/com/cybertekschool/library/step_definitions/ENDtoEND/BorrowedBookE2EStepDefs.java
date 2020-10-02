package com.cybertekschool.library.step_definitions.ENDtoEND;

import com.cybertekschool.library.api.DashboardStatsAPI;
import com.cybertekschool.library.pages.BookManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;


public class BorrowedBookE2EStepDefs {

    String bookName;
    int dashboard1;
    int dashboard2;

    /*@Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(Environment.getProperty("url"));
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.loginLibrary(Environment.getProperty("student_email"), Encoder.decrypt(Environment.getProperty("student_password")));

        BookManagementPage bookManagementPage = new BookManagementPage();
        Thread.sleep(3000);
        String s = bookManagementPage.borrowedVerification();
        System.out.println(s);
    }*/

    @Given("send request to get dashboardStats before borrowing book on api")
    public void send_request_to_get_dashboard_stats_before_borrowing_book_on_api() {
        Response dashboardResponse = new DashboardStatsAPI().getDashboardResponse();

        dashboard1 = Integer.parseInt(dashboardResponse.path("borrowed_books"));
        System.out.println(dashboard1);

    }


    @Given("send request to get dashboardStats after borrowing book on api")
    public void send_request_to_get_dashboard_stats_after_borrowing_book_on_api() {
        Response dashboardResponse = new DashboardStatsAPI().getDashboardResponse();
        dashboard2 = Integer.parseInt(dashboardResponse.path("borrowed_books"));
        System.out.println(dashboard2);
    }

    @Then("check the dasboard stats")
    public void check_the_dasboard_stats() {
        Assert.assertEquals(dashboard1,dashboard2-1);

    }


    @Given("the user click the avaliable borrow book button")
    public void the_user_click_the_avaliable_borrow_book_button() throws InterruptedException {
        BookManagementPage bookManagementPage = new BookManagementPage();
        Thread.sleep(1000);
        bookName = bookManagementPage.borrowedVerification();
        System.out.println(bookName);
    }


}
