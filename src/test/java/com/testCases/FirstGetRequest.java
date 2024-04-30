package com.testCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstGetRequest {

    @Test
    public void testcase1(){
    Response res = RestAssured.get("https://petstore.swagger.io/#/");
        System.out.println(res.asString());
    }

    @Test
    public void testcase2(){
        Response res = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println("Response Code:" + res.getStatusCode());
        System.out.println("Response Time:" + res.getTime());
        System.out.println("Response Body:" + res.getBody().asString());
        System.out.println("Response Headers:" + res.getHeaders());


        int expectedStatusCode = 200;
        int actualStatusCode = res.statusCode();

        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }

    @Test
    public void testcaseViaBDD(){

        RestAssured.baseURI="https://reqres.in/api/users";
        RestAssured.given().queryParam("page","2");


    }
}
