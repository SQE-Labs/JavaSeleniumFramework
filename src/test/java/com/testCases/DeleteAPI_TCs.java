package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteAPI_TCs extends Utilities {

    @Test(priority = 1, description = "Verify Delete Operation", enabled = true)
    public void verifyDeleteUser() {
        AllureLogger.logToAllure("Starting the test to verify delete operation");

        Response response = given()
                .spec(requestSpec)
                .pathParam("username", "Harshit")
                .when()
                .delete("/user/{username}");

        response.then().statusCode(404);

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();


        //To Validate Response Time
        response.then().statusCode(404);

        System.out.println(response.asString());
        long responseTime = endTime - startTime;
        System.out.println("Response Time: " + responseTime + " milliseconds");
        Assert.assertTrue(responseTime < 1000, "Response time should be less than 1000 milliseconds");
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Verify Delete Operation with Invalid Username", enabled = true)
    public void verifyDeleteOperationWithInvalidUsername() {
        AllureLogger.logToAllure("Starting the test to verify delete operation with invalid username");

        Response response = given()
                .spec(requestSpec)
                .pathParam("username", "InvalidUsername") // Update username to an invalid value
                .when()
                .delete("/user/{username}");

        response.then().statusCode(404); // Adjust the expected status code if needed
        System.out.println(response.asString());
    }



    @Test(priority = 2, description = "Verify Delete Operation with Response Time Validation", enabled = true)
    public void verifyDeleteOperationWithResponseTimeValidation() {
        AllureLogger.logToAllure("Starting the test to verify delete operation with response time validation");

        // Record start time before sending the request
        long startTime = System.currentTimeMillis();

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .pathParam("username", "Harshit")
                .when()
                .delete("/user/{username}");

        // Record end time after receiving the response
        long endTime = System.currentTimeMillis();

        response.then().statusCode(404); // Adjust the expected status code if needed
        System.out.println(response.asString());

        // Calculate response time
        long responseTime = endTime - startTime;
        System.out.println("Response Time: " + responseTime + " milliseconds");

        // Validate response time (e.g., assert that it's within an acceptable range)
        // Add your assertion logic here based on the expected response time
        Assert.assertTrue(responseTime < 4000, "Response time should be less than 1000 milliseconds");
    }


    @Test(priority = 4, description = "Verify Delete Operation with Request Headers Validation", enabled = true)
    public void verifyDeleteOperationWithRequestHeadersValidation() {
        AllureLogger.logToAllure("Starting the test to verify delete operation with request headers validation");

        Response response = given()
                .spec(requestSpec)
                .pathParam("username", "Harshit")
                .when()
                .delete("/user/{username}");

        response.then().statusCode(404); // Adjust the expected status code if needed

        // Validate request headers
        Headers headers = response.getHeaders();
        System.out.println("Request Headers: " + headers);

        // Add your assertion logic here to validate request headers
        // For example, assert that the 'Content-Type' header is present and has the value 'application/json'
        Assert.assertTrue(headers.hasHeaderWithName("Content-Type"));
        Assert.assertEquals(headers.getValue("Content-Type"), "application/json");

        System.out.println(response.asString());
    }

}

