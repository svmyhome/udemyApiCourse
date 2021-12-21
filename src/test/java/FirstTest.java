import config.TestConfig;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@Epic("������ ����")
public class FirstTest extends TestConfig {
    //    GOOGLE KEY = AIzaSyBiqOujdjx21nvu1lGQuFmpZbpMkIjmiI4

    @Test
    @Description("������ ������� ����")
    @Step
    public void myFirstTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all(). // log().all(). ������� ��� ����������� �������
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().all().statusCode(200);
    }

    @Test
    @Description("������ ������� ����")
    @Feature("���� ������")
    @Story("����� ������")
    public void mySecondTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().uri().  // log().uri(). ������� � ����������� ������ URI
        when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). ������� � ����������� BODY
    }

    @Test
    @Description("������ ������� ����")
    @Step
    public void myTherdTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().spec(requestSpecificationForHomecrest).  // log().ifValidationFails(). ������� ����������� ������ � ������ ������
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). ������� � ����������� BODY
    }
    @Test
    public void homecrestBody() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                .when().get()
                .then()
                .body("people", equalTo("https://swapi.dev/api/people/"))
                .log().body().statusCode(200);
    }

    @Test //TODO ������������ ������
    public void homecrestBody1() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                .when().get(SWAPI_GET_PEOPLE)
                .then()
                .body("count", equalTo(82))
                .body("results.name[0]", equalTo("Luke Skywalker"))
                .body("results.height[0]", equalTo("172"))
                .body("results.films[0]", equalTo("https://swapi.dev/api/films/1/"))
                .log().body().statusCode(200);
    }
}
