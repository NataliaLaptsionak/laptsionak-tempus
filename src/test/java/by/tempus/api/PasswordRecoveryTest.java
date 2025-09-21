package by.tempus.api;

import by.tempus.api.login.LoginService;
import by.tempus.api.passwordRecovery.PasswordRecoveryService;
import by.tempus.resources.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordRecoveryTest {
    private PasswordRecoveryService passwordRecoveryService;
    private String validEmail;
    private String invalidEmail;


    @BeforeEach
    public void setUp() {
        passwordRecoveryService = new PasswordRecoveryService();
        validEmail = DataGenerator.generateValidEmail();
        invalidEmail = DataGenerator.generateInvalidEmail();
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
        passwordRecoveryService.doRequest(invalidEmail);
        assertAll(
                () -> assertEquals(200, passwordRecoveryService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_EMAIL_FORMAT, passwordRecoveryService.getErrorMessage(), "Incorrect error message for invalid email format")
        );
    }

    @Test
    @DisplayName("Verify restore password with unregistered email (API response). Неверные учетные данные или пользователь деактивирован\\заблокирован\"")
    public void testPasswordRecoveryNonExistentEmail() {
        passwordRecoveryService.doRequest(validEmail);
        assertAll(
                () -> assertEquals(200, passwordRecoveryService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.UNREGISTERED_EMAIL, passwordRecoveryService.getErrorMessage(), "Incorrect error message for non-existent user")
        );
    }
}
