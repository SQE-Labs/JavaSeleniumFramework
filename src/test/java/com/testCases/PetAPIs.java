package com.testCases;

import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetAPIs {

    String payload = "{\n" +
            "  \"id\": 1,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    String payloadPut = "{\n" +
            "  \"id\": 0,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    @Test(priority = 1, description = "Uploads a image", enabled = true)
    public void uploadImage() {
        AllureLogger.logToAllure("Starting the test to upload a image");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "multipart/form-data")
                .pathParam("petId", "1")
                .multiPart("file", "C:/Users/Itsqe/IdeaProjects/TestAutomationFramework/testData/pexels-pixabay-355235.jpg")
                .when()
                .post("/pet/{petId}/uploadImage");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 2, description = "Add a new pet to the store", enabled = true)
    public void addNewPet() {
        AllureLogger.logToAllure("Starting the test to post Create list of users with given array");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .when()
                .post("/pet");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Update an existing pet", enabled = true)
    public void updateExistingPet() {
        AllureLogger.logToAllure("Starting the test to update existing pet");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payloadPut).log().body()
                .when()
                .put("/pet");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 4, description = "Finding pets by status", enabled = true)
    public void findingPetsWithAvailableStatus() {
        AllureLogger.logToAllure("Starting the test to update existing pet with status = Available ");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payloadPut).log().body()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 5, description = "Finding pets by status", enabled = true)
    public void findingPetsWithPendingStatus() {
        AllureLogger.logToAllure("Starting the test to update existing pet with status = Pending");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payloadPut).log().body()
                .queryParam("status", "pending")
                .when()
                .get("/pet/findByStatus");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 6, description = "Finding pets by status", enabled = true)
    public void findingPetsWithSoldStatus() {
        AllureLogger.logToAllure("Starting the test to update existing pet with status = Sold");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .queryParam("status", "sold")
                .when()
                .get("/pet/findByStatus");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 7, description = "Finding pets by ID", enabled = true)
    public void findingPetsByID() {
        AllureLogger.logToAllure("Starting the test to find pet By ID");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .pathParam("petId", "1")
                .when()
                .get("/pet/{petId}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 8, description = "Update Pet with form data", enabled = true)
    public void updatePetWithFormData() {
        AllureLogger.logToAllure("Starting the test to update with form data");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/x-www-form-urlencoded")
                .pathParam("petId", "1")
                .formParam("name", "doggie")
                .formParam("status", "available")
                .when()
                .post("/pet/{petId}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 9, description = "Deleting pets by ID", enabled = true)
    public void deletePet() {
        AllureLogger.logToAllure("Starting the test to deleting pet By ID");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .pathParam("petId", "1")
                .when()
                .delete("/pet/{petId}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }
}
