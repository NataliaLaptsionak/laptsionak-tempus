package by.tempus.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    @BeforeEach
    public void openHomePageClickButtonLogIn() {
        new HomePage()
                .openSite()
                .сlickButtonLogin();
    }

    @Test
    @DisplayName("Verification of the registration form title. Проверка заголовка на форме Регистрация")
    public void verifyRegistrationFormTitle() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        Assertions.assertEquals("Регистрация", registrationForm.getTitleRegistrationFormText());
    }

    @Test
    @DisplayName("Verification of fields presence on the registration form. Проверка наличия элементов на форме Регистрация")
    public void verifyLRegistrationFormFields() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        Assertions.assertEquals("Регистрация", registrationForm.getTitleRegistrationFormText());
        Assertions.assertEquals("ФИО", registrationForm.getLabelFulNameFieldText());
        Assertions.assertEquals("Email", registrationForm.getLabelEmailFieldText());
        Assertions.assertEquals("Телефон", registrationForm.getLabelPhoneFieldText());
        Assertions.assertEquals("Пароль", registrationForm.getLabelPasswordFieldText());
        Assertions.assertEquals("Повторить пароль", registrationForm.getLabelRepeatPasswordFieldText());
        Assertions.assertEquals("Я согласен с условиями оферты и политикой конфиденциальности.", registrationForm.getLabelAgreementCheckboxText());
//        registrationForm.clickButtonRegistration();
        Assertions.assertEquals("Регистрация", registrationForm.getButtonRegistrationText());
    }

    @Test
    @DisplayName("Verification of error messages for empty required fields. Проверка сообщений об ошибках для обязательных полей при пустых значениях")
    public void verifyErrorMessagesForEmptyRegistrationFields() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationFullNameError());
        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationEmailError());
        Assertions.assertEquals("Некорректный номер телефона.", registrationForm.getRegistrationPhoneError());
        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationPasswordError());
        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Full name' field. Проверка сообщения об ошибке для обязательного поля 'ФИО' при пустом значении")
    public void verifyErrorMessageForEmptyFullNameField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysEmail("testemail@gmail.com");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysPassword("12345");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationFullNameError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field. Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void verifyErrorMessageForEmptyField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysPassword("12345");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationEmailError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Phone' field. Проверка сообщения об ошибке для обязательного поля 'Телефон' при пустом значении")
    public void verifyErrorMessageForEmptyPhone() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysEmail("testemail@gmail.com");
        registrationForm.sendKeysPassword("12345");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Некорректный номер телефона.", registrationForm.getRegistrationPhoneError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field. Проверка сообщения об ошибке для обязательного поля 'Пароль' при пустом значении")
    public void verifyErrorMessageForEmptyPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysEmail("testemail@gmail.com");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getRegistrationPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field. Проверка сообщения об ошибке для обязательного поля 'Повторить пароль' при пустом значении")
    public void verifyErrorMessageForEmptyRepeatPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysEmail("testemail@gmail.com");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Пароли не совпадают.", registrationForm.getRegistrationRepeatPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Checkbox'. Проверка сообщения об ошибке при незаполнении чекбокса")
    public void verifyErrorMessageForEmptyCheckbox() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysEmail("testemail@gmail.com");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysPassword("12345");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals("Это поле обязательно для заполнения.", registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verification of error message for invalid Email format. Проверка сообщения об ошибке для невалидного формата Email")
    public void invalidEmailFormatTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName("Красновская Екатерина Викторовна");
        registrationForm.sendKeysEmail("@gmail.com");
        registrationForm.sendKeysPhone("+375257605030");
        registrationForm.sendKeysPassword("12345");
        registrationForm.sendKeysRepeatPassword("12345");
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();

//        loginForm.fillLoginForm("testemail.com", "some_password");
//        String expectedMessage = "Адрес электронной почты должен содержать символ \"@\". В адресе \"testemail.com\" отсутствует символ \"@\".";

//        Assertions.assertEquals(expectedMessage, loginForm.getEmailValidationMessage());
        Assertions.assertEquals("Введите часть адреса до символа \"@\". Адрес \"@gmail.com\" неполный.", registrationForm.getRegistrationEmailValidationMessage());
    }

    @Test
    @DisplayName("Verification of redirection to restore password form. Проверка перехода в форму восстановления пароля")
    public void LoginFormRedirectionTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickLoginFormTitle();

//        Assertions.assertEquals("Вход", registrationForm.getLoginFormTitleText());
    }
}
