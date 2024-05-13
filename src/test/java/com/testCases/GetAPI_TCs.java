package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPI_TCs extends Utilities {

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

    @Test(priority = 1, description = "Verify response status when using an unsupported HTTP method", enabled = true)
    public void verify_HttpMethod() {
        AllureLogger.logToAllure("Verify response status when using an unsupported HTTP method.");

        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .pathParam("username", "Saksham")
                .when()
                .post("/user/{username}"); // Using an unsupported HTTP method (POST)

        response.then().statusCode(405); // Expecting a "Method Not Allowed" status code
        System.out.println(response.asString());
    }

    @Test(priority = 2, description = "Validate response status for an invalid URL.", enabled = true)
    public void verify_InvalidUrl() {
        AllureLogger.logToAllure("Validate response status for an invalid URL.");

        Response response = given()
                .spec(requestSpec)
                //  .body(payload).log().body()
                // .pathParam("username","Saksham")
                .when()
                .get("/user/invalid"); // Using an invalid URL

        response.then().statusCode(404); // Expecting a "Not Found" status code
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Confirm response status when the Accept header is missing.", enabled = true)
    public void verify_HeaderMissing() {
        AllureLogger.logToAllure("Confirm response status when the Accept header is missing.");

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .body(payload).log().body()
                .pathParam("username", "Saksham")
                .when()
                .get("/user/{username}");
        response.then().statusCode(404);
        System.out.println(response.asString());
    }

    @Test(priority = 4, description = "Check response status when the response body is empty.", enabled = true)
    public void verify_ResponseEmptyBody() {
        AllureLogger.logToAllure("Check response status when the response body is empty.");

        Response response = given()
                .spec(requestSpec)
                .pathParam("username", "")
                .when()
                .get("/user/{username}");
        response.then().statusCode(405);
        System.out.println(response.asString());
    }

    @Test(priority = 5, description = "Check response status when the rate limit is exceeded.", enabled = true)
    public void verify_RateLimiting() {
        AllureLogger.logToAllure("Check response status when the rate limit is exceeded.");

        for (int i = 0; i < 20; i++) {
            Response response = given()
                    .spec(requestSpec)
                    .pathParam("username", "Saksham")
                    .when()
                    .get("/user/{username}  ");
            System.out.println("Response " + i + ": " + response.getStatusCode());
//            try {
//                Thread.sleep(1000); // 1000 milliseconds = 1 second
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        // Expecting a "Too Many Requests" status code
//        System.out.println(response.asString());
    }

    @Test(priority = 6, description = "Validate body response of GET Api.", enabled = true)
    public void verify_Response_ServerErrors() {
        AllureLogger.logToAllure("Confirm response status for server errors.");

        Response response = given()
                .spec(requestSpec)
                .pathParam("username", "Saksham")
                .when()
                .get("/user/{username}");
        response.then().statusCode(200);
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println(body.asString());
        Assert.assertEquals(bodyAsString.contains("Shubham") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
        Assert.assertEquals(bodyAsString.contains("Mehta") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
    }
}
