import config.TestConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static constants.Constants.Actions.JSON_PLASEHOLDER_GET;
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
}
