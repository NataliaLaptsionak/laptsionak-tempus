package by.tempus.api;

import by.tempus.api.registration.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {
    private RegistrationService registrationService;

    @BeforeEach
    public void setup() {
        registrationService = new RegistrationService();
    }

    @Test
    @DisplayName("Verify user registration with empty full name (API response). Не указано ФИО")
    public void testUserRegistrationWithEmptyFullName() {
        registrationService.doRegistrationRequest("", "test11@gmail.com", "+375(29)999-99-99", "123456", "123456");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_FULL_NAME, registrationService.getErrorMessage(), "Incorrect error message for empty full name")
        );
    }

    @Test
    @DisplayName("Verify registration with existing email (API response). Указанный email используется другим пользователем")
    public void testUserRegistrationWithExistingEmail() {
        registrationService.doRegistrationRequest("Борщевская Василиса Васильевна", "test@gmail.com", "+375(29)999-99-99", "123456", "123456");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.REGISTRATION_WITH_EXISTING_EMAIL, registrationService.getErrorMessage(), "Incorrect error message for existing email")
        );
    }

    @Test
    @DisplayName("Verify registration with empty email (API response). Не указан Email")
    public void testUserRegistrationWithEmptyEmail() {
        registrationService.doRegistrationRequest("Борщевская Василиса Васильевна", "", "+375(29)999-99-97", "123456", "123456");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_EMAIL, registrationService.getErrorMessage(), "Incorrect error message for empty email")
        );
    }

    @Test
    @DisplayName("Verify registration with incorrect phone number (API response). Некорректный номер телефона")
    public void testIncorrectPhoneNumber() {
        registrationService.doRegistrationRequest("Борщевская Василиса Васильевна", "test7@gmail.com", "12343", "123456", "123456");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INVALID_PHONE_NUMBER, registrationService.getErrorMessage(), "Incorrect error message for invalid phone number")
        );
    }

    @Test
    @DisplayName("Verify user registration with existing phone number (API response). Пользователь с номером телефона +375299999999 уже существует")
    public void testUserRegistrationWithExistingPhone() {
        registrationService.doRegistrationRequest("q", "test1@gmail.com", "+375299999999", "11111", "11111");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.REGISTRATION_WITH_EXISTING_PHONE, registrationService.getErrorMessage(), "Incorrect error message for existing phone number")
        );
    }

    @Test
    @DisplayName("Verify user registration with empty phone number (API response). Не указан Номер телефона")
    public void testUserRegistrationWithEmptyPhone() {
        registrationService.doRegistrationRequest("q", "test12@gmail.com", "", "11111", "11111");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_PHONE, registrationService.getErrorMessage(), "Incorrect error message for empty phone number")
        );
    }

    @Test
    @DisplayName("Verify user registration with empty password (API response). Не указан Пароль")
    public void testUserRegistrationWithEmptyPassword() {
        registrationService.doRegistrationRequest("q", "test11@gmail.com", "+375(29)999-99-96", "", "11111");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.EMPTY_PASSWORD, registrationService.getErrorMessage(), "Incorrect error message for empty password")
        );
    }

    @Test
    @DisplayName("Verify user registration with empty repeat password (API response). Некорректное подтверждение пароля")
    public void testUserRegistrationWithEmptyRepeatPassword() {
        registrationService.doRegistrationRequest("Борщевская Василиса Васильевна", "test15@gmail.com", "+375(29)999-99-77", "11111", "");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.INCORRECT_REPEAT_PASSWORD, registrationService.getErrorMessage(), "Incorrect error message for empty repeat password")
        );
    }

    @Test
    @DisplayName("Verify user registration with restriction of the password length (API response). Пароль должен быть не менее 6 символов длиной")
    public void testUserRegistrationWithPasswordLengthRestriction() {
        registrationService.doRegistrationRequest("Борщевская Василиса Васильевна", "test8@gmail.com", "+375(29)999-99-55", "1", "1");
        assertAll(
                () -> assertEquals(200, registrationService.getStatusCode(), "Expected status code is 200"),
                () -> assertEquals(ExpectedMessages.PASSWORD_LENGTH_RESTRICTION, registrationService.getErrorMessage(), "Incorrect error message for password length restriction")
        );
    }
}
