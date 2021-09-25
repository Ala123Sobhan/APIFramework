package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

    public RequestSpecification getRequestSpecification(){
        RequestSpecification requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .build();

        return requestSpec;
    }
}
