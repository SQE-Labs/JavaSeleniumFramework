package com.testCases;

import Base.Utilities;
import com.commonMethods.AllureLogger;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserDetails_Tcs extends Utilities {

    String payload = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"username\": \"Pulkit\",\n" +
            "    \"firstName\": \"Nitesh\",\n" +
            "    \"lastName\": \"Dhiman\",\n" +
            "    \"email\": \"Nitesh@gmail.com\",\n" +
            "    \"password\": \"Test@1234\",\n" +
            "    \"phone\": \"99965222234\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]\n";

    @Test(priority = 1, description = "Update user list of users with given array", enabled = true)
    public void update_UserList() {
        Response response = given()
                .spec(requestSpec)
                .body(payload).log().body()
                .when()
                .put("/user/Pulkit/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }
}
