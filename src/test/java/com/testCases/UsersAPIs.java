package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UsersAPIs extends Utilities {
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
            "]\n" ;


    String payloadPut = "{\n" +
            "  \"id\": 0,\n" +
            "  \"username\": \"Harshit\",\n" +
            "  \"firstName\": \"Shubham\",\n" +
            "  \"lastName\": \"string\",\n" +
            "  \"email\": \"string\",\n" +
            "  \"password\": \"Test@1234\",\n" +
            "  \"phone\": \"999654\",\n" +
            "  \"userStatus\": 0\n" +
            "}";


    @Test(priority = 1, description = "Create list of users with given array", enabled = true)
    public void postUserList() {
        AllureLogger.logToAllure("Starting the test to post Create list of users with given array");

        Response response = given().baseUri("https://petstore.swagger.io/v2/").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 2, description = "Get user by username", enabled = true)
    public void getUserList() {
        AllureLogger.logToAllure("Starting the test to get user by username");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payload).log().body()
                .pathParam("username","Saksham")
                .when()
                .get("/user/{username}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Update userlist using put method", enabled = true)
    public void updateUserList() {
        AllureLogger.logToAllure("Starting the test to update userlist");

        Response response = given().baseUri("https://petstore.swagger.io/v2/").
                header("Content-Type", "application/json")
                .body(payloadPut).log().body()
                .pathParam("username","Shubham")
                .when()
                .put("user/{username}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 6, description = "Delete user", enabled = true)
    public void deleteUser() {
        AllureLogger.logToAllure("Starting the test to delete user");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .body(payloadPut).log().body()
                .pathParam("username","Harshit")
                .when()
                .delete("/user/{username}");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }


    @Test(priority = 4, description = "Logs user into the system", enabled = true)
    public void logInUser() {
        AllureLogger.logToAllure("Starting the test user Login");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .param("username","Saksham").param("password","Test@1234")
                .when()
                .get("/user/login");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }

    @Test(priority = 5, description = "Logs out current logged in user session", enabled = true)
    public void logOutUser() {
        AllureLogger.logToAllure("Starting the test logout user");

        Response response = given().baseUri("https://petstore.swagger.io/v2").
                header("Content-Type", "application/json")
                .when()
                .get("/user/logout");
        response.then().statusCode(200);
        System.out.println(response.asString());
    }
}
