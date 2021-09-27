package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public RequestSpecification getRequestSpecification() throws IOException {



        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

        RequestSpecification requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(getGlobalValue("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        return requestSpec;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
}
