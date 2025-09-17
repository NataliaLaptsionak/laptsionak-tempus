package by.tempus.api;

import by.tempus.api.login.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    private LoginService loginService;

    @BeforeEach
    public void setup() {
        loginService = new LoginService();
    }

    @Test
    @DisplayName("Verify login with invalid credentials (API response). Неверные учетные данные или пользователь деактивирован\\заблокирован")
    public void testLoginWithInvalidCredentials() {
        loginService.doRequest("incorrect@mail.ru", "wrongpassword");
        assertAll(
                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_CREDENTIALS, loginService.getErrorMessage(), "Incorrect error message")
        );
    }

    @Test
    @DisplayName("Verify login with empty email (API response). Не указан Email")
    public void testLoginWithEmptyEmail() {
        loginService.doRequest("", "34567");
        assertAll(
                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_EMAIL, loginService.getErrorMessage(), "Incorrect error message for empty email")
        );
    }

    @Test
    @DisplayName("Verify login with empty password (API response). Не указан Пароль")
    public void testLoginWithEmptyPassword() {
        loginService.doRequest("test5@gmail.com", "");
        assertAll(
                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_PASSWORD, loginService.getErrorMessage(), "Incorrect error message for empty password")
        );
    }

    @Test
    @DisplayName("Verify login with incorrect email format (API response). Некорректный Email")
    public void testLoginWithIncorrectEmailFormat() {
        loginService.doRequest("@gmail.com", "34567");
        assertAll(
                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_EMAIL_FORMAT, loginService.getErrorMessage(), "Incorrect error message for invalid email format")
        );
    }

    @Test
    @DisplayName("Verify login with empty email and password (API response). Не указан Email.")
    public void testLoginWithEmptyEmailAndPassword() {
        loginService.doRequest("", "");
        assertAll(
                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_EMAIL_AND_PASSWORD, loginService.getErrorMessage(), "Incorrect error message for empty email and password")
        );
    }

    //еще думаю региться или нет или оставить только негативные тесты
//    @Test
//    @DisplayName("Verify successful login (API response). Успешная авторизация")
//    public void testSuccessfulLogin() {
//
//        loginService.doRequest("зарегиться", "зарегиться");
//        assertAll(
//                () -> assertEquals(200, loginService.getStatusCode(), "Expected status code is 200 for successful login"),
//                () -> assertEquals(null, loginService.getErrorMessage(), "Error message should be null for successful login")
//        );
//    }
}
