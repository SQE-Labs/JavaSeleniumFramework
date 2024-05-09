package com.testCases;

import com.commonMethods.AllureLogger;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class StoreAPIs {


    private int orderId;

    String payload = "{\n" +
            "  \"id\": 1,\n" +
            "  \"petId\": 0,\n" +
            "  \"quantity\": 0,\n" +
            "  \"shipDate\": \"2024-05-01T06:57:43.297Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";



    @Test(priority = 1,description = "To get the Store Inventory Details",enabled = true)
    public void getInventoryStoreDetails() {
        AllureLogger.logToAllure("Starting the test to get inventory store details");

        Response response = given().baseUri("https://petstore.swagger.io/v2/store").
                header("Content-Type", "application/json")
                .when()
                .get("/inventory");
        response.then().assertThat().statusCode(200);
//        String response = given().
//                header("Content-Type", "application/json")
//                .when()
//                .get("https://petstore.swagger.io/#/store/inventory").then().extract().asString();
//        System.out.println(response);
//        System.out.println(response.getContentType());
        System.out.println(response.asString());

    }


    @Test(priority = 2,description = "To post the store details",enabled = true)
    public void postStoreDetails() {

        AllureLogger.logToAllure("Starting the test to post store details");

        Response response = given().baseUri("https://petstore.swagger.io/v2/store").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .when()
                .post("/order");
        response.then().statusCode(200);
        orderId = response.then().extract().path("id");
        System.out.println("Order ID: " + orderId);
        System.out.println(response.asString());
    }

    @Test(priority = 3 ,description = "Get the store details on the basis of id",enabled = true)
    public void getStoreDetailsByOrderId() {
        AllureLogger.logToAllure("Starting the test to get store details");

        Response response = given().baseUri("https://petstore.swagger.io/v2/store").
                header("Content-Type", "application/json")
                .pathParam("orderId", orderId)
                .when()
                .get("/order/{orderId}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 4,description = "Starting the test to delete store details",enabled = true)
    public void deleteStoreDetails() {
        AllureLogger.logToAllure("Deleting store details");

        Response response = given().baseUri("https://petstore.swagger.io/v2/store").
                contentType(ContentType.JSON)
                .pathParam("orderId",orderId)
                .when()
                .delete("/order/{orderId}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }
}
