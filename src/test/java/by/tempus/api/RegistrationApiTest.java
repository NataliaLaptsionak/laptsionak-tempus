
// На основании RegistrationApiTest создавался RegistrationTest (позже класс будет удален)

package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Registration form API tests. API Тесты формы регистрации")

public class RegistrationApiTest {

    @Test
    @DisplayName("Verify registration with empty full name (API response). Не указано ФИО")
    public void testUserRegistrationWithEmptyFullName() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "")
                .formParam("email", "test11@gmail.com")
                .formParam("phone", "+375(29)999-99-99")
                .formParam("password", "123456")
                .formParam("passwordRepeat", "123456")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify registration with existing email (API response). Указанный email используется другим пользователем")
    public void testUserRegistrationWithExistingEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Ворвашевская Василиса Васильевна")
                .formParam("email", "test1@gmail.com")
                .formParam("phone", "+375(29)999-99-99")
                .formParam("password", "123456")
                .formParam("passwordRepeat", "123456")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify registration with empty email (API response). Не указан Email")
    public void testUserRegistrationWithEmptyEmail() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Ворвашевская Василиса Васильевна")
                .formParam("email", "")
                .formParam("phone", "+375(29)999-99-97")
                .formParam("password", "123456")
                .formParam("passwordRepeat", "123456")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify registration with incorrect phone number (API response). Некорректный номер телефона")
    public void testIncorrectPhoneNumber() {
        String URL = "http://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action","imedia:main.api.Auth.registration")
                .multiPart("fullName", "123456")
                .multiPart("email", "test7@gmail.com")
                .multiPart("phone", "+375(26)999-99-77")
                .multiPart("password", "123456")
                .multiPart("passwordRepeat", "123456")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with existing phone number (API response). Пользователь с номером телефона +375299999999 уже существует")
    public void testUserRegistrationWithExistingPhone() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "q")
                .formParam("email", "test1@gmail.com")
                .formParam("phone", "+375(29)999-99-99")
                .formParam("password", "11111")
                .formParam("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with empty phone number (API response). Не указан Номер телефона")
    public void testUserRegistrationWithEmptyPhone() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "q")
                .formParam("email", "test12@gmail.com")
                .formParam("phone", "")
                .formParam("password", "11111")
                .formParam("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with empty password (API response). Не указан Пароль")
    public void testUserRegistrationWithEmptyPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "q")
                .formParam("email", "test11@gmail.com")
                .formParam("phone", "+375(29)999-99-96")
                .formParam("password", "")
                .formParam("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with empty repeat password (API response). Некорректное подтверждение пароля")
    public void testUserRegistrationWithEmptyRepeatPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Морвашевская Василиса Васильевна")
                .formParam("email", "test15@gmail.com")
                .formParam("phone", "+375(29)999-99-77")
                .formParam("password", "11111")
                .formParam("passwordRepeat", "")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with restriction of the password length (API response). Пароль должен  быть не менее 6 символов длиной")
    public void testUserRegistrationWithPasswordLengthRestriction() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Ворвашевская Василиса Васильевна")
                .formParam("email", "test8@gmail.com")
                .formParam("phone", "+375(29)999-99-55")
                .formParam("password", "1")
                .formParam("passwordRepeat", "1")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}
