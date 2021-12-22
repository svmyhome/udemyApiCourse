import config.TestConfig;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@Epic("Первый Эпик")
public class FirstTest extends TestConfig {
    //    GOOGLE KEY = AIzaSyBiqOujdjx21nvu1lGQuFmpZbpMkIjmiI4

    @Test
    @Description("Первый простой тест")
    @Step
    public void myFirstTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all(). // log().all(). Выводит все логирование запроса
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().all().statusCode(200);
    }

    @Test
    @Description("Второй простой тест")
    @Feature("Фича первая")
    @Story("Стори первая")
    public void mySecondTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().uri().  // log().uri(). Выводит в логирование только URI
        when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). Выводит в логирование BODY
    }

    @Test
    @Description("Третий простой тест")
    @Step
    public void myTherdTest() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().spec(requestSpecificationForHomecrest).  // log().ifValidationFails(). Выводит логирование только в случае ошибки
                when().get(SWAPI_GET_PEOPLE + "1").
                then().log().body().statusCode(200); // log().uri(). Выводит в логирование BODY
    }
    @Test
    public void homecrestBody() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                .when().get()
                .then()
                .body("people", equalTo("https://swapi.dev/api/people/"))
                .log().body().statusCode(200);
    }

    @Test
    public void homecrestBody1() {
        given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                .when().get(SWAPI_GET_PEOPLE)
                .then()
                .body("count", equalTo(82))
                .body("results.name[0]", equalTo("Luke Skywalker"))
                .body("results.height[0]", equalTo("172"))
                .body("results.films[0][0]", equalTo("https://swapi.dev/api/films/1/"))
                .log().body().statusCode(200);
    }

    @Test
    public void extractBodyAsString() {
        Response response =
                given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                .when().get(SWAPI_GET_PEOPLE)
                .then().extract().response();
        String jsonAsString = response.asString();
        System.out.println("THIS IS BODY--->" + jsonAsString);
    }

    @Test
    public void extractBodyAsPrettyString() {
        Response response  =
                given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                        .when().get(SWAPI_GET_PEOPLE)
                        .then().extract().response();
        String jsonAsString = response.asPrettyString();
        System.out.println("THIS IS BODY--->" + jsonAsString);
    }

    @Test
    public void extractCookies() {
        Response response  =
                given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                        .when().get()
                        .then().extract().response();
        Map<String, String> getCookies1 = response.getCookies();
        String getCookie1 = response.getCookie("xxx"); // выводит пустое так как нет кук
        System.out.println("THIS IS Cookies--->" + getCookies1);
        System.out.println(getCookie1);
    }

    @Test
    public void extractHeaders() {
        Response response  =
                given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                        .when().get()
                        .then().extract().response();
        Headers AllHeaders = response.getHeaders();
        String getContentType1 = response.getContentType();
        System.out.println("THIS IS All Headers--->" + AllHeaders);
        System.out.println("THIS IS Content Type--->" + getContentType1);
    }

    @Test
    public void extractBody() {
        Response response  =
                given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl").setResponseTemplate("http-request.ftl")).spec(requestSpecificationForHomecrest).log().all()
                        .when().get()
                        .then().extract().response();
        JsonPath json1 = response.jsonPath();
        String getContentType1 = response.getContentType();
        System.out.println("THIS IS JSON--->" + json1.prettyPrint());
    }

    @Test
    @Description("Тест с Gpath1")
    @Step
    public void Gpath1() {
        Response response = given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().spec(requestSpecificationForHomecrest).  // log().ifValidationFails(). Выводит логирование только в случае ошибки
                when().get(SWAPI_GET_PEOPLE).
                then().extract().response(); // log().uri(). Выводит в логирование BODY
      // System.out.println("->>>>>>>>>" + response.asPrettyString());
        Map<String, ?> someobject = response.path("results.find {it.name = 'Luke Skywalker'}");
        System.out.println("someobject ->>>>>" + someobject);
    }

    @Test
    @Description("Тест с Gpath2")
    @Step
    public void Gpath2() {
        Response response = given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().spec(requestSpecificationForHomecrest).  // log().ifValidationFails(). Выводит логирование только в случае ошибки
                when().get(SWAPI_GET_PEOPLE).
                then().extract().response(); // log().uri(). Выводит в логирование BODY
        // System.out.println("->>>>>>>>>" + response.asPrettyString());
        String url = response.path("results.find {it.name = 'Luke Skywalker'}.url");
        System.out.println("url ->>>>>" + url);
    }

    @Test
    @Description("Тест с Gpath3")
    @Step
    public void Gpath3() {
        Response response = given().filter(new AllureRestAssured().setRequestTemplate("http-request.ftl")).log().ifValidationFails().spec(requestSpecificationForHomecrest).  // log().ifValidationFails(). Выводит логирование только в случае ошибки
                when().get(SWAPI_GET_PEOPLE).
                then().extract().response(); // log().uri(). Выводит в логирование BODY
        System.out.println("->>>>>>>>>" + response.asPrettyString());
        List listName = response.path("results.findAll {it.films}.name");
        System.out.println("listName ->>>>>>>>>>>>>>>>>>>>>>>>>" + listName);
    }

}
