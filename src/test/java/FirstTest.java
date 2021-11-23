import config.TestConfig;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

@Epic("������ ����")
public class FirstTest extends TestConfig {
    //    GOOGLE KEY = AIzaSyBiqOujdjx21nvu1lGQuFmpZbpMkIjmiI4

    @Test
    @Description("������ ������� ����")
    @Step
    public void myFirstTest() {
        given().log().all(). // log().all(). ������� ��� ����������� �������
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().all().statusCode(200);
    }

    @Test
    @Description("������ ������� ����")
    @Feature("���� ������")
    @Story("����� ������")
    public void mySecondTest() {
        given().log().uri().  // log().uri(). ������� � ����������� ������ URI
        when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). ������� � ����������� BODY
    }

    @Test
    @Description("������ ������� ����")
    @Step
    public void myTherdTest() {
        given().log().ifValidationFails().  // log().ifValidationFails(). ������� ����������� ������ � ������ ������
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). ������� � ����������� BODY
    }
}
