package com.cybertekschool.library.api;

import com.cybertekschool.library.utils.api.AuthenticationUtility;
import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import com.cybertekschool.library.utils.common.Environment;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static com.cybertekschool.library.utils.api.Endpoints.ADD_BOOK;
import static io.restassured.RestAssured.given;

public class BooksAPI {

    public Response addBook(Map<String, String> book) {
        // get a token
        AuthenticationUtility authenticationUtility = new LibrarianAuthenticationUtility();
        String librarianToken = authenticationUtility.getToken();
        Response response = given().
                header("x-library-token", librarianToken).
                formParams(book).
                log().all().
                when().
                post(Environment.getProperty("libraryurl")+ADD_BOOK).
                prettyPeek();
        response.then().statusCode(200);
        return response;
    }

     public Response editBook(Map<String, Object> updateBook){
         Gson gson = new Gson();
         String json = gson.toJson(updateBook);

         AuthenticationUtility authenticationUtility = new LibrarianAuthenticationUtility();

         String token = authenticationUtility.getToken();

         Response response = RestAssured.given().accept(ContentType.JSON)
                 .and().contentType("application/json")
                 .header("x-library-token", token)
                 .and().body(json)
                 .when().patch(Environment.getProperty("libraryurl") + Endpoints.UPDATE_BOOK);

         return response;
     }
}
