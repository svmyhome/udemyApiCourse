package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.RunVariable.server;
import static constants.Constants.RunVariable.path;
import static constants.Constants.Servers.SWAPI_URL;
import static constants.Constants.Servers.XML_BIN_URL;


public class TestConfig {

    protected RequestSpecification requestSpecificationForXml = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml")
            .addCookie("testCookieXML")
            .setBaseUri(XML_BIN_URL)
            .build();

    protected RequestSpecification requestSpecificationForHomecrest = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .setBasePath(SWAPI_PATH)
            .build();


    protected ResponseSpecification responseSpecBuilderForGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();



    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;


        RequestSpecification requestSpecificationForJson = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addCookie("testCookieJSON")
                .build();
        RestAssured.requestSpecification = requestSpecificationForJson;
    }

}
