package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class CartTest {
    @Test
    @DisplayName("Verify login with invalid credentials.Неверные учетные данные или пользователь деактивирован\\заблокирован")
    public void testLoginWithInvalidCredentials() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "test5@gmail.com")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}
