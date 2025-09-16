// На основании PasswordRecoveryApiTest создавался PasswordRecoveryTest (PasswordRecoveryApiTest позже класс будет удален)
package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@DisplayName("Password recovery form API tests. API Тесты формы восстановления пароля по электронной почте")

public class PasswordRecoveryApiTest {
    @Test
    @DisplayName("Verify password recovery with empty email (API response).Не указан Email")
    public void testPasswordRecoveryWithEmptyEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "")
                .queryParam("action", "imedia:main.api.Auth.restore")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify restore password with incorrect email format (API response).Некорректный email")
    public void testRestorePasswordWithIncorrectEmailFormat() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "@gmail.com")
                .queryParam("action", "imedia:main.api.Auth.restore")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify restore password with incorrect email (API response).Неверные учетные данные или пользователь деактивирован\\\\заблокирован")
    public void testLoginWithIncorrectEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "test8@gmail.com")
                .queryParam("action", "imedia:main.api.Auth.restore")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}
