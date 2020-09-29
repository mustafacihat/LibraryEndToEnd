package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.common.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.*;

public class DashboardStatsStepDefs {
    String token;
    Response response;
    @Given("With the student credentials")
    public void with_the_student_credentials() {

        Response response = RestAssured.given().formParam("email", Environment.getProperty("student_email"))
                .formParam("password", Environment.getProperty("student_password"))
                .when().post(Environment.getProperty("libraryurl") + Endpoints.LOGIN);
        token = response.path("token");
    }

    @When("Send get request")
    public void send_get_request() {
        response = RestAssured.given().header("x-library-token",token).get(Environment.getProperty("libraryurl") + "/dashboard_stats");


    }

    @Then("Get dashboard stats")
    public void get_dashboard_stats() {

        List<String> titleList = new ArrayList<>(Arrays.asList("book_count","borrowed_books","users"));
        Map<String,Object> titlesMap = response.as(Map.class);
        Set<String> titles = titlesMap.keySet();


        for (int i = 0; i < titles.size(); i++) {
            Assert.assertTrue(titles.contains(titleList.get(i)));
        }

    }

    @Given("With the librarian credentials")
    public void with_the_librarian_credentials() {
        Response response = RestAssured.given().formParam("email", Environment.getProperty("librarian_email"))
                .formParam("password", Environment.getProperty("librarian_password"))
                .when().post(Environment.getProperty("libraryurl") + Endpoints.LOGIN);
        token = response.path("token");
    }

}
