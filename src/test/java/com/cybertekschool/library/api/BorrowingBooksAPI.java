package com.cybertekschool.library.api;

import com.cybertekschool.library.utils.api.AuthenticationUtility;
import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.StudentAuthenticationUtility;
import com.cybertekschool.library.utils.common.Environment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BorrowingBooksAPI {

    public Response borrowBook(int user_id, int book_id){
        AuthenticationUtility authenticationUtility = new StudentAuthenticationUtility();

        String token = authenticationUtility.getToken();

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType("application/x-www-form-urlencoded").header("x-library-token", token)
                .and().formParam("user_id", user_id)
                .and().formParam("book_id", book_id)
                .when().post(Environment.getProperty("libraryurl") + "/book_borrow");

        return response;

    }

     public int getBarrowableBook(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .header("x-library-token", new StudentAuthenticationUtility().getToken())
                .get(Environment.getProperty("libraryurl")+ Endpoints.AVAILABLE_BOOKS);
        response.prettyPrint();

         String i = response.path("id[0]");

         int id = Integer.parseInt(i);

         return id;

     }

}
