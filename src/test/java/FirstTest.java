import config.TestConfig;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

@Epic("Первый Эпик")
public class FirstTest extends TestConfig {
    //    GOOGLE KEY = AIzaSyBiqOujdjx21nvu1lGQuFmpZbpMkIjmiI4

    @Test
    @Description("Первый простой тест")
    @Step
    public void myFirstTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().all(). // log().all(). Выводит все логирование запроса
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().all().statusCode(200);
    }

    @Test
    @Description("Второй простой тест")
    @Feature("Фича первая")
    @Story("Стори первая")
    public void mySecondTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().uri().  // log().uri(). Выводит в логирование только URI
        when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). Выводит в логирование BODY
    }

    @Test
    @Description("Третий простой тест")
    @Step
    public void myTherdTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().  // log().ifValidationFails(). Выводит логирование только в случае ошибки
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). Выводит в логирование BODY
    }
}
