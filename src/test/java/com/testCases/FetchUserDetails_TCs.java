package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.*;

public class FetchUserDetails_TCs extends Utilities {

    String payload = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Saksham\",\n" +
            "    \"firstName\": \"Shubham\",\n" +
            "    \"lastName\": \"Pankaj\",\n" +
            "    \"email\": \"Piyush\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"999654\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";


    @Test(priority = 1, description = "Verify that a GET request for an existing user", enabled = true)
    public void verify_ValidUser() {
        AllureLogger.logToAllure("Verify that a GET request for an existing user");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 2, description = "Verify that a GET request for a non-existent user", enabled = true)
    public void verify_InvalidUser() {
        AllureLogger.logToAllure("Verify that a GET request for a non-existent user");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
              //  .body(payload).log().body()
                .pathParam("username", "Saksham")
                .when()
                .get("/user/{username}");
        response.then().statusCode(404);
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Verify that a GET request for an existing user returns JSON data", enabled = true)
    public void verify_ResponseIn_JSONFormat() {
        AllureLogger.logToAllure("Verify that a GET request for an existing user returns JSON data");

        Response response = given().baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");

        response.then().statusCode(200);
        response.then().contentType(ContentType.JSON);
        System.out.println(response.asString());
    }


    @Test(priority = 4, description = "Verify that the response contains the expected user data fields, such as username", enabled = true)
    public void verify_ResponseContent() {
        AllureLogger.logToAllure("Verify that the response contains the expected user data fields, such as username");

        Response response = given().baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");

        response.then().statusCode(200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        assertTrue(responseBody.contains("\"username\": \"Parveen\""));
        System.out.println(responseBody);
    }


    @Test(priority = 5, description = "Verify that the response headers include the appropriate content type.", enabled = true)
    public void verify_ResponseHeader() {
        AllureLogger.logToAllure("Verify that the response headers include the appropriate content type");
        Response response = given().baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");

        response.then().statusCode(200);
        String contentTypeHeader = response.getHeader("Content-Type");
        assertNotNull(contentTypeHeader);
        assertTrue(contentTypeHeader.contains("application/json"));
        System.out.println(response.getBody().asString());
    }

    @Test(priority = 6, description = "Verify that the response time falls within an acceptable range.", enabled = true)
    public void verify_ResponseTime() {
        AllureLogger.logToAllure("Verify that the response time falls within an acceptable range.");

        Response response = given().baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");

        response.then().statusCode(200);

        long responseTime = response.time();
        assertThat(responseTime, lessThan(2000L));
        System.out.println(response.getBody().asString());
    }


    @Test(priority = 7, description = "Check response status when the rate limit is exceeded.", enabled = true)
    public void verify_RateLimiting() {

                           for (int i = 0; i < 5; i++) {
                Response response = given().baseUri("https://petstore.swagger.io/v2")
                        .header("Content-Type", "application/json")
                        .pathParam("username", "Parveen")
                        .when()
                        .get("/user/{username}");

            }

            Response response = given().baseUri("https://petstore.swagger.io/v2")
                    .header("Content-Type", "application/json")
                    .pathParam("username", "Parveen")
                    .when()
                    .get("/user/{username}");

            response.then().statusCode(200);
            response.then().body("code", equalTo(200)); // Optional: Assert specific error code if available

            // Print response body
            System.out.println(response.getBody().asString());
        }

        @Test(priority = 8, description = "Verify user response with unsupported HTTP method.", enabled = true)
    public void verifyUser_Invalid_HTTPMethod() {
        AllureLogger.logToAllure("Verify user response with unsupported HTTP method.");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .pathParam("username", "Parveen")
                .when()
                .post("/user/{username}");
        response.then().statusCode(405);
        System.out.println(response.asString());

    }

    @Test(priority = 9, description = "Verify user response with missing Content-Type header.", enabled = true)
    public void verifyUser_MissingContentTypeHeader() {
        AllureLogger.logToAllure("Verify user response with missing Content-Type header.");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                pathParam("username", "Parveen")
                .when()
                .get("/user/{username}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 10, description = "Verify user with empty parameter", enabled = true)
    public void verifyUser_EmptyParameter() {
        AllureLogger.logToAllure("Verify user with empty parameter");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                pathParam("username", "")
                .when()
                .get("/user/{username}");
        response.then().statusCode(405);
        System.out.println(response.asString());
    }
}