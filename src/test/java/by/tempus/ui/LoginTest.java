package by.tempus.ui;

import by.tempus.HomePage;
import by.tempus.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .сlickButtonLogin();
    }

    @Test
    @DisplayName("Проверка заголовка на форме входа")
    public void test1() {
        LoginForm loginForm = new LoginForm();
        Assertions.assertEquals("Вход", loginForm.getHeadFormTitleText());
    }

    @Test
    @DisplayName("Проверка сообщений об ошибках для обязательных полей при пустых значениях")
    public void test2() {
        LoginForm loginForm = new LoginForm();
        loginForm.clickButtonLogin();

        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginEmailError());
        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginPasswordError());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке для обязательного поля 'Пароль' при пустом значении")
    public void test3() {
        LoginForm loginForm = new LoginForm();
        loginForm.sendKeysLogin("test.login@gmail.com");
        loginForm.clickButtonLogin();

        Assertions.assertEquals("Это поле обязательно для заполнения.", loginForm.getLoginPasswordError());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void test4() {
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
}
