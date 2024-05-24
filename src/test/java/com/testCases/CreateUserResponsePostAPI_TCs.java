package com.testCases;

import Base.Utilities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.IOException;
import com.commonMethods.AllureLogger;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;


public class CreateUserResponsePostAPI_TCs extends Utilities {


    // Read JSON payload from file
    ObjectMapper mapper = new ObjectMapper();
    File jsonFile = new File("C:/Users/Itsqe/IdeaProjects/TestAutomationFramework/testData/payloads/payload.json");
    //String payload = mapper.writeValueAsString(jsonNode);

    // Extract 'code' from JSON payload
   // String code = jsonNode.get("code").asText();

    String payload = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Nitesh123\",\n" +
            "    \"firstName\": \"Nitesh\",\n" +
            "    \"lastName\": \"Dhiman\",\n" +
            "    \"email\": \"Nitesh@gmail.com\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"99965222234\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";

    String payloadWithInvalidEmail = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Nitesh123\",\n" +
            "    \"firstName\": \"Nitesh\",\n" +
            "    \"lastName\": \"Dhiman\",\n" +
            "    \"email\": \"Niteshgmail//\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"99965222234\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";

    String phoneNumberLessThan10_Char = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Nitesh123\",\n" +
            "    \"firstName\": \"Nitesh\",\n" +
            "    \"lastName\": \"Dhiman\",\n" +
            "    \"email\": \"Niteshgmail.com\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"99965234\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";

    String phoneNumberGreater10_Char = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Nitesh123\",\n" +
            "    \"firstName\": \"Nitesh\",\n" +
            "    \"lastName\": \"Dhiman\",\n" +
            "    \"email\": \"Niteshgmail.com\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"999652227657234\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";

    String payloadInvalidDataType = "[\n" +
            "  {\n" +
            "    \"id\": \"1\",     // Changed data type to string\n" +
            "    \"username\": true,     // Changed data type to boolean\n" +
            "    \"firstName\": null,    // Changed data type to null\n" +
            "    \"lastName\": 123,      // Changed data type to number\n" +
            "    \"email\": \"Nitesh@gmail.com\",\n" +
            "    \"password\": [\"Test@1234\"],   // Changed data type to array\n" +
            "    \"phone\": {\"value\": \"99965222234\"},   // Changed data type to object\n" +
            "    \"userStatus\": \"active\"   // Changed data type to string\n" +
            "  }\n" +
            "]\n";


    String incompletePayload = "[\n" +
            "  {\n" +
            "    \"id\": ,\n" +
            "    \"email\": \"\",\n" +
            "    \"password\": \"\",\n" +
            "    \"phone\": \"\",\n" +
            "    \"userStatus\": \n" +
            "  }\n" +
            "]\n";

    String invalidJson = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Saksham\",\n" +
            "    \"firstName\": \"Shubham\",\n" +
            "    \"lastName\": \"Pankaj\",\n" +
            "    \"email\": \"Piyush\",       // Missing quotation mark after \"Piyush\"\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"999654\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "  // This line introduces a syntax error by not being inside an object or an array\n" +
            "]\n";


    String emptyPayload = "";

    public CreateUserResponsePostAPI_TCs() throws IOException {
    }

    @Test(priority = 1, description = "Create list of users with given array", enabled = true)
    public void postUserList() {
        AllureLogger.logToAllure("Create list of users with given array");


        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(200);
        System.out.println(response.asString());
        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("ok"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }
        System.out.println(response.asString());


    }


