package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Login form API tests. API Тесты формы логина")

public class LoginTest {
    @Test
    @DisplayName("Verify login with invalid credentials (API response).Неверные учетные данные или пользователь деактивирован\\заблокирован")
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

    @Test
    @DisplayName("Verify login with empty email (API response). Не указан Email")
    public void testLoginWithEmptyEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with empty password (API response). Не указан Пароль")
    public void testLoginWithEmptyPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "test5@gmail.com")
                .formParam("password", "")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with incorrect email (API response). Некорректный email")
    public void testLoginWithIncorrectEmailFormat() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "@gmail.com")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with empty email and password (API response). Не указан Email")
    public void testLoginWithEmptyEmailAndPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "")
                .formParam("password", "")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}
