import config.TestConfig;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {
    //    GOOGLE KEY = AIzaSyBiqOujdjx21nvu1lGQuFmpZbpMkIjmiI4

    @Test
    @Description("Первый простой тест")
    public void myFirstTest() {
        given().
                when().get(SWAPI_GET_PEOPLE + "1").
                then().statusCode(200);

    }
}
