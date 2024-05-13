package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostAPI_TCs extends Utilities {

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

    String payloadInvalidDataType = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": 1,\n" +
            "    \"firstName\": \"Shubham\",\n" +
            "    \"lastName\": \"Pankaj\",\n" +
            "    \"email\": \"Piyush\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"999654\",\n" +
            "    \"userStatus\": 0\n" +
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
            "]\n";

    String emptyPayload = "";


    @Test(priority = 1, description = "Verify response status when using an unsupported HTTP method.", enabled = true)
    public void verify_UnsupportedHttpMethod() {
        AllureLogger.logToAllure("Verify response status when using an unsupported HTTP method.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .when()
                .get("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());
    }

    @Test(priority = 2, description = "Verify response status when accessing an invalid URL.", enabled = true)
    public void verify_invalidUrl() {
        AllureLogger.logToAllure("Verify response status when accessing an invalid URL.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .when()
                .post("/invalidEndpoint");
        response.then().statusCode(404);
        System.out.println(response.asString());
    }


    @Test(priority = 3, description = "Verify response status when the Content-Type header is missing.", enabled = true)
    public void verify_ContentTypeHeader() {
        AllureLogger.logToAllure("Verify response status when the Content-Type header is missing.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/")
                .body(payload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }

    @Test(priority = 4, description = "Verify response status when sending an empty request body.", enabled = true)
    public void verify_StatusEmptyBody() {
        AllureLogger.logToAllure("Verify response status when sending an empty request body.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/").
                header("Content-Type", "application/json")
                .body(emptyPayload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());

    }


    @Test(priority = 5, description = "Verify response status when required fields are missing.", enabled = true)
    public void verify_RequiredFieldMissing() {
        AllureLogger.logToAllure("Verify response status when required fields are missing.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/")
                .header("Content-Type", "application/json")
                .body(incompletePayload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }

    @Test(priority = 6, description = "Verify response status when providing invalid JSON format in the request body.", enabled = true)
    public void verify_InvalidJsonFormat() {
        AllureLogger.logToAllure("Verify response status when providing invalid JSON format in the request body.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/")
                .header("Content-Type", "application/json")
                .body(invalidJson).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }


//    @Test(priority = 7, description = "Create list of users with given array", enabled = true)
//    public void verify_DuplicateUser() {
//        AllureLogger.logToAllure("Starting the test to post Create list of users with given array");
//
//        Response response = given().baseUri("https://petstore.swagger.io/v2/")
//                //   header("Content-Type", "application/json")
//                .body(payload).log().body()
//                .when()
//                .post("/user/createWithList/");
//        response.then().statusCode(401);
//        System.out.println(response.asString());
//    }

    @Test(priority = 8, description = "Verify response status when providing invalid data types.", enabled = true)
    public void verify_InvalidDataType() {
        AllureLogger.logToAllure("Verify response status when providing invalid data types.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/")
                .header("Content-Type", "application/json")
                .body(payloadInvalidDataType).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }

    @Test(priority = 9, description = "Verify server error handling response status.", enabled = true)
    public void verify_ServerErrorResponse() {
        AllureLogger.logToAllure("Verify server error handling response status.");

        Response response = given().baseUri("https://petstore.swagger.io/v2/")
                .header("Content-Type", "application/json")
                .body(invalidJson).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500); // Expecting a "Internal Server Error" status code
        System.out.println(response.asString());
    }

}