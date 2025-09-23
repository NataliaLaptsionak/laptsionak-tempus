package by.tempus.ui;

import by.tempus.resources.DataGenerator;
import by.tempus.ui.pages.homePage.HomePage;
import by.tempus.ui.pages.registration.RegistrationExpectedMessages;
import by.tempus.ui.pages.registration.RegistrationForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    private RegistrationForm registrationForm;


    @BeforeEach
    public void setupRegistrationForm() {
        new HomePage()
                .openSite()
                .clickButtonLogin()
                .clickTabRegistration();
    }

    @Test
    @DisplayName("Verification of the registration form title.")
    public void verifyRegistrationFormTitle() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.REGISTRATION_TAB_TITLE, registrationForm.getTitleRegistrationTab());
    }

    @Test
    @DisplayName("Verification of fields presence on the registration form.")
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
    @DisplayName("Verification of error messages for empty required fields.")
    public void verifyErrorMessagesForEmptyRegistrationFields() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_FULL_NAME_ERROR, registrationForm.getRegistrationFullNameError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_EMAIL_ERROR, registrationForm.getRegistrationEmailError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PHONE_ERROR, registrationForm.getRegistrationPhoneError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PASSWORD_ERROR, registrationForm.getRegistrationPasswordError());
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_CHECKBOX_ERROR, registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Full name' field.")
    public void verifyErrorMessageForEmptyFullNameField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_FULL_NAME_ERROR, registrationForm.getRegistrationFullNameError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Email' field.")
    public void verifyErrorMessageForEmptyField() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_EMAIL_ERROR, registrationForm.getRegistrationEmailError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Phone' field.")
    public void verifyErrorMessageForEmptyPhone() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PHONE_ERROR, registrationForm.getRegistrationPhoneError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Password' field.")
    public void verifyErrorMessageForEmptyPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_PASSWORD_ERROR, registrationForm.getRegistrationPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Repeat Password' field.")
    public void verifyErrorMessageForEmptyRepeatPassword() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateValidEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.clickAgreementCheckbox();
        registrationForm.clickButtonRegistration();
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_REPEAT_PASSWORD_ERROR, registrationForm.getRegistrationRepeatPasswordError());
    }

    @Test
    @DisplayName("Verification of error message for empty 'Checkbox'.")
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
        Assertions.assertEquals(RegistrationExpectedMessages.EMPTY_CHECKBOX_ERROR, registrationForm.getAgreementCheckboxError());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing part before '@')")
    public void invalidEmailFormatMissingPartBeforeAtTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        String invalidEmail = DataGenerator.generateInvalidEmailMissingPartBeforeAt();
        registrationForm.sendKeysEmail(invalidEmail);
        registrationForm.clickButtonRegistration();

        String expected = String.format(RegistrationExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_PART_BEFORE_AT, invalidEmail);
        Assertions.assertEquals(expected, registrationForm.getRegistrationEmailValidationMessage());
    }

    @Test
    @DisplayName("Verify message for incorrect email format (missing part after '@')")
    public void invalidEmailFormatMissingPartAfterAtTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        String invalidEmail = DataGenerator.generateInvalidEmailMissingPartAfterAt();
        registrationForm.sendKeysEmail(invalidEmail);
        registrationForm.clickButtonRegistration();

        String expected = String.format(RegistrationExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_PART_AFTER_AT, invalidEmail);
        Assertions.assertEquals(expected, registrationForm.getRegistrationEmailValidationMessage());
    }

    @Test
    @DisplayName("Verify message for incorrect email address (e.g., '1@rtty')")
    public void incorrectEmailAddressTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();
        registrationForm.clickButtonRegistration();

        registrationForm.sendKeysFullName(DataGenerator.generateValidFullName());
        registrationForm.sendKeysEmail(DataGenerator.generateIncorrectEmail());
        registrationForm.sendKeysPhone(DataGenerator.generateValidBelarusianPhoneNumber());
        registrationForm.sendKeysPassword(DataGenerator.generateValidPassword());
        registrationForm.sendKeysRepeatPassword(DataGenerator.generateValidRepeatPassword());
        registrationForm.clickButtonRegistration();

        Assertions.assertEquals(RegistrationExpectedMessages.INCORRECT_EMAIL_ERROR, registrationForm.getIncorrectEmailError());
    }


    @Test
    @DisplayName("Verify message for incorrect email format (missing '@')")
    public void invalidEmailFormatMissingAtTest() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.clickTabRegistration();

        String invalidEmail = DataGenerator.generateInvalidEmailMissingAt();
        registrationForm.sendKeysEmail(invalidEmail);
        registrationForm.clickButtonRegistration();

        String expected = String.format(RegistrationExpectedMessages.INVALID_EMAIL_FORMAT_ERROR_MISSING_AT, invalidEmail);
        Assertions.assertEquals(expected, registrationForm.getRegistrationEmailValidationMessage());
    }
}
