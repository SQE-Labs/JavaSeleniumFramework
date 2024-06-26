package Base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Utilities {
    protected static RequestSpecification requestSpec;
    protected static RequestSpecification requestSpec_ContainsBaseURI;
    protected static RequestSpecification requestSpec_EndPointNotAvaialble;

    protected static ResponseSpecification responseSpec;

    @BeforeSuite
    public void preRequist(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .addHeader("Content-Type", "application/json")
                .build();

        requestSpec_ContainsBaseURI = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();

        requestSpec_EndPointNotAvaialble = new RequestSpecBuilder()
                .setBaseUri("https://example.com/nonexistent/")
                .addHeader("Content-Type", "application/json")
                .build();


    }

    @BeforeMethod
    public void beforeMethod()
    {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
