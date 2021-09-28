package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojo.AddAPlace;
import pojo.location;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class addPlace extends Utils {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    RequestSpecification res;
    Response response;


    @Given("^Add place payload with (.+) , (.+) and (.+)$")
    public void add_place_payload_with_and(String name, String address, String language) throws Throwable {

        TestData d = new TestData();

        res = given().spec(getRequestSpecification())
                .body(d.addPlace(name, address, language));
    }

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resource, String method) throws Throwable {

        APIResources resourcesAPI = APIResources.valueOf(resource);

        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();

        if (method.equalsIgnoreCase("Post")) {
            response = res.when()
                    .post(resourcesAPI.getResource());
        }
        else if(method.equalsIgnoreCase("Get"))
        {
            response = res.when()
                    .get(resourcesAPI.getResource());

        }
        else {
            response = res.when()
                    .delete(resourcesAPI.getResource());

        }
    }

    @Then("the API call returns status code {int}")
    public void the_api_call_returns_status_code(int stscode) {

        Assert.assertEquals(response.getStatusCode(), stscode);
    }

    @Then("the {string} in response body is {string}")
    public void the_in_response_body_is(String key, String value) {

        Assert.assertEquals(getJsonPath(response, key ), value);
    }

    @And("^the \"([^\"]*)\" maps to the (.+) when user calls \"([^\"]*)\"$")
    public void the_something_maps_to_the_when_user_calls_something(String place_id, String Expectedname, String resource) throws Throwable {
       //System.out.print(place_id+" , "+name+" , "+resource);

        APIResources resourcesAPI = APIResources.valueOf(resource);

        String placeID = getJsonPath(response, place_id);
        res = given().spec(getRequestSpecification())
                .queryParam("place_id",placeID);

        response = res.when().get(resourcesAPI.getResource());

        System.out.println(response.asString());

        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(actualName, Expectedname);


    }


}
