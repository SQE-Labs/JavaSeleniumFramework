package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UpdateUserDetailsPutAPI_Tcs extends Utilities {

    String payload = "{ \"id\": 568, \"username\": \"Jimmy\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\", \"phone\": \"1234567890\", \"userStatus\": 1 }";

    String invalid_PhoneNumber_Payload = "{ \"id\": 568, \"username\": \"Jimmy\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\", \"phone\": \"12345621576241761567890\", \"userStatus\": 1 }";

    String invalid_PasswordLength_Payload = "{ \"id\": 568, \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password12345678987654321password123\", \"phone\": \"1234567890\", \"userStatus\": 1 }";

    String missing_UsernameField = "{ \"id\": 568, \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\", \"phone\": \"1234567890\", \"userStatus\": 1 }";

    String invalidIDPayload = "{ \"id\": 5555555555555555894743876478348743t583, \"username\": \"Jimmy\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\", \"phone\": \"1234567890\", \"userStatus\": 1 }";

    String emptyPayload = "";

    @Test(priority = 1, description = "Update an existing username with PUT request", enabled = true)
    public void updateUser_WithPUT() {
        AllureLogger.logToAllure("Update an existing username with PUT request");

        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .put("/user/new_username");

        response.then()
                .statusCode(200);

        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("568"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }

        System.out.println(response.asString());
    }


    @Test(priority = 2, description = "Verify that sending a PUT request for a non-existent resource.", enabled = true)
    public void updateWith_NonExistentUser() {
        AllureLogger.logToAllure("Verify that sending a PUT request for a non-existent resource.");

        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .put("/user/UserNotExist");

        response.then().statusCode(200);
        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("568"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }

        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Verify that sending a PUT request with empty body.", enabled = true)
    public void updateResource_WithEmptyBody() {
        AllureLogger.logToAllure("Verify that sending a PUT request with empty body.");

        Response response = given()
                .spec(requestSpec)
                .body(emptyPayload).log().body()
                .when()
                .put("/user/namer");
        response.then().statusCode(405);
        System.out.println(response.asString());

    }

    @Test(priority = 4, description = "Verify user response with missing Content-Type header.", enabled = true)
    public void verifyUser_MissingContentTypeHeader() {
        AllureLogger.logToAllure("Verify user response with missing Content-Type header.");

        Response response = given()
                .spec(requestSpec_ContainsBaseURI)
                .body(payload).log().body()
                .when()
                .put("/user/Namer");
        response.then().statusCode(415);
        System.out.println(response.asString());

    }

    @Test(priority = 5, description = "Verify that sending a PUT request with an invalid resource ID returns an error.", enabled = true)
    public void updateResource_WithInvalidID() {
        AllureLogger.logToAllure("Verify that sending a PUT request with an invalid resource ID returns an error.");

        Response response = given()
                .spec(requestSpec)
                .body(invalidIDPayload).log().body()
                .when()
                .put("/user/Namer");
        response.then().statusCode(415);
        System.out.println(response.asString());

    }

    @Test(priority = 6, description = "Verify that sending a PUT request with an invalid phone number length .", enabled = true)
    public void update_InvalidPhoneNumber() {
        AllureLogger.logToAllure("Verify that sending a PUT request with an invalid phone number length .");

        Response response = given()
                .spec(requestSpec)
                .body(invalid_PhoneNumber_Payload).log().body()
                .when()
                .put("/user/Namer");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }

    @Test(priority = 7, description = "Verify that sending a PUT request with an invalid password length", enabled = true)
    public void update_InvalidPasswordLength() {
        AllureLogger.logToAllure("Verify that sending a PUT request with an invalid password length");

        Response response = given()
                .spec(requestSpec)
                .body(invalid_PasswordLength_Payload).log().body()
                .when()
                .put("/user/Namer");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }


    @Test(priority = 8, description = "Missing the username field and verify the response.", enabled = true)
    public void verify_MissingUsernameField_InPayload() {
        AllureLogger.logToAllure("Missing the username field and verify the response");

        Response response = given()
                .spec(requestSpec)
                .body(missing_UsernameField).log().body()
                .when()
                .put("/user/new_username");

        response.then().statusCode(200);
        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("568"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }

        System.out.println(response.asString());
    }
}
