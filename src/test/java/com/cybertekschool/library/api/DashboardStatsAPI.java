package com.cybertekschool.library.api;

import com.cybertekschool.library.utils.api.AuthenticationUtility;
import com.cybertekschool.library.utils.api.Endpoints;
import com.cybertekschool.library.utils.api.LibrarianAuthenticationUtility;
import com.cybertekschool.library.utils.api.StudentAuthenticationUtility;
import com.cybertekschool.library.utils.common.Environment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DashboardStatsAPI {


    public Response getDashboardResponse(){


        return RestAssured.given().accept(ContentType.JSON)
                .header("x-library-token",new LibrarianAuthenticationUtility().getToken())
                .when().get(Environment.getProperty("libraryurl") + Endpoints.DASHBOARD_STATS);

    }

    public String getStats(String stat){
        return getDashboardResponse().path(stat);
    }



}
