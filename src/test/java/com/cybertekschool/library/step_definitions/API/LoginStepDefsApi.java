package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.utils.api.AuthenticationUtility;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class LoginStepDefsApi {
Response responseForUsers;

    @Given("get token  with valid credentials")
    public void get_token_with_valid_credentials() {
        AuthenticationUtility authenticationUtility = new LibrarianAuthenticationUtility();

       responseForUsers = authenticationUtility.getLoginResponse();
    }



    @Given("get token with invalid credentials {string} {string}")
    public void get_token_with_invalid_credentials(String username, String password) {

         responseForUsers = new LibrarianAuthenticationUtility().getResponseForUsers(username, password);
    }





    @Then("response body return {string} and status code will be {int}")
    public void response_body_return_and_status_code_will_be(String body, Integer statusCode) {
        Assert.assertEquals(body,responseForUsers.path("error"));
        Assert.assertEquals((int) statusCode,responseForUsers.statusCode());
    }

    @Then("status code should be {int} for login")
    public void status_code_should_be_for_login(Integer statusCode) {
       Assert.assertEquals((int)statusCode, responseForUsers.statusCode());
    }

    @Given("get token  with {string} {string}")
    public void get_token_with(String username, String password) {
        responseForUsers = new LibrarianAuthenticationUtility().getResponseForUsers(username, password);
    }


}
