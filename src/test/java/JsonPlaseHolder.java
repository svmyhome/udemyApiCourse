import config.TestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.*;

@Epic("������ ����")
public class JsonPlaseHolder extends TestConfig {

    @Test
    @Description("GET ���� � ��������")
    @Feature("���� ������")
    @Story("����� ������")
    public void GetPlaseholder() {
        given().queryParam("postId", 1).log().uri().
                when().get(JSON_PLASEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("PUT ���� � ������")
    @Feature("���� 2")
    @Story("����� ������")
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
    @Description("DEL ���� � ��������� �������")
    @Feature("���� 2")
    @Story("����� ������")
    public void DelPlaseholder() {
        given().log().uri().
                when().delete(JSON_PLASEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("POST ���� � ��������� ���� �������")
    @Feature("���� 3")
    @Story("����� ������")
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
    @Description("XML ���� � ��������� ���� �������")
    @Feature("���� 3")
    @Story("����� ������")
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
