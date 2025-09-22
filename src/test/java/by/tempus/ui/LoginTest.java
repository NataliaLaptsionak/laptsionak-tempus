package by.tempus.ui;

import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.restorePassword.RestorePasswordForm;
import by.tempus.ui.pages.login.LoginExpectedMessages;
import by.tempus.ui.pages.login.LoginForm;
import by.tempus.ui.pages.registration.RegistrationForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import by.tempus.resources.DataGenerator;

public class LoginTest extends BaseTest {

    LoginForm loginForm = new LoginForm();

    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .сlickButtonLogin();
    }


    @Test
    @DisplayName("Verification of the login form title")
    public void verifyLoginFormTitle() {
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_FORM_TITLE, loginForm.getLoginFormTitleText());
    }

    @Test
    @DisplayName("Verification of elements presence on the login form.")
    public void verifyLoginFormFields() {
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_FORM_TITLE, loginForm.getLoginFormTitleText());
        Assertions.assertEquals(LoginExpectedMessages.EMAIL_FIELD_LABEL, loginForm.getLabelEmailText());
        Assertions.assertEquals(LoginExpectedMessages.PASSWORD_FIELD_LABEL, loginForm.getLabelPasswordText());
        Assertions.assertEquals(LoginExpectedMessages.RESTORE_PASSWORD_FIELD_LABEL, loginForm.getButtonRestorePasswordText());
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_BUTTON_TEXT, loginForm.getButtonLoginText());
        Assertions.assertEquals(LoginExpectedMessages.REGISTRATION_TAB_TITLE, loginForm.getButtonRegistrationFormText());
    }

    @Test
    @DisplayName("Verification of error messages for empty required fields")
    public void verifyErrorMessagesForEmptyFields() {
        loginForm.clickButtonLogin();
        Assertions.assertEquals(LoginExpectedMessages.EMPTY_EMAIL_FIELD_ERROR, loginForm.getEmptyEmailError());
        Assertions.assertEquals(LoginExpectedMessages.EMPTY_PASSWORD_FIELD_ERROR, loginForm.getEmptyPasswordError());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing '@')")
    public void invalidEmailFormatMissingAtTest() {
        String invalidEmail = DataGenerator.generateInvalidEmailMissingAt();
        loginForm.sendKeysLogin(invalidEmail);
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        String expected = String.format(LoginExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_AT, invalidEmail);
        Assertions.assertEquals(expected, loginForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field.")
    public void verifyErrorMessageForEmptyPasswordField() {
        loginForm.sendKeysLogin(DataGenerator.generateValidEmail());
        loginForm.clickButtonLogin();
        Assertions.assertEquals(LoginExpectedMessages.EMPTY_PASSWORD_FIELD_ERROR, loginForm.getEmptyPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field. Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void verifyErrorMessageForEmptyEmailField() {
        loginForm.fillLoginForm("", DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        Assertions.assertEquals(LoginExpectedMessages.EMPTY_EMAIL_FIELD_ERROR, loginForm.getEmptyEmailError());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing part before '@')")
    public void invalidEmailFormatMissingPartBeforeAtTest() {
        String invalidEmail = DataGenerator.generateInvalidEmailMissingPartBeforeAt(); // Измените на email, где отсутствует часть ДО '@'
        loginForm.sendKeysLogin(invalidEmail);
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        // Ожидаем сообщение об ошибке для отсутствия части ДО '@'
        String expected = String.format(LoginExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_PART_BEFORE_AT, invalidEmail);
        Assertions.assertEquals(expected, loginForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing part after '@')")
    public void invalidEmailFormatMissingPartAfterAtTest() {
        String invalidEmail = DataGenerator.generateInvalidEmailMissingPartAfterAt();
        loginForm.sendKeysLogin(invalidEmail);
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        String expected = String.format(LoginExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_PART_AFTER_AT, invalidEmail);
        Assertions.assertEquals(expected, loginForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verify message for incorrect email address (e.g., '1@rtty')")
    public void incorrectEmailAddressTest() {
        String invalidEmail = DataGenerator.generateIncorrectEmail();
        loginForm.sendKeysLogin(invalidEmail);
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        String expected = String.format(LoginExpectedMessages.INCORRECT_EMAIL_ADDRESS_ERROR,invalidEmail);
        Assertions.assertEquals(expected, loginForm.getIncorrectEmailError());
    }

    @Test
    @DisplayName("Verification of error message for unregistered credentials.")
    public void InvalidCredentialsTest() {
        loginForm.sendKeysLogin(DataGenerator.generateValidEmail());
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        Assertions.assertEquals(LoginExpectedMessages.UNREGISTERED_CREDENTIALS_ERROR, loginForm.getLoginCredentialsError());
    }

    @Test
    @DisplayName("Verification of redirection to password recovery form.")
    public void RestorePasswordFormRedirectionTest() {
        loginForm.clickRestorePasswordLink();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();
        Assertions.assertEquals(LoginExpectedMessages.RESTORE_PASSWORD_TEXT, loginForm.getRestorePasswordFormTitleText());
    }

    @Test
    @DisplayName("Verification of redirection to registration form.")
    public void RegistrationFormRedirectionTest() {
        loginForm.clickTabRegistration();
        RegistrationForm registrationForm = new RegistrationForm();

        Assertions.assertEquals(LoginExpectedMessages.REGISTRATION_BUTTON_TEXT, registrationForm.getTitleRegistrationTab());
    }
}
