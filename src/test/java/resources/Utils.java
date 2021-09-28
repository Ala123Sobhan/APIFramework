package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {


    public static RequestSpecification requestSpec;


    public RequestSpecification getRequestSpecification() throws IOException {

        if (requestSpec == null) {

            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                    .setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();

            return requestSpec;
        }
        return requestSpec;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key)
    {
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return  js.get(key).toString();

    }
}
