package com.testCases;

import Base.Utilities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import com.commonMethods.AllureLogger;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import pojoClasses.User;

public class CreateUserResponsePostAPI_TCs extends Utilities {


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


    public CreateUserResponsePostAPI_TCs() throws IOException {
    }

    @Test(priority = 1, description = "Create list of users with given array", enabled = true)
    public void postUserList() {
        AllureLogger.logToAllure("Create list of users with given array");
        User users = new User();
        users.setId(1);
        users.setUsername("Shubham");
        users.setFirstName("Shubh");
        users.setLastName("Mehta");
        users.setPhone("9996293903");
        users.setEmail("shubham@76272.com");
        users.setPassword("Test@123");
        users.setUserStatus(Integer.parseInt("0"));

             Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
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

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
                .when()
                .put("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());
    }

    @Test(priority = 3, description = "Verify user response with invalid URL.", enabled = true)
    public void verifyUser_InvalidUrl() {
        AllureLogger.logToAllure("Verify user response with invalid URL.");

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
                .when()
                .post("/invalidEndpoint");
        response.then().statusCode(404);
        System.out.println(response.asString());
    }


    @Test(priority = 4, description = "Verify user response with missing Content-Type header.", enabled = true)
    public void verifyUser_MissingContentTypeHeader() {
        AllureLogger.logToAllure("Verify user response with missing Content-Type header.");

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec_ContainsBaseURI)
                .body(users).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(415);
        System.out.println(response.asString());
    }

    @Test(priority = 5, description = "Verify user response with Empty body.", enabled = true)
    public void verifyUser_WithEmptyBody() {
        AllureLogger.logToAllure("Verify user response with Empty body.");

        User users = new User();

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(405);
        System.out.println(response.asString());

    }


    @Test(priority = 6, description = "Verify user response with missing UserName field.", enabled = true)
    public void verifyUser_RequiredFieldMissing() {
        AllureLogger.logToAllure("Verify user response with missing UserName field.");

        User users = new User();
        users.setUsername("Shubham");
        users.setLastName("Mehta");
        users.setPhone("9996293903");
        users.setPassword("Test@123");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
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

        User users = new User();
        users.setId(1);
        users.setUsername("true");
        users.setFirstName("null");
        users.setLastName("123");
        users.setPhone("value");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("active"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
                .when()
                .post("/user/createWithList/");
        response.then().statusCode(500);
        System.out.println(response.asString());
    }

    @Test(priority = 9, description = "The user response is verified when endpoints are unavailable.", enabled = true)
    public void verifyUser_EndpointUnavailability() {
        AllureLogger.logToAllure("The user response is verified when endpoints are unavailable.");

        User users = new User();
        users.setId(1);
        users.setUsername("true");
        users.setFirstName("null");
        users.setLastName("123");
        users.setPhone("value");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("active"));

        Response response = given()
                .spec(requestSpec_EndPointNotAvaialble)
                .body(users).log().body()
                .when()
                .post("/user/createWithList/");

        response.then().statusCode(404);
        System.out.println(response.asString());
    }

    @Test(priority = 10, description = "Check user response status when the rate limit is exceeded.", enabled = true)
    public void verifyUser_RateLimiting() {
        AllureLogger.logToAllure("Check user response status when the rate limit is exceeded.");

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        for (int i = 0; i < 20; i++) {

            Response response = given()
                    .spec(requestSpec)
                    .body(users).log().body()
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

        User users = new User();

        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Niteshgmail");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
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

        User users = new User();
        User dpUsers = new User();



        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("999342662523");
        users.setEmail("Niteshgmail");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        dpUsers.setId(1);
        dpUsers.setUsername("Nitesh123");
        dpUsers.setFirstName("Nitesh");
        dpUsers.setLastName("Dhiman");
        dpUsers.setPhone("999343");
        dpUsers.setEmail("Niteshgmail");
        dpUsers.setPassword("Test@1234");
        dpUsers.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
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
                .body(dpUsers).log().body()
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

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        Response response = given()
                .spec(requestSpec)
                .body(users).log().body()
                .when()
                .post("/user/Nitesh123");

        response.then().statusCode(405);
        System.out.println(response.asString());
    }


    @Test(priority = 14, description = "Verify multiple users with same request.", enabled = true)
    public void verify_MultipleUser() {
        AllureLogger.logToAllure("Verify multiple users with same request.");

        User users = new User();
        users.setId(1);
        users.setUsername("Nitesh123");
        users.setFirstName("Nitesh");
        users.setLastName("Dhiman");
        users.setPhone("9992222343");
        users.setEmail("Nitesh@gmail.com");
        users.setPassword("Test@1234");
        users.setUserStatus(Integer.parseInt("0"));

        String[] arr = {"saksham1" , "shubham1"};

        for (int i = 0; i < arr.length; i++) {
            String url = "/user/" + arr[i];
            System.out.println(url);
            Response response = given()
                    .spec(requestSpec)
                    .body(users).log().body()
                    .when()
                    .post(url);

            response.then().statusCode(405);
            System.out.println(response.asString());
        }
    }
}
