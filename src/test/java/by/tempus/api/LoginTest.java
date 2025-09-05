package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class LoginTest {
    @Test
    @DisplayName("Verify login with invalid credentials.Неверные учетные данные или пользователь деактивирован\\заблокирован")
    public void testLoginWithInvalidCredentials() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "test5@gmail.com")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .header("bx-ajax", "true")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with empty email.Не указан Email")
    public void testLoginWithEmptyEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .header("bx-ajax", "true")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with empty password.Не указан Пароль")
    public void testLoginWithEmptyPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "test5@gmail.com")
                .formParam("password", "")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .header("bx-ajax", "true")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with incorrect email.Некорректный email")
    public void testLoginWithIncorrectEmailFormat() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "@gmail.com")
                .formParam("password", "34567")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .header("bx-ajax", "true")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify login with empty email and password.Не указан Email")
    public void testLoginWithEmptyEmailAndPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .formParam("email", "")
                .formParam("password", "")
                .queryParam("action", "imedia:main.api.Auth.loginByEmail")
                .header("bx-ajax", "true")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}

//public static final String LOGIN_WITH_INVALID_CREDENTIALS = "Неверные учетные данные или пользователь деактивирован\\заблокирован"";
//public static final String LOGIN_WITH_EMPTY_EMAIL = "Не указан Email";
//public static final String LOGIN_WITH_EMPTY_PASSWORD = "Не указан Пароль";
//public static final String LOGIN_WITH_INVALID_EMAIL_FORMAT = "Некорректный email";
//public static final String LOGIN_WITH_EMPTY_EMAIL_AND_PASSWORD = "Не указан Email";


