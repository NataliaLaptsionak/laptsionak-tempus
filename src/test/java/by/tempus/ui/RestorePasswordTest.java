package by.tempus.ui;

import by.tempus.resources.DataGenerator;
import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.login.LoginExpectedMessages;
import by.tempus.ui.pages.login.LoginForm;
import by.tempus.ui.pages.registration.RegistrationExpectedMessages;
import by.tempus.ui.pages.registration.RegistrationForm;
import by.tempus.ui.pages.restorePassword.RestorePasswordExpectedMessages;
import by.tempus.ui.pages.restorePassword.RestorePasswordForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestorePasswordTest extends BaseTest {


    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .clickButtonLogin();
    }

    @Test
    @DisplayName("Verification of redirection to restore password form form.")
     void RestorePasswordFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        assertEquals(RestorePasswordExpectedMessages.RESTORE_PASSWORD_FORM_TEXT, restorePasswordForm.getRestorePasswordFormText());
    }

    @Test
    @DisplayName("Verification of elements presence on the restore password form.")
    public void verifyRestorePasswordFormFields() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        assertEquals(LoginExpectedMessages.LOGIN_FORM_TITLE, restorePasswordForm.getLoginFormTitleText());
        assertEquals(LoginExpectedMessages.REGISTRATION_TAB_TITLE, restorePasswordForm.getTitleRegistrationFormText());
        assertEquals(RestorePasswordExpectedMessages.RESTORE_PASSWORD_FORM_TEXT, restorePasswordForm.getRestorePasswordFormText());
        assertEquals(RestorePasswordExpectedMessages.LABEL_EMAIL_TEXT, restorePasswordForm.getLabelRestorePassword_EmailText());
        assertEquals(RestorePasswordExpectedMessages.BUTTON_RESTORE_TEXT, restorePasswordForm.getButtonSubmitRestoreText());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field.")
    public void verifyErrorMessageForEmptyEmailField() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();
        restorePasswordForm.clickButtonSubmitRestore();

        assertEquals(RestorePasswordExpectedMessages.EMPTY_EMAIL_FIELD_ERROR, restorePasswordForm.getRestorePasswordFormEmailError());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing '@')")
    public void invalidEmailFormatMissingAtTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        String invalidEmail = DataGenerator.generateInvalidEmailMissingAt();
        restorePasswordForm.sendKeysEmail(invalidEmail);
        restorePasswordForm.clickButtonSubmitRestore();

        String expected = String.format(RestorePasswordExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_AT, invalidEmail);
        Assertions.assertEquals(expected, restorePasswordForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verification of error message for unregistered email.")
    public void UnregisteredEmailTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.sendKeysEmail(DataGenerator.generateValidEmail());
        restorePasswordForm.clickButtonSubmitRestore();

        Assertions.assertEquals(RestorePasswordExpectedMessages.UNREGISTERED_EMAIL_MESSAGE, restorePasswordForm.getRestorePasswordUnregisteredEmailError());
    }

    @Test
    @DisplayName("Verification of redirection to registration form. Проверка перехода в форму регистрации")
    public void RegistrationFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.clickTabRegistration();

        assertEquals(RegistrationExpectedMessages.REGISTRATION_TAB_TITLE, restorePasswordForm.getTitleRegistrationFormText());
    }
}
