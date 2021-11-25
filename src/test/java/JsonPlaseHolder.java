import config.TestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.*;

@Epic("Второй Эпик")
public class JsonPlaseHolder extends TestConfig {

    @Test
    @Description("GET тест с запросом")
    @Feature("Фича вторая")
    @Story("Стори вторая")
    public void GetPlaseholder() {
        given().queryParam("postId", 1).log().uri().
                when().get(JSON_PLASEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("PUT тест с файлом")
    @Feature("Фича 2")
    @Story("Стори вторая")
    public void PutPlaseholder() {
        String jsonBody = "{\n" +
                "   \"id\":1,\n" +
                "   \"title\":\"foo\",\n" +
                "   \"body\":\"bar\",\n" +
                "   \"userId\":1\n" +
                "}";
        given().body(jsonBody).log().uri().
                when().put(JSON_PLASEHOLDER_PUT).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("DEL тест с удалением запроса")
    @Feature("Фича 2")
    @Story("Стори вторая")
    public void DelPlaseholder() {
        given().log().uri().
                when().delete(JSON_PLASEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("POST тест с отправкой тела запроса")
    @Feature("Фича 3")
    @Story("Стори вторая")
    public void PostPlaseholder() {
        String JsonPost = "{\n" +
                "   \"title\":\"foo\",\n" +
                "   \"body\":\"bar\",\n" +
                "   \"userId\":1\n" +
                "}";

        given().body(JsonPost).log().uri().
                when().post(JSON_PLASEHOLDER_POST).
                then().log().body().statusCode(201);
    }

    @Test
    @Description("XML тест с отправкой тела запроса")
    @Feature("Фича 3")
    @Story("Стори вторая")
    public void XML_BIN() {
        String XmlFile = "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Tanmay</FirstName>\n" +
                "      <LastName>Patil</LastName>\n" +
                "      <ContactNo>1234567890</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>";

        given().body(XmlFile).log().uri().
                when().post("").
                then().log().body().statusCode(200);
    }


}
