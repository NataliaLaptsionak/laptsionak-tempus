package by.tempus.ui;

import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.login.LoginForm;
import by.tempus.ui.pages.restorePassword.RestorePasswordForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestorePasswordTest extends BaseTest {
    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .сlickButtonLogin();
    }

    @Test
    @DisplayName("Verification of redirection to restore password form form. Проверка перехода в форму восстановления пароля")
    public void RestorePasswordFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        Assertions.assertEquals("Для восстановления пароля, введите Email", restorePasswordForm.getRestorePasswordFormText());
    }

    @Test
    @DisplayName("Verification of elements presence on the restore password form. Проверка наличия элементов на форме восстановления пароля")
    public void verifyRestorePasswordFormFields() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        Assertions.assertEquals("Вход", restorePasswordForm.getLoginFormTitleText());
        Assertions.assertEquals("Регистрация", restorePasswordForm.getTitleRegistrationFormText());
        Assertions.assertEquals("Для восстановления пароля, введите Email", restorePasswordForm.getRestorePasswordFormText());
        Assertions.assertEquals("Email", restorePasswordForm.getLabelRestorePassword_EmailText());
        Assertions.assertEquals("Восстановить", restorePasswordForm.getButtonSubmitRestoreText());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field. Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void verifyErrorMessageForEmptyEmailField() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.clickButtonSubmitRestore();

        Assertions.assertEquals("Это поле обязательно для заполнения.", restorePasswordForm.getRestorePasswordFormEmailError());
    }

    @Test
    @DisplayName("Verification of error message for invalid Email format. Проверка сообщения об ошибке для невалидного формата Email")
    public void invalidEmailFormatTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.sendKeysEmail("testemail.com");
        restorePasswordForm.clickButtonSubmitRestore();

        String expectedMessage = "Введите часть адреса до символа \\\"@\\\". Адрес \\\"@gmail.com\\\" неполный.\", registrationForm.getRegistrationEmailValidationMessage())";

        Assertions.assertEquals(expectedMessage, restorePasswordForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Verification of error message for unregistered email. Проверка сообщения об ошибке при вводе незарегистрированного Email")
    public void InvalidEmailTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.fillRestorePasswordForm("unregisteredemail@.com");


        String expectedMessage = "Неверные учетные данные или пользователь деактивирован\\заблокирован";

        Assertions.assertEquals(expectedMessage, restorePasswordForm.getRestorePasswordUnregisteredEmailError());
    }

    @Test
    @DisplayName("Verification of redirection to registration form. Проверка перехода в форму регистрации")
    public void RegistrationFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickLinkRestorePassword();
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm();

        restorePasswordForm.clickTabRegistration();

        Assertions.assertEquals("Регистрация", restorePasswordForm.getTitleRegistrationFormText());
    }
}
