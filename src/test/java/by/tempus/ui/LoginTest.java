package by.tempus.ui;

import by.tempus.HomePage;
import by.tempus.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты формы логин")
public class LoginTest extends BaseTest {

    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .сlickButtonLogin();
    }

    @Test
    @DisplayName("Проверка заголовка на форме логин")
    public void test1() {
        LoginForm loginForm = new LoginForm();
        Assertions.assertEquals("Вход", loginForm.getHeadFormTitleText());
    }

    @Test
    @DisplayName("Проверка наличия элементов на форме логин")
    public void test2() {
        LoginForm loginForm = new LoginForm();
        Assertions.assertEquals("Вход", loginForm.getHeadFormTitleText());
        Assertions.assertEquals("Email", loginForm.getLabelEmailText());
        Assertions.assertEquals("Пароль", loginForm.getLabelPasswordText());
        Assertions.assertEquals("Восстановить пароль", loginForm.getButtonRestorePasswordText());
        Assertions.assertEquals("Войти в аккаунт", loginForm.getButtonLoginText());
        Assertions.assertEquals("Регистрация", loginForm.getButtonRegistrationFormText());
    }

    @Test
    @DisplayName("Проверка сообщений об ошибках для обязательных полей при пустых значениях")
    public void test3() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickButtonLogin();

        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginEmailError());
        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginPasswordError());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке для обязательного поля 'Пароль' при пустом значении")
    public void test4() {
        LoginForm loginForm = new LoginForm();
        loginForm.sendKeysLogin("test.login@gmail.com");
        loginForm.clickButtonLogin();

        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginPasswordError());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void test5() {
        LoginForm loginForm = new LoginForm();
        loginForm.sendKeysPassword("1111qwerty");
        loginForm.clickButtonLogin();

        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginEmailError());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке для невалидного формата Email")
    public void invalidEmailFormatTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.fillLoginForm("testemail.com", "some_password");

        String expectedMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"testemail.com\" отсутствует символ \"@\".";

        Assertions.assertEquals(expectedMessage, loginForm.getEmailValidationMessage());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при вводе незарегистрированных креденшиалз")
    public void InvalidCredentialsTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.fillLoginForm("test@email.com", "some_password");

        String expectedMessage = "Неверные учетные данные или пользователь деактивирован\\заблокирован";

        Assertions.assertEquals(expectedMessage, loginForm.getLoginCredentialsError());
    }

    @Test
    @DisplayName("Проверка перехода в форму восстановления пароля")
    public void RestorePasswordFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickButtonRestorePassword();

        Assertions.assertEquals("Для восстановления пароля, введите Email", loginForm.getRestorePasswordFormTitleText());
    }

    @Test //
    @DisplayName("Проверка перехода в форму регистрации")
    public void RegistrationFormRedirectionTest() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickButtonRegistrationForm();

        Assertions.assertEquals("Регистрация", loginForm.getButtonRegistrationFormText());
    }
}
