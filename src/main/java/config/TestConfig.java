package config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import static constants.Constants.RunVariable.server;
import static constants.Constants.RunVariable.path;


public class TestConfig {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }

}
