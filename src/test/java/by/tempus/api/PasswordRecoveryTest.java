package by.tempus.api;

import by.tempus.api.passwordRecovery.PasswordRecoveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordRecoveryTest {

    private PasswordRecoveryService passwordRecoveryService;

    @BeforeEach
    public void setUp() {
        passwordRecoveryService = new PasswordRecoveryService();
    }

    @Test
    @DisplayName("Verify password recovery with empty email (API response). Не указан Email!")
    public void testPasswordRecoveryEmptyEmail() {
        passwordRecoveryService.doRequest("");
        assertAll(
                () -> assertEquals(200, passwordRecoveryService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_EMAIL, passwordRecoveryService.getErrorMessage(), "Incorrect error message for empty email")
        );
    }

    @Test
    @DisplayName("Verify password recovery with invalid email format (API response). Некорректный Email!")
    public void testPasswordRecoveryInvalidEmailFormat() {
        passwordRecoveryService.doRequest("invalid-email");
        assertAll(
                () -> assertEquals(200, passwordRecoveryService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_EMAIL_FORMAT, passwordRecoveryService.getErrorMessage(), "Incorrect error message for invalid email format")
        );
    }

    @Test
    @DisplayName("Verify restore password with incorrect email (non-existent email) (API response). Неверные учетные данные или пользователь деактивирован\\заблокирован\"")
    public void testPasswordRecoveryNonExistentEmail() {
        passwordRecoveryService.doRequest("nonexistent@mail.ru");
        assertAll(
                () -> assertEquals(200, passwordRecoveryService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_CREDENTIALS, passwordRecoveryService.getErrorMessage(), "Incorrect error message for non-existent user")
        );
    }
}
