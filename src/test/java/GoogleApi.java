import config.TestConfig;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleApi {

    @Test
    public void XmlSchemaValidation() {
        given().log().uri()
                .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?input=New York&inputtype=textquery&fields=business_status,formatted_address,geometry,icon,icon_mask_base_uri,name,photo,place_id,plus_code,type&key=AIzaSyC4WnQH39MQ1D6B2yN7P4yxOfTOCxv3PM0&language=ru")
                .then().body(matchesXsdInClasspath("xmlSchema.xsd")).log().body();
    }

    @Test
    public void JsonSchemaValidation() {
        given().log().uri()
                .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=New York&inputtype=textquery&fields=business_status,formatted_address,geometry,icon,icon_mask_base_uri,name,photo,place_id,plus_code,type&key=AIzaSyC4WnQH39MQ1D6B2yN7P4yxOfTOCxv3PM0&language=ru")
                .then().body(matchesJsonSchemaInClasspath("jsonSchema.json")).log().body();

    }
}
