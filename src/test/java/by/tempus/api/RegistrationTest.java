package by.tempus.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class RegistrationTest {

    @Test
    @DisplayName("Verify registration with empty full name (API response). Не указано ФИО")
    public void testUserRegistrationWithEmptyFullName() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "")
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
    @DisplayName("Verify registration with empty email (API response). Указанный email используется другим пользователем")
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
    @DisplayName("Проверить сообщение об ошибке Некорректный номер телефона")
    public void testIncorrectPhoneNumber() {
        String URL = "http://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action","imedia:main.api.Auth.registration")
                .multiPart("fullName", "123456")
                .multiPart("email", "test1@gmail.com")
                .multiPart("phone", "+375(26)888-88-88")
                .multiPart("password", "11111")
                .multiPart("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with existing phone number. Пользователь с номером телефона +375299999999 уже существует")
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
    @DisplayName("Verify user registration with empty phone number. Не указан Номер телефона")
    public void testUserRegistrationWithEmptyPhone() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "q")
                .formParam("email", "test1@gmail.com")
                .formParam("phone", "")
                .formParam("password", "11111")
                .formParam("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with empty password. Не указан Пароль")
    public void testUserRegistrationWithEmptyPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "q")
                .formParam("email", "test1@gmail.com")
                .formParam("phone", "+375(29)999-99-96")
                .formParam("password", "")
                .formParam("passwordRepeat", "11111")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with empty repeat password. Некорректное подтверждение пароля")
    public void testUserRegistrationWithEmptyRepeatPassword() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Морвашевская Василиса Васильевна")
                .formParam("email", "test3@gmail.com")
                .formParam("phone", "+375(29)999-99-77")
                .formParam("password", "11111")
                .formParam("passwordRepeat", "")
                .when()
                .post(URL)
                .then()
                .log().all();
    }

    @Test
    @DisplayName("Verify user registration with restriction of the password length. Пароль должен  быть не менее 6 символов длиной")
    public void testUserRegistrationWithPasswordLengthRestriction() {
        String URL = "https://tempus.by/bitrix/services/main/ajax.php";

        given()
                .queryParam("action", "imedia:main.api.Auth.registration")
                .formParam("fullName", "Ворвашевская Василиса Васильевна")
                .formParam("email", "test5@gmail.com")
                .formParam("phone", "+375(29)999-99-55")
                .formParam("password", "1")
                .formParam("passwordRepeat", "1")
                .when()
                .post(URL)
                .then()
                .log().all();
    }
}
