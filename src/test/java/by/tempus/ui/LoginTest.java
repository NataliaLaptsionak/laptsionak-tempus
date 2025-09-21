package by.tempus.ui;

import by.tempus.ui.pages.HomePage;
import by.tempus.ui.pages.RestorePasswordForm;
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
    @DisplayName("Verification of the login form title. Проверка заголовка на форме логин")
    public void verifyLoginFormTitle() {
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_FORM_TITLE, loginForm.getLoginFormTitleText());
    }

    @Test
    @DisplayName("Verification of fields presence on the login form. Проверка наличия элементов в форме логин")
    public void verifyLoginFormFields() {
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_FORM_TITLE, loginForm.getLoginFormTitleText());
        Assertions.assertEquals(LoginExpectedMessages.EMAIL_FIELD_LABEL, loginForm.getLabelEmailText());
        Assertions.assertEquals(LoginExpectedMessages.PASSWORD_FIELD_LABEL, loginForm.getLabelPasswordText());
        Assertions.assertEquals(LoginExpectedMessages.RESTORE_PASSWORD_FIELD_LABEL, loginForm.getButtonRestorePasswordText());
        Assertions.assertEquals(LoginExpectedMessages.LOGIN_BUTTON_TEXT, loginForm.getButtonLoginText());
        Assertions.assertEquals(LoginExpectedMessages.REGISTRATION_TAB_TITLE, loginForm.getButtonRegistrationFormText());
    }

    @Test
    @DisplayName("Verification of error messages for empty required fields. Проверка сообщений об ошибках для обязательных полей при пустых значениях")
    public void verifyErrorMessagesForEmptyFields() {
        loginForm.clickButtonLogin();
        Assertions.assertEquals(LoginExpectedMessages.EMPTY_EMAIL_FIELD_ERROR, loginForm.getEmptyEmailError());
        Assertions.assertEquals(LoginExpectedMessages.EMPTY_PASSWORD_FIELD_ERROR, loginForm.getEmptyPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field. Проверка сообщения об ошибке для обязательного поля 'Пароль' при пустом значении")
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
///
    @Test
    @DisplayName("Verification of error message for invalid Email format. Проверка сообщения об ошибке для невалидного формата Email")
    public void invalidEmailFormatTest() {
        loginForm.sendKeysLogin(DataGenerator.generateInvalidEmail());
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        Assertions.assertEquals(LoginExpectedMessages.INVALID_EMAIL_FORMAT_ERROR, loginForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verification of error message for unregistered credentials. Проверка сообщения об ошибке при вводе незарегистрированных креденшиалз")
    public void InvalidCredentialsTest() {
        loginForm.sendKeysLogin(DataGenerator.generateValidEmail());
        loginForm.sendKeysPassword(DataGenerator.generateValidPassword());
        loginForm.clickButtonLogin();

        Assertions.assertEquals(LoginExpectedMessages.UNREGISTERED_CREDENTIALS_ERROR, loginForm.getLoginCredentialsError());
    }

    @Test
    @DisplayName("Verification of redirection to password recovery form. Проверка перехода в форму восстановления пароля")
    public void RestorePasswordFormRedirectionTest() {
        loginForm.clickRestorePasswordLink();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();
        Assertions.assertEquals(LoginExpectedMessages.RESTORE_PASSWORD_TEXT, loginForm.getRestorePasswordFormTitleText());
    }

    @Test
    @DisplayName("Verification of redirection to registration form. Проверка перехода в форму регистрации")
    public void RegistrationFormRedirectionTest() {
        loginForm.clickTabRegistration();
        RegistrationForm registrationForm = new RegistrationForm();

        Assertions.assertEquals(LoginExpectedMessages.REGISTRATION_BUTTON_TEXT, registrationForm.getTitleRegistrationTab());
    }
}
