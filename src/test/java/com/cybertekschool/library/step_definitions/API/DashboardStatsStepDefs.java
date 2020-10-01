package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.DashboardStatsAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;


import java.util.*;

public class DashboardStatsStepDefs {

    Response dashboardResponse;


    @When("Send get request")
    public void send_get_request() {
        dashboardResponse = new DashboardStatsAPI().getDashboardResponse();
        dashboardResponse.prettyPrint();
    }

    @Then("Get dashboard stats")
    public void get_dashboard_stats() {

        List<String> titleList = new ArrayList<>(Arrays.asList("book_count", "borrowed_books", "users"));
        Map<String, Object> titlesMap = dashboardResponse.body().as(Map.class);
        Set<String> titles = titlesMap.keySet();


        for (int i = 0; i < titles.size(); i++) {
            Assert.assertTrue(titles.contains(titleList.get(i)));
        }
    }

}