    @Test(priority = 2, description = "Verify user response with unsupported HTTP method.", enabled = true)
    public void verifyUser_UnsupportedHttpMethod() {
        AllureLogger.logToAllure("Verify user response with unsupported HTTP method.");
        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .put("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Verify user response with invalid URL.", enabled = true)
    public void verifyUser_InvalidUrl() {
        AllureLogger.logToAllure("Verify user response with invalid URL.");

        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .post("/invalidEndpoint");
        response.then().statusCode(404);
        System.out.println(response.asString());
    }


    @Test(priority = 4, description = "Verify user response with missing Content-Type header.", enabled = true)
    public void verifyUser_MissingContentTypeHeader() {
        AllureLogger.logToAllure("Verify user response with missing Content-Type header.");

        Response response = given()
                .spec(requestSpec_ContainsBaseURI)
                .body(payload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }

    @Test(priority = 5, description = "Verify user response with Empty body.", enabled = true)
    public void verifyUser_WithEmptyBody() {
        AllureLogger.logToAllure("Verify user response with Empty body.");

        Response response = given()
                .spec(requestSpec)
                .body(emptyPayload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());

    }


    @Test(priority = 6, description = "Verify user response with missing UserName field.", enabled = true)
    public void verifyUser_RequiredFieldMissing() {
        AllureLogger.logToAllure("Verify user response with missing UserName field.");

        Response response = given()
                .spec(requestSpec)
                .body(incompletePayload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }

    @Test(priority = 7, description = "Verify user response with invalid JSON.", enabled = true)
    public void verifyUser_InvalidJsonFormat() {
        AllureLogger.logToAllure("Verify user response with invalid JSON.");

        Response response = given()
                .spec(requestSpec)
                .body(invalidJson).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }

    @Test(priority = 8, description = "Verify user response with invalid data types for all parameters", enabled = true)
    public void verifyUser_InvalidDataType() {
        AllureLogger.logToAllure("Verify user response with invalid data types for all parameters");

        Response response = given()
                .spec(requestSpec)
                .body(payloadInvalidDataType).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }

    @Test(priority = 9, description = "The user response is verified when endpoints are unavailable.", enabled = true)
    public void verifyUser_EndpointUnavailability() {
        AllureLogger.logToAllure("The user response is verified when endpoints are unavailable.");

        Response response = given()
                .spec(requestSpec_EndPointNotAvaialble)
                .body(payloadInvalidDataType).log().body()
                .when()
                .post("/user/createWithList/");

        response.then().statusCode(404);
        System.out.println(response.asString());
    }

    @Test(priority = 10, description = "Check user response status when the rate limit is exceeded.", enabled = true)
    public void verifyUser_RateLimiting() {
        AllureLogger.logToAllure("Check user response status when the rate limit is exceeded.");

        for (int i = 0; i < 20; i++) {

            Response response = given()
                    .spec(requestSpec)
                    .body(payload).log().body()
                    .when()
                    .post("/user/createWithList/");
            response.then().statusCode(200);
            System.out.println(response.asString());
            System.out.println("Response " + i + ": " + response.getStatusCode());
            if (response.jsonPath().get("message") != null) {
                response.then().body("message", equalTo("ok"));
            } else {
                AllureLogger.logToAllure("Assertion failed.");
            }
            System.out.println(response.asString());

        }
    }

    @Test(priority = 11, description = "Verify user with an invalid email address in the payload.", enabled = true)
    public void verifyUser_InvalidEmailAddress() {
        AllureLogger.logToAllure("Verify user with an invalid email address in the payload.");


        Response response = given()
                .spec(requestSpec)
                .body(payloadWithInvalidEmail).log().body()
                .when()
                .post("/user/createWithList/");

        response.then().statusCode(200);
        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("ok"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }
        System.out.println(response.asString());

    }

    @Test(priority = 12, description = "Verify user with an invalid phone number in payload.", enabled = true)
    public void verifyUser_PhoneNumberLessThan_AND_GreaterThan_10_Char() {
        AllureLogger.logToAllure("Verify user with an invalid phone number in payload.");


        Response response = given()
                .spec(requestSpec)
                .body(phoneNumberGreater10_Char).log().body()
                .when()
                .post("/user/createWithList/");

        response.then().statusCode(200);
        if (response.jsonPath().get("message") != null) {
            response.then().body("message", equalTo("ok"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }
        System.out.println(response.asString());

        // To verify user with phone number less than 10 character
        Response response1 = given()
                .spec(requestSpec)
                .body(phoneNumberLessThan10_Char).log().body()
                .when()
                .post("/user/createWithList/");

        response.then().statusCode(200);
        if (response1.jsonPath().get("message") != null) {
            response1.then().body("message", equalTo("ok"));
        } else {
            AllureLogger.logToAllure("Assertion failed.");
        }
        System.out.println(response.asString());

    }

    @Test(priority = 13, description = "Verify response with existing user.", enabled = true)
    public void verifyResponse_WithExistingUser() {
        AllureLogger.logToAllure("Verify response with existing user.");

        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .post("/user/Nitesh123");

        response.then().statusCode(405);
        System.out.println(response.asString());
    }


    @Test(priority = 14, description = "Verify multiple users with same request.", enabled = true)
    public void verify_MultipleUser() {
        AllureLogger.logToAllure("Verify multiple users with same request.");
        String[] arr = {"saksham1", "shubham1"};

        for (int i = 0; i < arr.length; i++) {
            String url = "/user/" + arr[i];
            System.out.println(url);
            Response response = given()
                    .spec(requestSpec)
                    .body(payload).log().body()
                    .when()
                    .post(url);

            response.then().statusCode(405);
            System.out.println(response.asString());
        }
    }
}
