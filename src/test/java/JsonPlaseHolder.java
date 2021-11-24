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
    @Description("������ ���� � ��������")
    @Feature("���� ������")
    @Story("����� ������")
    public void GetPlaseholder() {
        given().queryParam("postId", 1).log().uri().
                when().get(JSON_PLASEHOLDER_GET).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("������ ���� � ������ ")
    @Feature("���� ������")
    @Story("����� ������")
    public void PutPlaseholder() {
        String jsonBody = "{\n" +
                "   \"id\":1,\n" +
                "   \"title\":\"foo\",\n" +
                "   \"body\":\"bar\",\n" +
                "   \"userId\":1\n" +
                "}";
        given().body(jsonBody).log().uri().
                when().get(JSON_PLASEHOLDER_PUT).
                then().log().body().statusCode(200);
    }

    @Test
    @Description("������ ���� � ��������� �������")
    @Feature("���� ������")
    @Story("����� ������")
    public void DelPlaseholder() {
        given().log().uri().
                when().delete(JSON_PLASEHOLDER_DELETE).
                then().log().body().statusCode(200);
    }

}
