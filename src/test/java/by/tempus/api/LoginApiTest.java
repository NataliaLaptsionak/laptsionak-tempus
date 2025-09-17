
// На основании LoginApiTest создавался LoginTest (позже класс будет удален)
package by.tempus.api;

import by.tempus.api.login.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Login form API tests. API Тесты формы логина")

public class LoginApiTest {
    @Test
    @DisplayName("Verify login with invalid credentials (API response).Неверные учетные данные или пользователь деактивирован\\заблокирован")
    public void testLoginWithInvalidCredentials() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParams(LoginService.getFormParams("incorrect@mail.ru", "wrongpassword"))
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
    @DisplayName("Verify login with incorrect email format (API response). Некорректный email")
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
