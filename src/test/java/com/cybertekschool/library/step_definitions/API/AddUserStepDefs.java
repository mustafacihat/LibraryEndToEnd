package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.api.UserAPI;
import com.cybertekschool.library.utils.common.LibraryUserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class AddUserStepDefs {
Response response;
    @Given("create new user with {string}")
    public void create_new_user_with(String userType) {
        UserAPI userAPI = new UserAPI();

         response = userAPI.createUser(LibraryUserUtility.createUser(2), userType);


    }

    @Then("user should be able to get {string} in response body for add user")
    public void userShouldBeAbleToGetInResponseBodyForAddUser(String message) {

        Assert.assertEquals(message,response.path("message"));
    }
}
