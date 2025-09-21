package by.tempus.ui;

import by.tempus.resources.DataGenerator;
import by.tempus.ui.pages.HomePage;
import by.tempus.ui.pages.registration.RegistrationExpectedMessages;
import by.tempus.ui.pages.registration.RegistrationForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    private RegistrationForm registrationForm;

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
        Assertions.assertEquals(RegistrationExpectedMessages.REGISTRATION_TAB_TITLE, registrationForm.getTitleRegistrationTab());
    }

    @Test
    @DisplayName("Verification of fields presence on the registration form. Проверка наличия элементов на форме Регистрация")
    public void verifyLRegistrationFormFields() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.REGISTRATION_TAB_TITLE, registrationForm.getTitleRegistrationTab());
        Assertions.assertEquals(RegistrationExpectedMessages.FULL_NAME_FIELD_LABEL, registrationForm.getLabelFulNameFieldText());
        Assertions.assertEquals(RegistrationExpectedMessages.EMAIL_FIELD_LABEL, registrationForm.getLabelEmailFieldText());
        Assertions.assertEquals(RegistrationExpectedMessages.PHONE_FIELD_LABEL, registrationForm.getLabelPhoneFieldText());
        Assertions.assertEquals(RegistrationExpectedMessages.PASSWORD_FIELD_LABEL, registrationForm.getLabelPasswordFieldText());
        Assertions.assertEquals(RegistrationExpectedMessages.REPEAT_PASSWORD_FIELD_LABEL, registrationForm.getLabelRepeatPasswordFieldText());
        Assertions.assertEquals(RegistrationExpectedMessages.AGREEMENT_CHECKBOX_LABEL, registrationForm.getLabelAgreementCheckboxText());
        Assertions.assertEquals(RegistrationExpectedMessages.REGISTRATION_BUTTON_TEXT, registrationForm.getButtonRegistrationText());
    }

    @Test
    @DisplayName("Verification of error messages for empty required fields. Проверка сообщений об ошибках для обязательных полей при пустых значениях")
    public void verifyErrorMessagesForEmptyRegistrationFields() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_FULL_NAME_ERROR, registrationForm.getRegistrationFullNameError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_EMAIL, registrationForm.getRegistrationEmailError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PHONE, registrationForm.getRegistrationPhoneError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PASSWORD, registrationForm.getRegistrationPasswordError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_CHECHBOX_ERROR, registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Full name' field. Проверка сообщения об ошибке для обязательного поля 'ФИО' при пустом значении")
    public void verifyErrorMessageForEmptyFullNameField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_FULL_NAME, registrationForm.getRegistrationFullNameError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field. Проверка сообщения об ошибке для обязательного поля 'Email' при пустом значении")
    public void verifyErrorMessageForEmptyField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_EMAIL, registrationForm.getRegistrationEmailError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Phone' field. Проверка сообщения об ошибке для обязательного поля 'Телефон' при пустом значении")
    public void verifyErrorMessageForEmptyPhone() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PHONE, registrationForm.getRegistrationPhoneError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field. Проверка сообщения об ошибке для обязательного поля 'Пароль' при пустом значении")
    public void verifyErrorMessageForEmptyPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.PASSWORD_LENGTH_RESTRICTION, registrationForm.getRegistrationPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field. Проверка сообщения об ошибке для обязательного поля 'Повторить пароль' при пустом значении")
    public void verifyErrorMessageForEmptyRepeatPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.PASSWORD_LENGTH_RESTRICTION, registrationForm.getRegistrationRepeatPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Checkbox'. Проверка сообщения об ошибке при незаполнении чекбокса")
    public void verifyErrorMessageForEmptyCheckbox() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidPassword());
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.AGREEMENT_CHECKBOX_LABEL, registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verification of error message for invalid Email format. Проверка сообщения об ошибке для невалидного формата Email")
    public void invalidEmailFormatTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateInvalidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.INVALID_EMAIL_FORMAT, registrationForm.getRegistrationEmailValidationMessage());
    }


    @Test
    @DisplayName("Verification of redirection to restore password form. Проверка перехода в форму восстановления пароля")
    public void LoginFormRedirectionTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickLoginFormTitle();

        Assertions.assertEquals(RegistrationExpectedMessages.LOGIN_FORM_TITLE, registrationForm.getLoginFormTitleText());
    }
}
