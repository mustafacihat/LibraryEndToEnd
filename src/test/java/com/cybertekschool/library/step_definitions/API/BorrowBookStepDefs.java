package com.cybertekschool.library.step_definitions.API;

import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import com.cybertekschool.library.utils.api.StudentAuthenticationUtility;
import com.cybertekschool.library.utils.common.Encoder;
import com.cybertekschool.library.utils.common.Environment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowBookStepDefs {


    @Test
    public void test(){

        String username = Environment.getProperty("student_email");
        String password = Environment.getProperty("student_password");

        Response response = given().
                formParam("email", "student22@library").
                formParam("password", "us2rddSF").
                log().all().
                when().
                post(Environment.getProperty("libraryurl")+Endpoints.LOGIN).prettyPeek();
        response.then().statusCode(200);

        String token = response.path("token");


        Response post = RestAssured.given().accept(ContentType.JSON)
                .and().contentType("application/x-www-form-urlencoded").header("x-library-token", token)
                .and().formParam("user_id", 170)
                .and().formParam("book_id", 450)
                .when().post(Environment.getProperty("libraryurl") + "/book_borrow");

        post.prettyPrint();
    }
}
